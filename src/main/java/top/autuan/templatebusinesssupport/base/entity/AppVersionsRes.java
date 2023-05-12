package top.autuan.templatebusinesssupport.base.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppVersionsRes {
    private Integer type;
    private Integer forceFlag;
    private String description;
    private String downloadUrl;
    private String md;
    private String size;

}
