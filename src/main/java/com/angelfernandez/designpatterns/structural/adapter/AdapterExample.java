package com.angelfernandez.designpatterns.structural.adapter;

public class AdapterExample {
    public static void main(String[] args) {
        Enemy enemy = new OrcAdapter(new LegacyOrc());
        enemy.attack();
    }
}
