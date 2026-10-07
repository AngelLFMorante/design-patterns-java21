package com.angelfernandez.designpatterns.structural.bridge;

public class Warrior extends Character{

    public Warrior(AttackStyle attackStyle) {
        super(attackStyle);
    }

    @Override
    public void performAttack() {
        attackStyle.attack();
    }
}
