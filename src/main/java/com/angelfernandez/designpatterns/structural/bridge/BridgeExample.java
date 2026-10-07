package com.angelfernandez.designpatterns.structural.bridge;

public class BridgeExample {
    public static void main(String[] args) {
        Warrior warrior = new Warrior(new SwordAttack());
        warrior.performAttack();

        Archer archer = new Archer(new BowAttack());
        archer.performAttack();

        Mage mage = new Mage(new MagicAttack());
        mage.performAttack();
    }
}
