package top.autuan.templatebusinesssupport.base.mapper;

import org.apache.ibatis.annotations.Param;
import top.autuan.templatebusinesssupport.base.entity.LogOper;
import top.autuan.templatebusinesssupport.base.entity.LogOperExample;

import java.util.List;

public interface LogOperMapper {
    long countByExample(LogOperExample example);

    int deleteByExample(LogOperExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LogOper record);

    int insertSelective(@Param("record") LogOper record, @Param("selective") LogOper.Column... selective);

    LogOper selectOneByExample(LogOperExample example);

    List<LogOper> selectByExample(LogOperExample example);

    LogOper selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LogOper record, @Param("example") LogOperExample example, @Param("selective") LogOper.Column... selective);

    int updateByExample(@Param("record") LogOper record, @Param("example") LogOperExample example);

    int updateByPrimaryKeySelective(@Param("record") LogOper record, @Param("selective") LogOper.Column... selective);

    int updateByPrimaryKey(LogOper record);

    int batchInsert(@Param("list") List<LogOper> list);

    int batchInsertSelective(@Param("list") List<LogOper> list, @Param("selective") LogOper.Column... selective);
}