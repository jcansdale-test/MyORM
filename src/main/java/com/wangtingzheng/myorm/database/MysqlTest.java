package com.wangtingzheng.myorm.database;

import com.wangtingzheng.myorm.entity.DatabaseConnectionEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author WangTingZheng
 * @date 2020/7/9 20:13
 * @features
 */
public class MysqlTest extends DatabaseLayer{
    private String DATABASE_URL = "jdbc:mysql://";
    public MysqlTest(DatabaseConnectionEntity databaseConnectionEntity) {
        super(databaseConnectionEntity);

    }
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        DATABASE_URL = DATABASE_URL + databaseConnectionEntity.getHost()+"/" + databaseConnectionEntity.getOpenDatabase()+"?serverTimezone="+ databaseConnectionEntity.getServerTimezone();
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        Class.forName(DRIVER);
        return DriverManager.getConnection(DATABASE_URL, databaseConnectionEntity.getUsername(), databaseConnectionEntity.getPassword());
    }
}
