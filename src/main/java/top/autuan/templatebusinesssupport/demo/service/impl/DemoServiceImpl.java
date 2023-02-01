package top.autuan.templatebusinesssupport.demo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.autuan.templatebusinesssupport.demo.mapper.DemoMapper;
import top.autuan.templatebusinesssupport.demo.service.DemoService;

@Slf4j
@Service
@RequiredArgsConstructor
public class DemoServiceImpl implements DemoService {
    private final DemoMapper demoMapper;

    @Override
    public String queryStr() {
        return demoMapper.queryStr();
    }
}
