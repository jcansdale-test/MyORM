package com.wangtingzheng.myorm.annotation;

import com.wangtingzheng.myorm.enums.ItemTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OrmItem {
    ItemTypeEnum type();
    long length();
    boolean isPrimaryKey() default false;
}
