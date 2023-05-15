package top.autuan.templatebusinesssupport.base.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import top.autuan.templatebusinesssupport.base.entity.Dict;
import top.autuan.templatebusinesssupport.base.entity.DictExample;
import org.springframework.stereotype.Service;
import top.autuan.templatebusinesssupport.base.mapper.DictMapper;
import top.autuan.templatebusinesssupport.base.service.DictService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class DictServiceImpl implements DictService {

    private final DictMapper dictMapper;

    @Override
    public Map<String, String> queryDictMap() {
        DictExample example = new DictExample();
        example.createCriteria()
                .andEnableEqualTo(0);
        List<Dict> dictList = dictMapper.selectByExample(example);
        Map<String, String> collect = dictList.stream().collect(Collectors.toMap(Dict::getKey, Dict::getVal));
        return collect;
    }
}
