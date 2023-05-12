package top.autuan.templatebusinesssupport.base.service.impl;

import cn.hutool.core.comparator.VersionComparator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import top.autuan.templatebusinesssupport.base.entity.AppVersions;
import top.autuan.templatebusinesssupport.base.entity.AppVersionsExample;
import top.autuan.templatebusinesssupport.base.entity.AppVersionsRes;
import org.springframework.stereotype.Service;
import top.autuan.templatebusinesssupport.base.mapper.AppVersionsMapper;
import top.autuan.templatebusinesssupport.base.service.AppVersionsService;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppVersionsServiceImpl implements AppVersionsService {
    private final AppVersionsMapper versionsMapper;


    @Override
    public AppVersions detail(String version, Integer platform) {
        AppVersionsExample versionsExample = new AppVersionsExample();
        versionsExample.createCriteria()
                .andVersionEqualTo(version)
                .andPlatformEqualTo(platform)
                .andDelFlagEqualTo((byte) 0);
        AppVersions appVersions = versionsMapper.selectOneByExample(versionsExample);
        return appVersions;
    }

    @Override
    public void change(AppVersions versions) {
        log.info("EshopProdFavorite -> change -> start -> obj -> {}",versions);

        AppVersions appVersions = AppVersions.builder()
                .platform(versions.getPlatform())
                .version(versions.getVersion())
                .updateTime(LocalDateTime.now())
                .build();
        AppVersionsExample example = new AppVersionsExample();
        example.createCriteria()
                .andIdEqualTo(versions.getId());

        versionsMapper.updateByExampleSelective(appVersions, example);
                log.info("EshopProdFavorite -> change -> end -> {}",versions.getId());

    }

    @Override
    public void add(AppVersions versions) {
        versions.setCreateTime(LocalDateTime.now());
        log.info("EshopProdFavorite -> add-> start -> obj -> {}",versions);
        versionsMapper.insertSelective(versions);
        log.info("EshopProdFavorite -> add -> end -> obj -> {}",versions.getVersion());
    }

    @Override
    public AppVersionsRes check(Integer platform, String version) {
        AppVersionsExample example = new AppVersionsExample();
        example.createCriteria()
                .andPlatformEqualTo(platform)
                .andVersionEqualTo(version)
                .andDelFlagEqualTo((byte) 0);
        AppVersions appVersions = versionsMapper.selectOneByExample(example);
        VersionComparator.INSTANCE.compare(version, appVersions.getVersion());
        AppVersionsRes res = new AppVersionsRes();
        res.setType(appVersions.getType());
        res.setForceFlag(appVersions.getForceFlag());
        res.setDownloadUrl(appVersions.getDownloadUrl());
        res.setMd(appVersions.getMd5());
        res.setDescription(appVersions.getDescription());
        return res;
    }

    @Override
    public List<AppVersions> versionList() {
        AppVersionsExample example = new AppVersionsExample();
        example.createCriteria()
                .andDelFlagEqualTo((byte) 0);
        List<AppVersions> appVersions = versionsMapper.selectByExample(example);
        return appVersions;
    }
}
