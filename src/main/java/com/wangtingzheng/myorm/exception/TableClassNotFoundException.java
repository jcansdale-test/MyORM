package com.wangtingzheng.myorm.exception;

/**
 * @author WangTingZheng
 * @date 2020/7/9 15:23
 * @features
 */
public class TableClassNotFoundException extends Exception{
    Class database;

    public TableClassNotFoundException(String message, Class database) {
        super(message);
        this.database = database;
    }

    public Class getDatabase() {
        return database;
    }
}
