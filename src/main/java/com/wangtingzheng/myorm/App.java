package com.wangtingzheng.myorm;

import com.wangtingzheng.myorm.apt.DatabaseApt;
import com.wangtingzheng.myorm.apt.TableApt;
import com.wangtingzheng.myorm.test.MyDatabase;
import com.wangtingzheng.myorm.test.MyTable;
import com.wangtingzheng.myorm.util.ReflectUtils;

import java.sql.ResultSet;

/**
 * @author WangTingZheng
 * @date 2020/7/8 9:01
 * @features
 */
public class App{
    public static void main(String[] args) throws Exception {
        /*
        MyDatabase database = new MyDatabase();

        DatabaseApt databaseApt = new DatabaseApt(MyDatabase.class);

        TableApt tableApt = databaseApt.newTableAptInstance("myTable");

        //增加一条用户名是wtz，密码是123的记录
        MyTable table1 = new MyTable();
        table1.setPassword("123");
        table1.setUsername("wtz");
        tableApt.add(table1);

        //删除所有用户名为wtz的记录
        MyTable table2 = new MyTable();
        table2.setUsername("wtz");
        tableApt.delete(table2);

        //修改修改用户名是wtz2的记录为 wtz 123
        MyTable table3 = new MyTable();
        table3.setUsername("wtz2");
        tableApt.update(table3,table1);

        //查询用户名是wtz的记录
        MyTable table4 = new MyTable();
        table4.setUsername("wtz");
        ResultSet resultSet = tableApt.select(table4);

        tableApt.close();*/
        MyTable table = new MyTable();
        table.setUsername("wtz");
        System.out.println(ReflectUtils.getValueOfGet(table,"username"));

    }

}
