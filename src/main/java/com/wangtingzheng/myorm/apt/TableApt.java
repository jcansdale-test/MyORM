package com.wangtingzheng.myorm.apt;

import com.wangtingzheng.myorm.annotation.OrmItem;
import com.wangtingzheng.myorm.entity.TableItemEntity;
import com.wangtingzheng.myorm.enums.ItemTypeEnum;
import com.wangtingzheng.myorm.exception.TableItemNotFoundException;
import com.wangtingzheng.myorm.reflection.ReflectUtils;
import com.wangtingzheng.myorm.reflection.TableReflection;
import com.wangtingzheng.myorm.util.SQL;

import java.lang.reflect.Field;
import java.security.Key;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author WangTingZheng
 * @date 2020/7/8 9:01
 * @features
 */
public class TableApt {
    public Class table;
    public String tableName;
    private List<TableItemEntity> tableItemEntities = new ArrayList<>();

    private Connection connection;
    String databaseName;

    /**
     * table apt 初始化，完成的工作有
     * 通过反射获得表名称
     * 通过反射获得表中定义的数据库属性
     * 生成插件数据库sql语句
     */
    private void init(){
        this.tableName = table.getSimpleName();
        getTableItem();
    }

    public TableApt(Class table) {
       this.table = table;
       init();
    }

    public TableApt(Class table, Connection connection, String databaseName) {
        this.table = table;
        this.connection = connection;
        this.databaseName = databaseName;
        init();
    }

    private void getTableItem(){
        try {
            tableItemEntities = new TableReflection(table).toTableEntity().getTableItems();
        } catch (TableItemNotFoundException e) {
            e.printStackTrace();
        }
    }


    private boolean useDatabase(){
        return SQL.useDatabase(connection, databaseName);
    }

    public boolean create(){
        useDatabase();
        return SQL.createTable(connection, tableName, tableItemEntities);
    }

    private boolean add(HashMap<String,String> value){
        useDatabase();
        return SQL.insert(connection,tableName,value);
    }


    private HashMap<String, String> getItem(Object object){
        Class clazz = object.getClass();
        HashMap<String,String> value = new HashMap<>();
        for(Field field: clazz.getDeclaredFields()){
            if (field.isAnnotationPresent(OrmItem.class)){
                try {
                    Object fieldValueObject = ReflectUtils.getValue(object,field.getName());
                    String fieldValue = "";
                    if (fieldValueObject != null)
                        fieldValue = fieldValueObject.toString();
                        value.put(field.getName(), fieldValue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }
    public boolean add(Object object){
        useDatabase();
        return add(getItem(object));
    }

    private boolean delete(HashMap<String, String> value){
        useDatabase();
        return SQL.delete(connection, tableName, value);
    }

    public boolean delete(Object object){
        useDatabase();
        return delete(getItem(object));
    }

    private boolean update(HashMap<String,String> value){
        return false;
    }
    public boolean update(Object object){
        return update(getItem(object));
    }

    public boolean drop(){
        return SQL.dropTable(connection, tableName);
    }

    /*
    private HashMap<String,String> select(HashMap<String,String> value){
        return ;
    }*/
    public ResultSet select(HashMap<String,String> value){
        return SQL.select(connection,tableName,value);
    }

    public ResultSet select(Object object){
        return select(getItem(object));
    }
    public void close(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
