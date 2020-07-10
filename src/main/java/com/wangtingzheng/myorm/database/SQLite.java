package com.wangtingzheng.myorm.database;

import com.wangtingzheng.myorm.entity.DatabaseConnectionEntity;
import com.wangtingzheng.myorm.exception.ConnectionGetFailed;

import java.sql.Connection;

/**
 * @author WangTingZheng
 * @date 2020/7/8 15:36
 * @features
 */
public class SQLite extends DatabaseLayer{
    public SQLite(DatabaseConnectionEntity databaseConnectionEntity) {
        super(databaseConnectionEntity);
    }

    @Override
    public Connection getConnection() throws ConnectionGetFailed { throw new ConnectionGetFailed("Connection get failed.", this.getClass());
    }
}
