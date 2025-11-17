package com.lq.selector;

import com.lq.enable.EnableDefineService;
import com.lq.service.CacheService;
import com.lq.service.LoggerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName JavaConfig
 * @Description 测试选择器
 * @Author liqiang
 * @Date 2025/11/17 14:41
 */
@Configuration
@EnableDefineService(
        packages = {"com.lq.service"},
        services = {CacheService.class}  // 可以指定要导入的具体服务
)
public class ImportSelectorTest {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ImportSelectorTest.class);

        System.out.println("=== All Beans ===");
        for (String beanDefinitionName : ac.getBeanDefinitionNames()) {
            // 过滤掉Spring内部的bean，只显示自定义bean
            if (!beanDefinitionName.startsWith("org.springframework") &&
                    !beanDefinitionName.startsWith("spring")) {
                System.out.println("beanDefinitionName = " + beanDefinitionName);
            }
        }

        // 测试Bean是否正常工作
        CacheService cacheService = ac.getBean(CacheService.class);
        cacheService.cacheData("test", "Hello World");

        // 测试LoggerService
        LoggerService loggerService = ac.getBean(LoggerService.class);
        loggerService.log("Hello World");
    }
}
