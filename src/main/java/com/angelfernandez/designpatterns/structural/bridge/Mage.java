package com.angelfernandez.designpatterns.structural.bridge;

public class Mage extends Character{

    public Mage(AttackStyle attackStyle) {
        super(attackStyle);
    }

    @Override
    public void performAttack() {
        attackStyle.attack();
    }
}
