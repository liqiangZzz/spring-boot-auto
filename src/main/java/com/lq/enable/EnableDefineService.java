package com.lq.enable;

import com.lq.selector.MyDefineImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @ClassName EnableDefineService
 * @Description 启用自定义服务
 * @Author liqiang
 * @Date 2025/11/17 14:36
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited  // 允许被继承
@Import(MyDefineImportSelector.class)
public @interface EnableDefineService {

    String[] packages() default "";

    // 添加配置选项，可以动态选择要导入的服务
    Class<?>[] services() default {};
}
