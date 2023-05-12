package top.autuan.templatebusinesssupport.base.service.impl;

import cn.hutool.core.collection.CollUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.autuan.templatebusinesssupport.base.entity.*;
import top.autuan.templatebusinesssupport.base.mapper.AddressAreaMapper;
import top.autuan.templatebusinesssupport.base.mapper.AddressCityMapper;
import top.autuan.templatebusinesssupport.base.mapper.AddressConfigMapper;
import top.autuan.templatebusinesssupport.base.mapper.AddressProvinceMapper;
import top.autuan.templatebusinesssupport.base.service.AddressService;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressConfigMapper configMapper;

    private final AddressProvinceMapper provinceMapper;

    private final AddressCityMapper cityMapper;

    private final AddressAreaMapper areaMapper;

    private Integer cacheVersion = -1;

    private List<ProvinceData> cacheData;

    private Map<String, String> map;

    @Override
    public AddressRes all() {
        AddressConfigExample example = new AddressConfigExample();
        example.setOrderByClause("version desc");
//        log.info("AddressServiceImpl -> start -> all -> {}",example);
        AddressConfig config = configMapper.selectOneByExample(example);
//        log.info("AddressServiceImpl -> end -> all -> {}",config);
        // todo repeat code
//        Integer version = Optional.ofNullable(config)
//                .map(AddressConfig::getVersion)
//                .orElse(0);
//        if ( ! version.equals(cacheVersion)) {
//            // 初始化数据
//            load();
//        }
//        this.cacheVersion = version;

        tryReload(config);

        AddressRes res = new AddressRes();
        res.setVersion(this.cacheVersion);
        res.setData(this.cacheData);
//        log.info("AddressServiceImpl ->  all -> AddressRes -> {}",res);
        return res;
    }

    private synchronized void load() {
        // 加载省级数据
        AddressProvinceExample provinceExample = new AddressProvinceExample();
        List<AddressProvince> provinces = provinceMapper.selectByExample(provinceExample);
        log.debug("load -> provinces -> size -> {}", provinces.size());

        AddressCityExample cityExample = new AddressCityExample();
        List<AddressCity> allCityList = cityMapper.selectByExample(cityExample);
        log.debug("load -> allCityList -> size -> {}", provinces.size());

        AddressAreaExample areaExample = new AddressAreaExample();
        List<AddressArea> allAreaList = areaMapper.selectByExample(areaExample);
        int areaSize = CollUtil.size(allAreaList);
        log.debug("load -> allAreaList -> size -> {}", allAreaList.size());

        // 生成 code - name 映射 ; 不和生成数据放在一起，易于理解
        int mapSize = CollUtil.size(provinces) + CollUtil.size(allCityList) + (areaSize * 2);
        map = new HashMap<>(mapSize);
        for (AddressProvince item : provinces) {
            map.put("p" + item.getCode(), item.getName());
        }
        for (AddressCity item : allCityList) {
            map.put("c" + item.getCode(), item.getName());
        }
        for (AddressArea item : allAreaList) {
            map.put("a" + item.getCityCode() + item.getCode(), item.getName());
            map.put("a" + item.getCode(), item.getName());
        }

        // 生成响应回的数据结构
        List<CityData> cityDataList = new ArrayList<>();
        log.info("class -> method -> allCityList.size -> {}", CollUtil.size(allCityList));
        for (AddressCity city : allCityList) {
            List<AreaData> filterCityList = allAreaList.stream()
                    .filter(area -> city.getCode().equals(area.getCityCode()))
                    .map(this::convert)
                    .collect(Collectors.toList());
            CityData cityData = new CityData();
            cityData.setCode(city.getCode());
            cityData.setName(city.getName());
            cityData.setAreaList(filterCityList);
            cityDataList.add(cityData);
        }

        List<ProvinceData> provinceDataList = new ArrayList<>();
        for (AddressProvince province : provinces) {
            Set<String> cityCodeSet = allCityList.stream()
                    .filter(city -> province.getCode().equals(city.getProvinceCode()))
                    .map(AddressCity::getCode)
                    .collect(Collectors.toSet());
            List<CityData> cityList = cityDataList.stream()
                    .filter(city -> cityCodeSet.contains(city.getCode()))
                    .collect(Collectors.toList());

            ProvinceData provinceData = new ProvinceData();
            provinceData.setCode(province.getCode());
            provinceData.setName(province.getName());
            provinceData.setCityList(cityList);

            provinceDataList.add(provinceData);
        }

        cacheData = provinceDataList;

    }

    private AreaData convert(AddressArea data) {
        AreaData result = new AreaData();
        result.setCode(data.getCityCode() + data.getCode());
        result.setName(data.getName());
        return result;
    }

    @Override
    public Map<String, String> map() {
        AddressConfigExample example = new AddressConfigExample();
        example.setOrderByClause("version desc");
        log.debug("AddressServiceImpl ->  start -> map -> {}", example);
        AddressConfig config = configMapper.selectOneByExample(example);
        log.debug("AddressServiceImpl ->  end -> map -> {}", config);
//        Integer version = Optional.ofNullable(config)
//                .map(AddressConfig::getVersion)
//                .orElse(0);
//        if ((! version.equals(cacheVersion))  ) {
//            // 初始化数据
//            load();
//        }
//        this.cacheVersion = version;

        tryReload(config);
        log.debug("AddressServiceImpl ->  map -> version -> {}", this.cacheVersion);
        return this.map;
    }

    private void tryReload(AddressConfig config) {
        Integer version = Optional.ofNullable(config)
                .map(AddressConfig::getVersion)
                .orElse(0);
        if ((!version.equals(cacheVersion))) {
            // 初始化数据
            load();
        }
        this.cacheVersion = version;
    }
}
