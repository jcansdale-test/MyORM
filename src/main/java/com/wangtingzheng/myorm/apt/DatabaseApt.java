package com.wangtingzheng.myorm.apt;

import com.wangtingzheng.myorm.database.Mysql;
import com.wangtingzheng.myorm.database.SQLite;
import com.wangtingzheng.myorm.entity.DatabaseConnectionEntity;
import com.wangtingzheng.myorm.entity.DatabaseEntity;
import com.wangtingzheng.myorm.enums.DatabaseTypeEnum;
import com.wangtingzheng.myorm.exception.DatabaseConnectionAnnotationNotFound;
import com.wangtingzheng.myorm.exception.DatabaseNotFoundException;
import com.wangtingzheng.myorm.exception.TableClassNotFoundException;
import com.wangtingzheng.myorm.exception.TableNotFoundException;
import com.wangtingzheng.myorm.reflection.DatabaseReflection;
import com.wangtingzheng.myorm.util.SQL;

import java.sql.Connection;

/**
 * @author WangTingZheng
 * @date 2020/7/8 12:21
 * @features
 */
public class DatabaseApt {
    public DatabaseConnectionEntity databaseConnectionEntity;
    public Class database;
    public Connection connection;
    public DatabaseEntity databaseEntity;

    public DatabaseApt(Class database) throws TableNotFoundException, DatabaseConnectionAnnotationNotFound {
        this.database = database;
        this.databaseConnectionEntity = getDatabaseConnection();
        this.connection = getConnection();
        this.databaseEntity = getTable(database);
    }

    /**
     * 解析数据库类中的连接信息
     */
    private DatabaseConnectionEntity getDatabaseConnection() throws DatabaseConnectionAnnotationNotFound {
        try {
            return new DatabaseReflection(database).toDatabaseConnectionEntity();
        } catch (DatabaseNotFoundException e) {
            e.printStackTrace();
        }
        throw new DatabaseConnectionAnnotationNotFound("Database connect annotation not found.", database);
    }

    /**
     * 解析数据库类中的表信息
     */
    private DatabaseEntity getTable(Class database) throws TableNotFoundException {
        try {
            return new DatabaseReflection(database).toDatabaseEntity();
        } catch (TableNotFoundException e) {
            e.printStackTrace();
        }
        throw  new TableNotFoundException("Table not found when new databaseApt", database);
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

    /**
     * 返回一个table apt对象，主要的过程是：
     * 通过名称查找数据库下的表，得到表所对应的类
     * 准备好数据库连接对象
     * 准备好数据库名称
     * 通过表类、数据库连接对象、数据库名称创建一个tableApt对象
     * @param name 表的名称
     * @return 表所对应的 tableApt对象
     * @throws TableClassNotFoundException 当数据库类中找不到这个表时，会报错
     */
    public TableApt newTableAptInstance(String name) throws TableClassNotFoundException {

        for(Class myClass: databaseEntity.getTableClasses()){
            if (myClass.getSimpleName().equals(name)){
                return new TableApt(myClass, getConnection(),database.getSimpleName());
            }
        }
        throw new TableClassNotFoundException("Table class not found in database when get new TableApt", database);
    }

    public boolean create(){
        return SQL.createDatabase(connection, database.getSimpleName());
    }
}
