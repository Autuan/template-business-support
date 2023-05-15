package top.autuan.templatebusinesssupport.notice.mappere;

import top.autuan.templatebusinesssupport.notice.entity.NoticeNotificationRecord;
import top.autuan.templatebusinesssupport.notice.entity.NoticeNotificationRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeNotificationRecordMapper {
    long countByExample(NoticeNotificationRecordExample example);

    int deleteByExample(NoticeNotificationRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NoticeNotificationRecord record);

    int insertSelective(@Param("record") NoticeNotificationRecord record, @Param("selective") NoticeNotificationRecord.Column ... selective);

    NoticeNotificationRecord selectOneByExample(NoticeNotificationRecordExample example);

    List<NoticeNotificationRecord> selectByExample(NoticeNotificationRecordExample example);

    NoticeNotificationRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NoticeNotificationRecord record, @Param("example") NoticeNotificationRecordExample example, @Param("selective") NoticeNotificationRecord.Column ... selective);

    int updateByExample(@Param("record") NoticeNotificationRecord record, @Param("example") NoticeNotificationRecordExample example);

    int updateByPrimaryKeySelective(@Param("record") NoticeNotificationRecord record, @Param("selective") NoticeNotificationRecord.Column ... selective);

    int updateByPrimaryKey(NoticeNotificationRecord record);

    int batchInsert(@Param("list") List<NoticeNotificationRecord> list);

    int batchInsertSelective(@Param("list") List<NoticeNotificationRecord> list, @Param("selective") NoticeNotificationRecord.Column ... selective);

    int upsert(NoticeNotificationRecord record);

    int upsertSelective(@Param("record") NoticeNotificationRecord record, @Param("selective") NoticeNotificationRecord.Column ... selective);
}