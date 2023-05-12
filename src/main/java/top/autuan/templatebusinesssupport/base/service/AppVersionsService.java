package top.autuan.templatebusinesssupport.base.service;

import top.autuan.templatebusinesssupport.base.entity.AppVersions;
import top.autuan.templatebusinesssupport.base.entity.AppVersionsRes;

import java.util.List;

public interface AppVersionsService {

    AppVersions detail(String version, Integer platform);

    void change(AppVersions versions);

    void add(AppVersions versions);

    AppVersionsRes check(Integer platform, String version);

    List<AppVersions> versionList();
}
