package com.wangtingzheng.myorm.exception;

/**
 * @author WangTingZheng
 * @date 2020/7/8 16:12
 * @features
 */
public class TableItemNotFoundException extends Exception{
    Class table;

    public TableItemNotFoundException(String message, Class table) {
        super(message);
        this.table = table;
    }

    public Class getTable() {
        return table;
    }
}
