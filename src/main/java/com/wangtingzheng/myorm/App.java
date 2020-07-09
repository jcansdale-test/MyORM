package com.wangtingzheng.myorm;

import com.wangtingzheng.myorm.apt.DatabaseApt;
import com.wangtingzheng.myorm.apt.TableApt;
import com.wangtingzheng.myorm.test.MyDatabase;
import com.wangtingzheng.myorm.test.MyTable;
import com.wangtingzheng.myorm.reflection.ReflectUtils;

import java.security.Key;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author WangTingZheng
 * @date 2020/7/8 9:01
 * @features
 */
public class App{
    public static void main(String[] args) throws Exception {

        DatabaseApt databaseApt = new DatabaseApt(MyDatabase.class);
        databaseApt.create();

        TableApt tableApt = databaseApt.newTableAptInstance("MyTable");
        tableApt.create();



        //增加一条用户名是wtz，密码是123的记录
        MyTable table1 = new MyTable();
        table1.setPassword("123");
        table1.setUsername("wtz");
        tableApt.add(table1);

        MyTable table3 = new MyTable();
        table1.setPassword("123");
        table1.setUsername("wtz2");
        tableApt.add(table1);

        MyTable table2 = new MyTable();
        table2.setPassword("123");
        //table2.setUsername("wtz");
        ResultSet set = tableApt.select(table2);
        ResultSetMetaData resultSetMetaData =  set.getMetaData();
        int cols = resultSetMetaData.getColumnCount();
        while (set.next()){
            for (int i = 0; i < cols; i++) {
                System.out.println(resultSetMetaData.getColumnName(i+1)+" "+set.getString(i+1));
            }
        }
        tableApt.drop();





        //tableApt.drop();




        /*
        //删除所有用户名为wtz的记录
        MyTable table2 = new MyTable();
        table2.setUsername("wtz");
        tableApt.delete(table2);
        */

        /*
        //修改修改用户名是wtz的密码为 1234
        MyTable table3 = new MyTable();
        table3.setUsername("wtz");
        table3.setPassword("1234");
        tableApt.update(table3);

        /*
        //查询用户名是wtz的记录
        MyTable table4 = new MyTable();
        table4.setUsername("wtz");
        ResultSet resultSet = tableApt.select(table4);

        tableApt.close();*/
    }

}
