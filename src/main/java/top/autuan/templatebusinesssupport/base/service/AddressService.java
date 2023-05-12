package top.autuan.templatebusinesssupport.base.service;


import top.autuan.templatebusinesssupport.base.entity.AddressRes;

import java.util.Map;

public interface AddressService {

    /**
     * 获取完整地址信息
     */
    AddressRes all();


    /**
     * 获取映射
     * @return Map< {code} , {名称} >
     */
    Map<String, String> map();
}
