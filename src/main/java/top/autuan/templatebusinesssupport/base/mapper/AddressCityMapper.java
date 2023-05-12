package top.autuan.templatebusinesssupport.base.mapper;

import org.apache.ibatis.annotations.Param;
import top.autuan.templatebusinesssupport.base.entity.AddressCity;
import top.autuan.templatebusinesssupport.base.entity.AddressCityExample;

import java.util.List;

public interface AddressCityMapper {
    long countByExample(AddressCityExample example);

    int deleteByExample(AddressCityExample example);

    int insert(AddressCity record);

    int insertSelective(@Param("record") AddressCity record, @Param("selective") AddressCity.Column ... selective);

    AddressCity selectOneByExample(AddressCityExample example);

    List<AddressCity> selectByExample(AddressCityExample example);

    int updateByExampleSelective(@Param("record") AddressCity record, @Param("example") AddressCityExample example, @Param("selective") AddressCity.Column ... selective);

    int updateByExample(@Param("record") AddressCity record, @Param("example") AddressCityExample example);

    int batchInsert(@Param("list") List<AddressCity> list);

    int batchInsertSelective(@Param("list") List<AddressCity> list, @Param("selective") AddressCity.Column ... selective);
}