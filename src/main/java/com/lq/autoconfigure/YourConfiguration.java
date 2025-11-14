package com.lq.autoconfigure;

import com.lq.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName YourConfiguration
 * @Description 配置类
 * @Author liqiang
 * @Date 2025/11/14 14:18
 */
@Configuration
public class YourConfiguration {
    @Bean("primaryProductService")
    public ProductService primaryProductService() {
        return new ProductService();
    }
}
