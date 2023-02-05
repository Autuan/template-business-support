package top.autuan.templatebusinesssupport.member.mapper;

import cn.hutool.core.lang.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import top.autuan.templatebusinesssupport.member.entity.MemberExample;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MemberMapperTest {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    void countByExample() {
        MemberExample example = new MemberExample();
        example.createCriteria()
                .andDelFlagEqualTo((byte) 0);
        long l = memberMapper.countByExample(example);
        Assert.isTrue(l > 0);
    }
}