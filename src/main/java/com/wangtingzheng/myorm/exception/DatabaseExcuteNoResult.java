package com.wangtingzheng.myorm.exception;

/**
 * @author WangTingZheng
 * @date 2020/7/9 21:10
 * @features
 */
public class DatabaseExcuteNoResult extends Exception{
    String sql;

    public DatabaseExcuteNoResult(String message, String sql) {
        super(message);
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
