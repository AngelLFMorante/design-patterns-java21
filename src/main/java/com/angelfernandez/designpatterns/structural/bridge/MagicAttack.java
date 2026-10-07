package com.angelfernandez.designpatterns.structural.bridge;

public class MagicAttack implements AttackStyle{
    @Override
    public void attack() {
        System.out.println("Ataque magico");
    }
}
