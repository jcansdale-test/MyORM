package com.wangtingzheng.myorm.database;

import com.wangtingzheng.myorm.entity.DatabaseConnectionEntity;
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
    public Connection getConnection() {
        return null;
    }
}
