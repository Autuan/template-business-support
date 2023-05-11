package top.autuan.templatebusinesssupport.base.mapper;

import org.apache.ibatis.annotations.Param;
import top.autuan.templatebusinesssupport.base.entity.Feedback;
import top.autuan.templatebusinesssupport.base.entity.FeedbackExample;

import java.util.List;

public interface FeedbackMapper {
    long countByExample(FeedbackExample example);

    int deleteByExample(FeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Feedback record);

    int insertSelective(@Param("record") Feedback record, @Param("selective") Feedback.Column ... selective);

    Feedback selectOneByExample(FeedbackExample example);

    List<Feedback> selectByExample(FeedbackExample example);

    Feedback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Feedback record, @Param("example") FeedbackExample example, @Param("selective") Feedback.Column ... selective);

    int updateByExample(@Param("record") Feedback record, @Param("example") FeedbackExample example);

    int updateByPrimaryKeySelective(@Param("record") Feedback record, @Param("selective") Feedback.Column ... selective);

    int updateByPrimaryKey(Feedback record);

    int batchInsert(@Param("list") List<Feedback> list);

    int batchInsertSelective(@Param("list") List<Feedback> list, @Param("selective") Feedback.Column ... selective);
}