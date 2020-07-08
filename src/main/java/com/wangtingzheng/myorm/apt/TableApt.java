package com.wangtingzheng.myorm.apt;

import com.wangtingzheng.myorm.annotation.OrmItem;
import com.wangtingzheng.myorm.entity.TableItemEntity;
import com.wangtingzheng.myorm.enums.ItemTypeEnum;
import com.wangtingzheng.myorm.exception.TableItemNotFoundException;
import com.wangtingzheng.myorm.reflection.TableReflection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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

    String createSQL;

    public TableApt(Class table) {
       this.table = table;
       this.tableName = table.getSimpleName();
       getTableItem();
       this.createSQL = generateCreateSQL();
    }
    private void getTableItem(){
        try {
            tableItemEntities = new TableReflection(table).toTableEntity().getTableItems();
        } catch (TableItemNotFoundException e) {
            e.printStackTrace();
        }
    }

   private String generateCreateSQL() {
        String sql = "create table if not exists " + tableName+"(\n";
        for(TableItemEntity tableItemEntity : tableItemEntities) {
            sql = sql + toSQL(tableItemEntity.getName(), tableItemEntity.getType(), tableItemEntity.getLength(), tableItemEntity.isPrimaryKey())+",\n";
        }
        return sql.substring(0, sql.length()-2)+"\n);";
    }

    private String toSQL(String name, ItemTypeEnum type, long length, boolean isPrimaryKey){
        return name +" "+ type +" ("+length+") "+ (isPrimaryKey ?"PRIMARY KEY":"");
    }

    public String getCreateSQL() {
        return createSQL;
    }
}
