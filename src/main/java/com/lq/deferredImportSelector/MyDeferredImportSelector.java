package com.lq.deferredImportSelector;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName MyDeferredImportSelector
 * @Description
 * @Author liqiang
 * @Date 2025/11/17 15:33
 */
public class MyDeferredImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata metadata) {
        System.out.println("selectImports方法执行了---->");
        return new String[0];
    }

    @Override
    public Class<? extends Group> getImportGroup() {
        System.out.println("getImportGroup");
        return MyDeferredImportSelectorGroup.class;
    }

    public static class MyDeferredImportSelectorGroup implements Group {
        private final List<Entry> imports = new ArrayList<>();

        @Override
        public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
            System.out.println("MyDeferredImportSelectorGroup.Group");
        }

        @Override
        public Iterable<Entry> selectImports() {
            System.out.println("Group中的：selectImports方法");
            return imports;
        }
    }
}
