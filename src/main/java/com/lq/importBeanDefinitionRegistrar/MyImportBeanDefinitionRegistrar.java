package com.lq.importBeanDefinitionRegistrar;

import com.lq.service.CacheService;
import com.lq.service.LoggerService;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName MyImportBeanDefinitionRegistrar
 * @Description 自定义导入注册器
 * @Author liqiang
 * @Date 2025/11/17 14:45
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition loggerBeanDefinition = new RootBeanDefinition(LoggerService.class);
        registry.registerBeanDefinition("loggerService",loggerBeanDefinition);
        RootBeanDefinition cacheBeanDefinition = new RootBeanDefinition(CacheService.class);
        registry.registerBeanDefinition("cacheService", cacheBeanDefinition);
    }
}
