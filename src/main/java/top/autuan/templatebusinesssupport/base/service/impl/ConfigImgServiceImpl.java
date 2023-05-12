package top.autuan.templatebusinesssupport.base.service.impl;

import cn.hutool.db.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import top.autuan.templatebusinesssupport.base.entity.ConfigImg;
import top.autuan.templatebusinesssupport.base.entity.ConfigImgExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.autuan.templatebusinesssupport.base.mapper.ConfigImgMapper;
import top.autuan.templatebusinesssupport.base.service.ConfigImgService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConfigImgServiceImpl implements ConfigImgService {

    private final ConfigImgMapper configImgMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(ConfigImg obj) {
        log.info("ConfigImgServiceImpl -> add -> start  param -> {}", obj);
        configImgMapper.insertSelective(obj);
        log.info("ConfigImgServiceImpl -> add -> end");
    }

    @Override
    public void edit(ConfigImg obj) {
        log.info("ConfigImgServiceImpl -> edit -> start  param -> {}", obj);
        configImgMapper.updateByPrimaryKeySelective(obj);
        log.info("ConfigImgServiceImpl -> edit -> end");
    }

    @Override
    public void abandon(Long id) {
        ConfigImg build = ConfigImg.builder().id(id).delFlag((byte) 1).build();
        log.info("ConfigImgServiceImpl -> abandon -> start  param -> {}", build);
        configImgMapper.updateByPrimaryKeySelective(build);
        log.info("ConfigImgServiceImpl -> abandon -> end param");
    }

    @Override
    public PageInfo<ConfigImg> list(Page page, ConfigImg obj) {
        ConfigImgExample example = new ConfigImgExample();
        ConfigImgExample.Criteria criteria = example.createCriteria();
        Optional<ConfigImg> optionalObj = Optional.ofNullable(obj);
        optionalObj.map(ConfigImg::getStatus).ifPresent(criteria::andStatusEqualTo);
        optionalObj.map(ConfigImg::getId).ifPresent(criteria::andIdEqualTo);
        optionalObj.map(ConfigImg::getType).ifPresent(criteria::andTypeEqualTo);
        optionalObj.map(ConfigImg::getStoreId).ifPresent(criteria::andStoreIdEqualTo);
        optionalObj.map(ConfigImg::getLinkType).ifPresent(criteria::andLinkTypeEqualTo);
        criteria.andDelFlagEqualTo((byte) 0);
        PageHelper.startPage(page.getPageNumber(), page.getPageSize(), "seq  DESC");
        List<ConfigImg> list = configImgMapper.selectByExample(example);
        PageInfo<ConfigImg> result = new PageInfo<>(list);
        return result;
    }

    @Override
    public ConfigImg selectOneByType(Integer type) {
        ConfigImgExample example = new ConfigImgExample();
        example.createCriteria()
                .andDelFlagEqualTo((byte) 0)
                .andTypeEqualTo(type);
        return configImgMapper.selectOneByExample(example);
    }

    @Override
    public List<ConfigImg> listIndexCarousel() {
        ConfigImgExample example = new ConfigImgExample();
        example.createCriteria()
                .andDelFlagEqualTo((byte) 0)
                .andTypeEqualTo(0);
        example.limit(5);
        return configImgMapper.selectByExample(example);
    }

    @Override
    public void toggleStatus(Long id) {
        // todo 只改要改的属性
        ConfigImg img = configImgMapper.selectByPrimaryKey(id);
        Integer status = img.getStatus();
        int newStatus = status == 0 ? 1 : 0;
        img.setStatus(newStatus);
        configImgMapper.updateByPrimaryKeySelective(img);
    }
}
