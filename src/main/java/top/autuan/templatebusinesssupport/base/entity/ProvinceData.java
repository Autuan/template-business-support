package top.autuan.templatebusinesssupport.base.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 省级数据
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceData {
    private String code;
    private String name;

    private List<CityData> cityList;
}
