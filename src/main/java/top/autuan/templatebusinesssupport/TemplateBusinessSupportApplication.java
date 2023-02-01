package top.autuan.templatebusinesssupport;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.autuan.templatebusinesssupport.**.mapper")
public class TemplateBusinessSupportApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateBusinessSupportApplication.class, args);
    }

}
