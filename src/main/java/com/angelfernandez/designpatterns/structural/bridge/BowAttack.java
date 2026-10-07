package com.angelfernandez.designpatterns.structural.bridge;

public class BowAttack implements AttackStyle{
    @Override
    public void attack() {
        System.out.println("Ataque con arco");
    }
}
