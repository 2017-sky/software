package com.example.demo.service.impl;

import com.example.demo.dao.Purchaser;
import com.example.demo.dao.impl.PurchaserImpl;
import com.example.demo.entity.Food;
import com.example.demo.service.Chef;

public class ChefImpl implements Chef {
    private Purchaser purchaser = new PurchaserImpl();

    @Override
    public Food cookEggplant(String name) {
        System.out.println("厨师接收到菜单");
        Food food = purchaser.buyFood(name);
        System.out.println("厨师得到食材开始做菜");
        System.out.println("做菜完成，传至服务员");
        return food;
    }
}
