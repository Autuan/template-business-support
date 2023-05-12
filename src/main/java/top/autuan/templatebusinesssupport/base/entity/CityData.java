package top.autuan.templatebusinesssupport.base.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 市级数据
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityData {
    private String code;
    private String name;

    /**
     * 区
     */
    private List<AreaData> areaList;
}
