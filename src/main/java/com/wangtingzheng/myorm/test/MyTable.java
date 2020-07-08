package com.wangtingzheng.myorm.test;

import com.wangtingzheng.myorm.annotation.OrmItem;
import com.wangtingzheng.myorm.enums.ItemTypeEnum;

/**
 * @author WangTingZheng
 * @date 2020/7/8 9:10
 * @features
 */
public class MyTable {
    @OrmItem(type = ItemTypeEnum.VARCHAR, length = 100, isPrimaryKey = true)
    private String username;

    @OrmItem(type = ItemTypeEnum.VARCHAR, length = 100)
    private String password;

    public MyTable(String database) {
    }
}
