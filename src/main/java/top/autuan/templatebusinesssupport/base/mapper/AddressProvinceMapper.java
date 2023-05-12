package top.autuan.templatebusinesssupport.base.mapper;

import org.apache.ibatis.annotations.Param;
import top.autuan.templatebusinesssupport.base.entity.AddressProvince;
import top.autuan.templatebusinesssupport.base.entity.AddressProvinceExample;

import java.util.List;

public interface AddressProvinceMapper {
    long countByExample(AddressProvinceExample example);

    int deleteByExample(AddressProvinceExample example);

    int insert(AddressProvince record);

    int insertSelective(@Param("record") AddressProvince record, @Param("selective") AddressProvince.Column ... selective);

    AddressProvince selectOneByExample(AddressProvinceExample example);

    List<AddressProvince> selectByExample(AddressProvinceExample example);

    int updateByExampleSelective(@Param("record") AddressProvince record, @Param("example") AddressProvinceExample example, @Param("selective") AddressProvince.Column ... selective);

    int updateByExample(@Param("record") AddressProvince record, @Param("example") AddressProvinceExample example);

    int batchInsert(@Param("list") List<AddressProvince> list);

    int batchInsertSelective(@Param("list") List<AddressProvince> list, @Param("selective") AddressProvince.Column ... selective);
}