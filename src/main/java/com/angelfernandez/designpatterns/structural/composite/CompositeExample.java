package com.angelfernandez.designpatterns.structural.composite;

public class CompositeExample {

    public static void main(String[] args) {

        EnemyComponent goblin = new Goblin();
        EnemyComponent orc = new Orc();

        EnemyGroup secondaryGroup = new EnemyGroup();
        secondaryGroup.addComponent(new Goblin());
        secondaryGroup.addComponent(new Orc());

        EnemyGroup mainGroup = new EnemyGroup();
        mainGroup.addComponent(goblin);
        mainGroup.addComponent(orc);
        mainGroup.addComponent(secondaryGroup);

        System.out.println("=== ATAQUE DEL GRUPO COMPLETO ===");

        mainGroup.attack();
    }
}