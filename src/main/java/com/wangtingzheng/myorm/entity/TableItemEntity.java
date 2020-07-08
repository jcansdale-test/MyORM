package com.wangtingzheng.myorm.entity;

import com.wangtingzheng.myorm.enums.ItemTypeEnum;

/**
 * @author WangTingZheng
 * @date 2020/7/8 14:43
 * @features
 */
public class TableItemEntity {
    String name;
    ItemTypeEnum type;
    long length;
    boolean isPrimaryKey;

    public TableItemEntity(String name, ItemTypeEnum type, long length, boolean isPrimaryKey) {
        this.name = name;
        this.type = type;
        this.length = length;
        this.isPrimaryKey = isPrimaryKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemTypeEnum getType() {
        return type;
    }

    public void setType(ItemTypeEnum type) {
        this.type = type;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        isPrimaryKey = primaryKey;
    }
}
