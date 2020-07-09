package com.wangtingzheng.myorm.database;

import com.wangtingzheng.myorm.entity.DatabaseConnectionEntity;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DatabaseLayer {
   public DatabaseConnectionEntity databaseConnectionEntity;

    public DatabaseLayer(DatabaseConnectionEntity databaseConnectionEntity) {
        this.databaseConnectionEntity = databaseConnectionEntity;
    }
    public abstract Connection getConnection() throws SQLException, ClassNotFoundException;
}
