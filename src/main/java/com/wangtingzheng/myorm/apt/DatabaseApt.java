package com.wangtingzheng.myorm.apt;

import com.wangtingzheng.myorm.database.Mysql;
import com.wangtingzheng.myorm.database.SQLite;
import com.wangtingzheng.myorm.entity.DatabaseConnectionEntity;
import com.wangtingzheng.myorm.entity.DatabaseEntity;
import com.wangtingzheng.myorm.enums.DatabaseTypeEnum;
import com.wangtingzheng.myorm.exception.DatabaseNotFoundException;
import com.wangtingzheng.myorm.exception.TableNotFoundException;
import com.wangtingzheng.myorm.reflection.DatabaseReflection;

import java.sql.Connection;

/**
 * @author WangTingZheng
 * @date 2020/7/8 12:21
 * @features
 */
public class DatabaseApt {
    public DatabaseConnectionEntity databaseConnectionEntity;
    Class database;

    DatabaseEntity databaseEntity;

    public DatabaseApt(Class database) {
        this.database = database;
        getTable();
        getDatabaseConnection();
    }

    /**
     * 解析数据库类中的连接信息
     */
    public void getDatabaseConnection(){
        try {
            databaseConnectionEntity = new DatabaseReflection(database).toDatabaseConnectionEntity();
        } catch (DatabaseNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析数据库类中的表信息
     */
    public void getTable(){
        try {
            databaseEntity = new DatabaseReflection(database).toDatabaseEntity();
        } catch (TableNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用获得的数据库连接信息进行连接，获得连接
     * @return 获得的连接
     */
    public Connection getConnection(){
        if (databaseConnectionEntity.type == DatabaseTypeEnum.MYSQL){
            return new Mysql(databaseConnectionEntity).getConnection();
        }else if (databaseConnectionEntity.type == DatabaseTypeEnum.SQLITE){
            return new SQLite(databaseConnectionEntity).getConnection();
        }
        return null;
    }



}
