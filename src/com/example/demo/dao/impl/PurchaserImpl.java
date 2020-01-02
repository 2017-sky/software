package com.example.demo.dao.impl;

import com.example.demo.dao.Purchaser;
import com.example.demo.entity.Food;
import com.example.demo.util.DButil;

import java.sql.ResultSet;
import java.sql.SQLOutput;

public class PurchaserImpl implements Purchaser {
    @Override
    public Food buyFood(String name) {
        Object[] objects = {name};
        System.out.println(name);
        String sql = "select * from food where name=?";
        System.out.println("采购员开始采购食物");
        Food food = DButil.exuteDML(sql,objects);
        System.out.println("采购员采购完成");
        return food;
    }
}
