package com.wangtingzheng.myorm.entity;

import java.util.List;

/**
 * @author WangTingZheng
 * @date 2020/7/8 16:23
 * @features
 */
public class DatabaseEntity {
    List<TableEntity> tableEntities;

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
