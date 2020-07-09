package com.wangtingzheng.myorm.exception;

/**
 * @author WangTingZheng
 * @date 2020/7/9 20:10
 * @features
 */
public class DatabaseTypeNotFound extends Exception{
    Class clazz;

    public DatabaseTypeNotFound(String message, Class clazz) {
        super(message);
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }
}
