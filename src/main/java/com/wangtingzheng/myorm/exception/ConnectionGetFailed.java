package com.wangtingzheng.myorm.exception;

/**
 * @author WangTingZheng
 * @date 2020/7/9 20:31
 * @features
 */
public class ConnectionGetFailed extends Exception{
    Class clazz;

    public ConnectionGetFailed(String message, Class clazz) {
        super(message);
        this.clazz = clazz;
    }

    public void printStackTrace(){

    }
    public Class getClazz() {
        return clazz;
    }
}
