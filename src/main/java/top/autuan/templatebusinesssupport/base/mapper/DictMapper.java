package top.autuan.templatebusinesssupport.base.mapper;

import top.autuan.templatebusinesssupport.base.entity.Dict;
import top.autuan.templatebusinesssupport.base.entity.DictExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictMapper {
    long countByExample(DictExample example);

    int deleteByExample(DictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dict record);

    int insertSelective(@Param("record") Dict record, @Param("selective") Dict.Column ... selective);

    Dict selectOneByExample(DictExample example);

    List<Dict> selectByExample(DictExample example);

    Dict selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dict record, @Param("example") DictExample example, @Param("selective") Dict.Column ... selective);

    int updateByExample(@Param("record") Dict record, @Param("example") DictExample example);

    int updateByPrimaryKeySelective(@Param("record") Dict record, @Param("selective") Dict.Column ... selective);

    int updateByPrimaryKey(Dict record);

    int batchInsert(@Param("list") List<Dict> list);

    int batchInsertSelective(@Param("list") List<Dict> list, @Param("selective") Dict.Column ... selective);
}