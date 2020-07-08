package com.wangtingzheng.myorm.reflection;

import com.wangtingzheng.myorm.annotation.OrmItem;
import com.wangtingzheng.myorm.entity.TableEntity;
import com.wangtingzheng.myorm.entity.TableItemEntity;
import com.wangtingzheng.myorm.exception.TableItemNotFoundException;

import java.lang.reflect.Field;


/**
 * @author WangTingZheng
 * @date 2020/7/8 15:49
 * @features
 */
public class TableReflection {
    Class table;

    public TableReflection(Class table) {
        this.table = table;
    }

    public TableEntity toTableEntity() throws TableItemNotFoundException {
        TableEntity tableEntity = new TableEntity();
        for (Field field : table.getDeclaredFields()){
            if (field.isAnnotationPresent(OrmItem.class)){
                OrmItem ormItem = field.getAnnotation(OrmItem.class);
                TableItemEntity tableItemEntity = new TableItemEntity(field.getName(), ormItem.type(), ormItem.length(), ormItem.isPrimaryKey());
                tableEntity.addTableItem(tableItemEntity);
            }
        }
        if (tableEntity.getSize() ==0){
            throw new TableItemNotFoundException("table item not found.", table);
        }
        return tableEntity;
    }
}
