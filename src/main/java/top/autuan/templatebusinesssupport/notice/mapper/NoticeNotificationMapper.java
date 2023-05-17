package top.autuan.templatebusinesssupport.notice.mapper;

import top.autuan.templatebusinesssupport.notice.entity.NoticeNotification;
import top.autuan.templatebusinesssupport.notice.entity.NoticeNotificationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeNotificationMapper {
    long countByExample(NoticeNotificationExample example);

    int deleteByExample(NoticeNotificationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NoticeNotification record);

    int insertSelective(@Param("record") NoticeNotification record, @Param("selective") NoticeNotification.Column ... selective);

    NoticeNotification selectOneByExample(NoticeNotificationExample example);

    List<NoticeNotification> selectByExample(NoticeNotificationExample example);

    NoticeNotification selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NoticeNotification record, @Param("example") NoticeNotificationExample example, @Param("selective") NoticeNotification.Column ... selective);

    int updateByExample(@Param("record") NoticeNotification record, @Param("example") NoticeNotificationExample example);

    int updateByPrimaryKeySelective(@Param("record") NoticeNotification record, @Param("selective") NoticeNotification.Column ... selective);

    int updateByPrimaryKey(NoticeNotification record);

    int batchInsert(@Param("list") List<NoticeNotification> list);

    int batchInsertSelective(@Param("list") List<NoticeNotification> list, @Param("selective") NoticeNotification.Column ... selective);

    int upsert(NoticeNotification record);

    int upsertSelective(@Param("record") NoticeNotification record, @Param("selective") NoticeNotification.Column ... selective);
}