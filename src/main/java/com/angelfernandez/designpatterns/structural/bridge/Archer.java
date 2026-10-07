package com.angelfernandez.designpatterns.structural.bridge;

public class Archer extends Character{

    public Archer(AttackStyle attackStyle) {
        super(attackStyle);
    }

    @Override
    public void performAttack() {
        attackStyle.attack();
    }
}
