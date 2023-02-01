package top.autuan.templatebusinesssupport.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.autuan.templatebusinesssupport.demo.mapper.DemoMapper;
import top.autuan.templatebusinesssupport.demo.service.DemoService;

@Slf4j
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoMapper demoMapper;
    @Override
    public String queryStr() {
        return demoMapper.queryStr();
    }
}
