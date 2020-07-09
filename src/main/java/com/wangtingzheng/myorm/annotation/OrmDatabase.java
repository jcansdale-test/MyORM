package com.wangtingzheng.myorm.annotation;

import com.wangtingzheng.myorm.database.ExtendSample;
import com.wangtingzheng.myorm.enums.DatabaseTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OrmDatabase {
    DatabaseTypeEnum type() default DatabaseTypeEnum.MYSQL;
    Class extendType() default ExtendSample.class;
    String host() default "localhost:3306";
    String username() default "root";
    String password() default "root";
    String openDatabase() default "sys";
    String serverTimezone() default "UTC";
}
