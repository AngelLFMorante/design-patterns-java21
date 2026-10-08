package com.angelfernandez.designpatterns.structural.composite;

public class Goblin implements EnemyComponent{
    @Override
    public void attack() {
        System.out.println("Goblin ataca con su daga");
    }
}
