package com.wangtingzheng.myorm.entity;

import com.wangtingzheng.myorm.enums.DatabaseTypeEnum;

/**
 * @author WangTingZheng
 * @date 2020/7/8 15:16
 * @features
 */
public class DatabaseConnectionEntity {
    public DatabaseTypeEnum type;
    public String host;
    public String username;
    public String password;
    public String openDatabase;
    public String serverTimezone;

    public DatabaseConnectionEntity(DatabaseTypeEnum type, String host, String username, String password, String openDatabase, String serverTimezone) {
        this.type = type;
        this.host = host;
        this.username = username;
        this.password = password;
        this.openDatabase = openDatabase;
        this.serverTimezone = serverTimezone;
    }

    public DatabaseTypeEnum getType() {
        return type;
    }

    public void setType(DatabaseTypeEnum type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOpenDatabase() {
        return openDatabase;
    }

    public void setOpenDatabase(String openDatabase) {
        this.openDatabase = openDatabase;
    }

    public String getServerTimezone() {
        return serverTimezone;
    }

    public void setServerTimezone(String serverTimezone) {
        this.serverTimezone = serverTimezone;
    }
}
