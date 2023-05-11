package top.autuan.templatebusinesssupport.base.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import top.autuan.templatebusinesssupport.base.entity.LogOper;
import org.springframework.stereotype.Service;
import top.autuan.templatebusinesssupport.base.mapper.LogOperMapper;
import top.autuan.templatebusinesssupport.base.service.LogOperService;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class LogOperServiceImpl implements LogOperService {
    private final LogOperMapper logOperMapper;

    @Override
    public void saveLogAsync(LogOper logOper) {
        CompletableFuture.runAsync(()->{
            logOperMapper.insertSelective(logOper);
        });
    }

    @Override
    public void saveLog(LogOper logOper) {
        logOperMapper.insertSelective(logOper);
    }
}
