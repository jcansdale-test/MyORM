package com.wangtingzheng.myorm.database;

import com.wangtingzheng.myorm.entity.DatabaseConnectionEntity;

import java.sql.Connection;

/**
 * @author WangTingZheng
 * @date 2020/7/9 19:50
 * @features
 */
public class ExtendSample extends DatabaseLayer {
    public ExtendSample(DatabaseConnectionEntity databaseConnectionEntity) {
        super(databaseConnectionEntity);
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        // put some statements to get connection
        return connection;
    }
}
