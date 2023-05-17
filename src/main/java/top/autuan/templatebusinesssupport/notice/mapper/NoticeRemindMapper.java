package top.autuan.templatebusinesssupport.notice.mapper;

import top.autuan.templatebusinesssupport.notice.entity.NoticeRemind;
import top.autuan.templatebusinesssupport.notice.entity.NoticeRemindExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeRemindMapper {
    long countByExample(NoticeRemindExample example);

    int deleteByExample(NoticeRemindExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NoticeRemind record);

    int insertSelective(@Param("record") NoticeRemind record, @Param("selective") NoticeRemind.Column ... selective);

    NoticeRemind selectOneByExample(NoticeRemindExample example);

    List<NoticeRemind> selectByExample(NoticeRemindExample example);

    NoticeRemind selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NoticeRemind record, @Param("example") NoticeRemindExample example, @Param("selective") NoticeRemind.Column ... selective);

    int updateByExample(@Param("record") NoticeRemind record, @Param("example") NoticeRemindExample example);

    int updateByPrimaryKeySelective(@Param("record") NoticeRemind record, @Param("selective") NoticeRemind.Column ... selective);

    int updateByPrimaryKey(NoticeRemind record);

    int batchInsert(@Param("list") List<NoticeRemind> list);

    int batchInsertSelective(@Param("list") List<NoticeRemind> list, @Param("selective") NoticeRemind.Column ... selective);

    int upsert(NoticeRemind record);

    int upsertSelective(@Param("record") NoticeRemind record, @Param("selective") NoticeRemind.Column ... selective);
}