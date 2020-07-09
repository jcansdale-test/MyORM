package com.wangtingzheng.myorm.exception;

/**
 * @author WangTingZheng
 * @date 2020/7/9 16:32
 * @features
 */
public class DatabaseConnectionAnnotationNotFound extends Exception{
    Class database;

    public DatabaseConnectionAnnotationNotFound(String message, Class database) {
        super(message);
        this.database = database;
    }

    public Class getDatabase() {
        return database;
    }
}
