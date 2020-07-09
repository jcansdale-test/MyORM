package com.wangtingzheng.myorm.entity;

import com.wangtingzheng.myorm.exception.TableClassNotFoundException;
import com.wangtingzheng.myorm.reflection.DatabaseReflection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangTingZheng
 * @date 2020/7/8 16:23
 * @features
 */
public class DatabaseEntity {
    List<TableEntity> tableEntities = new ArrayList<>();
    List<Class> tableClasses;
    Class database;

    public DatabaseEntity(Class database) {
        this.database = database;
        this.tableClasses = getTablesClass(database);
    }

    public List<Class> getTableClasses() {
        return tableClasses;
    }

    public List<Class> getTablesClass(Class clazz){
        List<Class> tableClazz = new ArrayList<>();
        try {
              tableClazz = new DatabaseReflection(clazz).getTableClass();
        } catch (TableClassNotFoundException e) {
            e.printStackTrace();
        }
        return tableClazz;
    }
    public DatabaseEntity(List<TableEntity> tableEntities) {
        this.tableEntities = tableEntities;
    }

    public DatabaseEntity() {
    }

    public List<TableEntity> getTableEntities() {
        return tableEntities;
    }

    public void setTableEntities(List<TableEntity> tableEntities) {
        this.tableEntities = tableEntities;
    }

    public void addTableEntity(TableEntity tableEntity){
        tableEntities.add(tableEntity);
    }
    public int getSize(){
        return tableEntities.size();
    }
}
