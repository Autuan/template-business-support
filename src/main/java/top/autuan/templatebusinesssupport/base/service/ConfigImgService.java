package top.autuan.templatebusinesssupport.base.service;

import cn.hutool.db.Page;
import com.github.pagehelper.PageInfo;
import top.autuan.templatebusinesssupport.base.entity.ConfigImg;

import java.util.List;

public interface ConfigImgService {
    void add(ConfigImg obj);

    void edit(ConfigImg obj);

    void abandon(Long id);

    PageInfo<ConfigImg> list(Page page, ConfigImg obj);

    ConfigImg selectOneByType(Integer type);

    List<ConfigImg> listIndexCarousel();

    void toggleStatus(Long id);
}
