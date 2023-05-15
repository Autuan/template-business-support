package top.autuan.templatebusinesssupport.demo.service;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.RetryableErrorHandler;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class DemoServiceTest {
    @Autowired
    private DemoService demoService;


    @Test
    void
    queryStr() {
        String str = demoService.queryStr();
        log.info("DemoServiceTest -> queryStr -> str -> {}",str);

        Assert.notNull(str);
    }
}