package top.autuan.templatebusinesssupport.base.mapper;

import org.apache.ibatis.annotations.Param;
import top.autuan.templatebusinesssupport.base.entity.AddressConfig;
import top.autuan.templatebusinesssupport.base.entity.AddressConfigExample;

import java.util.List;

public interface AddressConfigMapper {
    long countByExample(AddressConfigExample example);

    int deleteByExample(AddressConfigExample example);

    int insert(AddressConfig record);

    int insertSelective(@Param("record") AddressConfig record, @Param("selective") AddressConfig.Column ... selective);

    AddressConfig selectOneByExample(AddressConfigExample example);

    List<AddressConfig> selectByExample(AddressConfigExample example);

    int updateByExampleSelective(@Param("record") AddressConfig record, @Param("example") AddressConfigExample example, @Param("selective") AddressConfig.Column ... selective);

    int updateByExample(@Param("record") AddressConfig record, @Param("example") AddressConfigExample example);

    int batchInsert(@Param("list") List<AddressConfig> list);

    int batchInsertSelective(@Param("list") List<AddressConfig> list, @Param("selective") AddressConfig.Column ... selective);
}