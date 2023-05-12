package top.autuan.templatebusinesssupport.base.mapper;

import org.apache.ibatis.annotations.Param;
import top.autuan.templatebusinesssupport.base.entity.AddressArea;
import top.autuan.templatebusinesssupport.base.entity.AddressAreaExample;

import java.util.List;

public interface AddressAreaMapper {
    long countByExample(AddressAreaExample example);

    int deleteByExample(AddressAreaExample example);

    int insert(AddressArea record);

    int insertSelective(@Param("record") AddressArea record, @Param("selective") AddressArea.Column ... selective);

    AddressArea selectOneByExample(AddressAreaExample example);

    List<AddressArea> selectByExample(AddressAreaExample example);

    int updateByExampleSelective(@Param("record") AddressArea record, @Param("example") AddressAreaExample example, @Param("selective") AddressArea.Column ... selective);

    int updateByExample(@Param("record") AddressArea record, @Param("example") AddressAreaExample example);

    int batchInsert(@Param("list") List<AddressArea> list);

    int batchInsertSelective(@Param("list") List<AddressArea> list, @Param("selective") AddressArea.Column ... selective);
}