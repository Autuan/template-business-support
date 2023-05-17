package top.autuan.templatebusinesssupport.notice.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.autuan.templatebusinesssupport.notice.entity.*;
import top.autuan.templatebusinesssupport.notice.enums.MessageStatueEnum;
import top.autuan.templatebusinesssupport.notice.enums.NotificationDict;
import top.autuan.templatebusinesssupport.notice.enums.NotificationDictInterface;
import top.autuan.templatebusinesssupport.notice.enums.WebSocketMsgType;
import top.autuan.templatebusinesssupport.notice.mapper.NoticeNotificationMapper;
import top.autuan.templatebusinesssupport.notice.mapper.NoticeNotificationRecordMapper;
import top.autuan.templatebusinesssupport.notice.mapper.NoticeRemindMapper;
import top.autuan.templatebusinesssupport.notice.service.NoticeMessageService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NoticeMessageServiceImpl implements NoticeMessageService {
    @Autowired
    private NoticeNotificationMapper noticeMapper;
    @Autowired
    private NoticeNotificationRecordMapper noticeRecordMapper;
    @Autowired
    private NoticeRemindMapper noticeRemindMapper;

//    private Map<Long, SysUser> userMap;
    private List<Long> existUserIdList;

    public NoticeMessageServiceImpl() {
        // todo 分页条件
//        List<SysUser> userList = customSysUserMapper.listAllSysUser();
//        userMap = userList.stream()
//                .collect(Collectors.toMap(SysUser::getUserId, Function.identity(), (oldV, newV) -> newV));
//        existUserIdList = userList.stream()
//                .map(SysUser::getUserId)
//                .collect(Collectors.toList());
//        this.customSysUserMapper = customSysUserMapper;
    }

    @Override
    public void read(MessageReadReq req) {
        Long msgId = req.getMsgId();
        Long userId = req.getUserId();
        // 0-remind
        switch (req.getType()) {
            case 0: {
                NoticeRemindExample example = new NoticeRemindExample();
                example.createCriteria()
                        .andIdEqualTo(msgId)
                        .andActionAimUserIdEqualTo(userId);
                NoticeRemind bean = NoticeRemind.builder()
                        .state(MessageStatueEnum.READ.ordinal())
                        .updateBy(String.valueOf(userId))
                        .updateTime(LocalDateTime.now())
                        .build();
//                noticeRemindMapper.updateByExample(bean, example);

                break;
            }
            // notification
            case 1: {
                NoticeNotificationExample example = new NoticeNotificationExample();
                example.createCriteria()
                        .andKindEqualTo(req.getKind())
                        .andStateEqualTo(MessageStatueEnum.UNREAD.ordinal())
                        .andReceiverUserIdEqualTo(userId)
                ;
                NoticeNotification notification = NoticeNotification.builder()
                        .state(MessageStatueEnum.READ.ordinal())
                        .updateBy(String.valueOf(userId))
                        .updateTime(LocalDateTime.now())
                        .build();
//                noticeMapper.updateByExampleSelective(notification, example);

                NoticeNotificationRecordExample recordExample = new NoticeNotificationRecordExample();
                recordExample.createCriteria()
                        .andKindEqualTo(req.getKind())
                        .andReceiverUserIdEqualTo(userId);
                NoticeNotificationRecord record = NoticeNotificationRecord.builder()
                        .state(MessageStatueEnum.READ.ordinal())
                        // todo sysUserId repeat
                        .updateBy(String.valueOf(userId))
                        .updateTime(LocalDateTime.now())
                        .pullTime(LocalDateTime.now())
                        .build();
                noticeRecordMapper.updateByExampleSelective(record, recordExample);
            }
            default: {
                break;
            }
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addNotification(String receiveUsers, NotificationDictInterface dict) {
        boolean isAll = StrUtil.isBlankOrUndefined(receiveUsers) || "all".equals(receiveUsers);
        List<Long> receiveUserIdList = null;

        // 检查 type 值
        // 0-all 1-single 2-multipart
        Integer type = null;
        if (isAll) {
            type = 0;
//            receiveUserIdList = userMap.values().stream()
//                    .map(SysUser::getUserId)
//                    .collect(Collectors.toList());
        } else {
            receiveUserIdList = StrUtil.splitTrim(receiveUsers, ",").stream()
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
            // split 后，目标用户不为1便是多用户
            type = CollUtil.size(receiveUserIdList) == 1 ? 1 : 2;
        }
        // 如果是单用户通知的话，只写入notification
        Long receiveUserId = null;
        if (type == 1) {
            receiveUserId = Long.parseLong(receiveUsers);
        }
        NoticeNotification bean = NoticeNotification.builder()
                .type(type)
                .receiverUserId(receiveUserId)
                .createBy(String.valueOf(receiveUserId))
                .createTime(LocalDateTime.now())
                .title(dict.getTitle())
                .build();


        noticeMapper.insertSelective(bean);

        if (CollUtil.isNotEmpty(receiveUserIdList)) {
            List<NoticeNotificationRecord> list = new ArrayList<>();
            for (Long userId : receiveUserIdList) {
                NoticeNotificationRecord record = NoticeNotificationRecord.builder()
                        .notificationId(bean.getId())
                        .receiverUserId(userId)
                        .state(MessageStatueEnum.UNREAD.ordinal())
                        .kind(dict.getKind())
                        .deptId(0L)
                        // todo enum
                        .delFlag("0")
                        .createBy(String.valueOf(userId))
                        .createTime(LocalDateTime.now())
                        .build();
                list.add(record);
            }
            noticeRecordMapper.batchInsert(list);
        }

        // 写入完成后发送通知
        obtainAndSendUnreadMsg(receiveUserIdList);
    }

    @Override
    public void obtainAndSendUnreadMsg(String username) {
        if(StrUtil.isBlankOrUndefined(username)) {
            return;
        }
//        for (SysUser user : userMap.values()) {
//            if(user.getUserName().equals(username)) {
//                obtainAndSendUnreadMsg(user.getUserId());
//                break;
//            }
//        }
    }

    @Override
    public void obtainAndSendUnreadMsg(Long userId) {
        obtainAndSendUnreadMsg(Collections.singletonList(userId));
    }

    public void checkSysUser() {
//        Integer changeNum = customSysUserMapper.countUser(existUserIdList);
//        // 统计超过0 ， 说明有用户变更
//        if (changeNum > 0) {
//            log.info("DeeHeroManagerMessageServiceImpl -> checkSysUser -> changeNum -> {}", changeNum);
//            // todo repeat code
//            List<SysUser> userList = customSysUserMapper.listAllSysUser();
//            userMap = userList.stream()
//                    .collect(Collectors.toMap(SysUser::getUserId, Function.identity(), (oldV, newV) -> newV));
//            existUserIdList = userList.stream()
//                    .map(SysUser::getUserId)
//                    .collect(Collectors.toList());
//        }
    }


    @Override
    public void obtainAndSendUnreadMsg(List<Long> userIdList) {
        // notification 通知
        NoticeNotificationExample noticeExample = new NoticeNotificationExample();
        noticeExample.createCriteria()
                .andReceiverUserIdIn(userIdList)
                .andStateEqualTo(MessageStatueEnum.UNREAD.ordinal());
        List<NoticeNotification> unreadNoticeList = noticeMapper.selectByExample(noticeExample);
        Map<Long, List<NoticeNotification>> unreadNoticeMap = unreadNoticeList.stream()
                .collect(Collectors.groupingBy(NoticeNotification::getReceiverUserId));

        // notification record 通知
        NoticeNotificationRecordExample recordExample = new NoticeNotificationRecordExample();
        recordExample.createCriteria()
                .andReceiverUserIdIn(userIdList)
                .andStateEqualTo(MessageStatueEnum.UNREAD.ordinal());
        List<NoticeNotificationRecord> unreadRecordList = noticeRecordMapper.selectByExample(recordExample);

        Map<Long, List<NoticeNotificationRecord>> unreadRecordMap = unreadRecordList.stream()
                .collect(Collectors.groupingBy(NoticeNotificationRecord::getReceiverUserId));

        for (Long userId : userIdList) {
            List<SocketNoticeItem> list = new ArrayList<>();
            List<NoticeNotification> userUnreadNoticeList = unreadNoticeMap.get(userId);
            if (CollUtil.isNotEmpty(userUnreadNoticeList)) {
                Map<Integer, List<NoticeNotification>> notificationKindMap = userUnreadNoticeList.stream()
                        .collect(Collectors.groupingBy(NoticeNotification::getKind));

                notificationKindMap.forEach((kind, notifications) -> {
                    NotificationDict enumDict = NotificationDict.switchDict(kind);

                    SocketNoticeItem item = SocketNoticeItem.builder()
                            .title(enumDict.getTitle())
                            .num(notifications.size())
                            .kind(enumDict.getKind())
                            .pageUrl(enumDict.getPageUrl())
                            .pageTitle(enumDict.getPageTitle())
                            .build();

                    list.add(item);
                });
            }

            List<NoticeNotificationRecord> userUnreadRecordList = unreadRecordMap.get(userId);
            if (CollUtil.isNotEmpty(userUnreadRecordList)) {
                Map<Integer, List<NoticeNotificationRecord>> recordKindMap = userUnreadRecordList.stream()
                        .collect(Collectors.groupingBy(NoticeNotificationRecord::getKind));

                recordKindMap.forEach((kind, notifications) -> {
                    NotificationDict enumDict = NotificationDict.switchDict(kind);

                    SocketNoticeItem item = SocketNoticeItem.builder()
                            .title(enumDict.getTitle())
                            .num(notifications.size())
                            .kind(enumDict.getKind())
                            .pageUrl(enumDict.getPageUrl())
                            .pageTitle(enumDict.getPageTitle())
                            .build();

                    list.add(item);
                });
            }

//            String username = userMap.get(userId).getUserName();

            SocketMsgRes message = new SocketMsgRes(WebSocketMsgType.NOTIFICATION.getType(), list);
//            ManagerMessageWebSocketUsers.sendMessage(username, JSONUtil.toJsonStr(message));
        }

    }
}
