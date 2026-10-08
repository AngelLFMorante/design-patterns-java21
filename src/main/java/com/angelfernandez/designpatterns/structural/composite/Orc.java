package com.angelfernandez.designpatterns.structural.composite;

public class Orc implements EnemyComponent{
    @Override
    public void attack() {
        System.out.println("Orco ataca con su maza");
    }
}
