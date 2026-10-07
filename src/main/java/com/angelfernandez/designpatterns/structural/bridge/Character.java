package com.angelfernandez.designpatterns.structural.bridge;

public abstract class Character {

    protected AttackStyle attackStyle;

    public Character(AttackStyle attackStyle) {
        this.attackStyle = attackStyle;
    }

    public abstract void performAttack();
}
