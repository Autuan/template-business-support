package top.autuan.templatebusinesssupport.base.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressRes {
    private Integer version;
    private List<ProvinceData> data;
}
