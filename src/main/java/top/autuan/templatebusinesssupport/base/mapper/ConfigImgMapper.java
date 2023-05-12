package top.autuan.templatebusinesssupport.base.mapper;

import top.autuan.templatebusinesssupport.base.entity.ConfigImg;
import top.autuan.templatebusinesssupport.base.entity.ConfigImgExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConfigImgMapper {
    long countByExample(ConfigImgExample example);

    int deleteByExample(ConfigImgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ConfigImg record);

    int insertSelective(@Param("record") ConfigImg record, @Param("selective") ConfigImg.Column ... selective);

    ConfigImg selectOneByExample(ConfigImgExample example);

    List<ConfigImg> selectByExample(ConfigImgExample example);

    ConfigImg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ConfigImg record, @Param("example") ConfigImgExample example, @Param("selective") ConfigImg.Column ... selective);

    int updateByExample(@Param("record") ConfigImg record, @Param("example") ConfigImgExample example);

    int updateByPrimaryKeySelective(@Param("record") ConfigImg record, @Param("selective") ConfigImg.Column ... selective);

    int updateByPrimaryKey(ConfigImg record);

    int batchInsert(@Param("list") List<ConfigImg> list);

    int batchInsertSelective(@Param("list") List<ConfigImg> list, @Param("selective") ConfigImg.Column ... selective);
}