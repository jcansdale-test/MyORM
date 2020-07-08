package com.wangtingzheng.myorm.reflection;

import com.wangtingzheng.myorm.annotation.OrmDatabase;
import com.wangtingzheng.myorm.annotation.OrmTable;
import com.wangtingzheng.myorm.entity.DatabaseConnectionEntity;
import com.wangtingzheng.myorm.entity.DatabaseEntity;
import com.wangtingzheng.myorm.entity.TableEntity;
import com.wangtingzheng.myorm.exception.DatabaseNotFoundException;
import com.wangtingzheng.myorm.exception.TableItemNotFoundException;
import com.wangtingzheng.myorm.exception.TableNotFoundException;

import java.lang.reflect.Field;

/**
 * @author WangTingZheng
 * @date 2020/7/8 15:55
 * @features
 */
public class DatabaseReflection {
    Class database;

    public DatabaseReflection(Class database) {
        this.database = database;
    }

    public DatabaseConnectionEntity toDatabaseConnectionEntity() throws DatabaseNotFoundException {
        if (database.isAnnotationPresent(OrmDatabase.class)){
            OrmDatabase ormDatabase = (OrmDatabase) database.getAnnotation(OrmDatabase.class);
            return new DatabaseConnectionEntity(ormDatabase.type(),ormDatabase.host(),ormDatabase.username(),ormDatabase.password(),ormDatabase.openDatabase(),ormDatabase.serverTimezone());
        }
        else {
            throw new DatabaseNotFoundException("Database annotation not found.", database);
        }
    }
    public DatabaseEntity toDatabaseEntity() throws TableNotFoundException {
        DatabaseEntity  databaseEntity = new DatabaseEntity();
        for(Field field: database.getFields()){
            if (field.isAnnotationPresent(OrmTable.class)){
                try {
                    databaseEntity.addTableEntity(new TableReflection(field.getClass()).toTableEntity());
                } catch (TableItemNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        if (databaseEntity.getSize() == 0){
            throw new TableNotFoundException("Table not found in this database class", database);
        }
        return databaseEntity;
    }
}
