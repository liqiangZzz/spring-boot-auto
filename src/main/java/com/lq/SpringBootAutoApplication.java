package com.lq;

import com.lq.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @ClassName SpringBootAutoApplication
 * @Description  启动类
 * @Author liqiang
 * @Date 2025/11/7 16:49
 */
@Import(com.lq.config.ConditionalConfig.class)
@SpringBootApplication
public class SpringBootAutoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootAutoApplication.class, args);

        // 获取特定的Bean
        System.out.println(context.getBean("primaryProductService", ProductService.class));
        System.out.println(context.getBean("conditionalProductService", ProductService.class));

    }

}
