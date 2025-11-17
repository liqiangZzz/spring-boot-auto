package com.lq.selector;

import com.lq.enable.EnableDefineService;
import com.lq.service.CacheService;
import com.lq.service.LoggerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;
import java.util.Map;


/**
 * @ClassName MyDefineImportSelector
 * @Description 自定义导入选择器
 * @Author liqiang
 * @Date 2025/11/17 14:36
 */
@Slf4j
public class MyDefineImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        // 获取注解属性
        Map<String, Object> attributes = annotationMetadata.getAnnotationAttributes(
                EnableDefineService.class.getName());

        if (attributes != null) {
            AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(attributes);

            // 获取配置的包路径
            String[] packages = annotationAttributes.getStringArray("packages");
            log.info("Scanning packages: {}", Arrays.toString(packages));

            // 获取配置的服务类
            Class<?>[] serviceClasses = annotationAttributes.getClassArray("services");

            // 如果指定了服务类，返回指定的类；否则返回默认的类
            if (serviceClasses.length > 0) {
                return Arrays.stream(serviceClasses)
                        .map(Class::getName)
                        .toArray(String[]::new);
            }
        }

        // 默认返回 CacheService 和 LoggerService
        log.info("Using default service imports");
        return new String[]{
                CacheService.class.getName(),
                LoggerService.class.getName()
        };
    }
}
