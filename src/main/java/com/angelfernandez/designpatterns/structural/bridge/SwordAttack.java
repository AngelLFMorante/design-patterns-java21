package com.angelfernandez.designpatterns.structural.bridge;

public class SwordAttack implements AttackStyle{
    @Override
    public void attack() {
        System.out.println("Ataque con espada");
    }
}
