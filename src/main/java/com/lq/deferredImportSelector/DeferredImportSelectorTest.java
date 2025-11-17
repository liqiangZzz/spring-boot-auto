package com.lq.deferredImportSelector;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName JavaConfig
 * @Description 测试JavaConfig
 * @Author liqiang
 * @Date 2025/11/17 15:40
 */

@Configuration
@Import(MyDeferredImportSelector.class)
public class DeferredImportSelectorTest {

    public static void main(String[] args) {

        new AnnotationConfigApplicationContext(DeferredImportSelectorTest.class);


    }
}
