package com.wangtingzheng.myorm.entity;

import com.wangtingzheng.myorm.exception.TableItemNotFoundException;
import com.wangtingzheng.myorm.reflection.TableReflection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangTingZheng
 * @date 2020/7/8 15:37
 * @features
 */
public class TableEntity {
    List<TableItemEntity> tableItemEntities = new ArrayList<>();
    Class table;

    public TableEntity(Class table) {
        this.table = table;

    }

    public TableEntity() {
    }

    public TableEntity(List<TableItemEntity> tableItemEntities) {
        this.tableItemEntities = tableItemEntities;
    }

    public List<TableItemEntity> getTableItems() {
        return tableItemEntities;
    }

    public void setTableItems(List<TableItemEntity> tableItemEntities) {
        this.tableItemEntities = tableItemEntities;
    }

    public void addTableItem(TableItemEntity tableItemEntity){
        this.tableItemEntities.add(tableItemEntity);
    }
    public int getSize(){
        return tableItemEntities.size();
    }

    public Class getTable() {
        return table;
    }
}
