package com.wangtingzheng.myorm.exception;

/**
 * @author WangTingZheng
 * @date 2020/7/8 16:01
 * @features
 */
public class DatabaseNotFoundException extends Exception{
    Class database;

    public DatabaseNotFoundException(String message, Class database) {
        super(message);
        this.database = database;
    }

    public Class getDatabase() {
        return database;
    }
}
