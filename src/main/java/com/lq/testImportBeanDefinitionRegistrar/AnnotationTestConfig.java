package com.lq.testImportBeanDefinitionRegistrar;

import com.lq.enable.EnableCustomServices;
import com.lq.service.CacheService;
import com.lq.service.LoggerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName AnnotationTestConfig
 * @Description
 * @Author liqiang
 * @Date 2025/11/17 14:49
 */
@Configuration
@EnableCustomServices  // 使用自定义注解
public class AnnotationTestConfig {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AnnotationTestConfig.class);

        System.out.println("=== 通过注解注册的Bean ===");
        String[] beanNames = ac.getBeanDefinitionNames();

        for (String beanName : beanNames) {
            if ("loggerService".equals(beanName) || "cacheService".equals(beanName)) {
                Object bean = ac.getBean(beanName);
                System.out.println("找到Bean: " + beanName + " -> " + bean);
            }
        }

        // 验证Bean类型
        verifyBeanTypes(ac);
    }

    private static void verifyBeanTypes(ApplicationContext ac) {
        System.out.println("\n=== Bean类型验证 ===");

        LoggerService loggerService = ac.getBean("loggerService", LoggerService.class);
        CacheService cacheService = ac.getBean("cacheService", CacheService.class);

        System.out.println("LoggerService 类型: " + loggerService.getClass().getName());
        System.out.println("CacheService 类型: " + cacheService.getClass().getName());

        // 验证是否是单例
        LoggerService loggerService2 = ac.getBean("loggerService", LoggerService.class);
        System.out.println("LoggerService 是单例: " + (loggerService == loggerService2));
    }
}
