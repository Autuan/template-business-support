package top.autuan.templatebusinesssupport.base.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 区级数据
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AreaData {
    private String code;
    private String name;

}
