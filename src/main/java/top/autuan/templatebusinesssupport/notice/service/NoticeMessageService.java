package top.autuan.templatebusinesssupport.notice.service;


import top.autuan.templatebusinesssupport.notice.entity.MessageReadReq;
import top.autuan.templatebusinesssupport.notice.enums.NotificationDictInterface;

import java.util.List;

public interface NoticeMessageService {
    /**
     * 消息已读
     * @param req {@link  MessageReadReq}
     */
    void read(MessageReadReq req);

    /**
     * 添加一条新消息
     * @param receiveUsers 接收人; 全员传 all ; 否则传入要接收消息的用户ID：  `,` 分割
     * @param dict 通知类型：推荐使用枚举： 参考 NotificationDict
     */
    void addNotification( String receiveUsers, NotificationDictInterface dict);

    /**
     * 获取并发送未读消息
     * @param username 用户名
     */
    void obtainAndSendUnreadMsg(String username);
    /**
     * 获取并发送未读消息
     * @param userIdList 用户ID集合
     */
    void obtainAndSendUnreadMsg(Long userId);

    /**
     * 获取并发送未读消息
     * @param userIdList 用户ID集合
     */
    void obtainAndSendUnreadMsg(List<Long> userIdList);

    /**
     * 定时任务：检查系统用户变化
     */
    void checkSysUser();
}
