package com.lq.enable;

import com.lq.importBeanDefinitionRegistrar.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Description 启用自定义服务
 * @Author liqiang
 * @Date 2025-11-17 14:47
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyImportBeanDefinitionRegistrar.class)  // 通过注解间接导入
public @interface EnableCustomServices {
}

