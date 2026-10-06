package com.angelfernandez.designpatterns.creational.prototype;

public class PrototypeExample {

    public static void main(String[] args) {
        Enemy enemy = new Enemy("goblin", 100, 35, "Sword");
        Enemy copy = enemy.copy();

        System.out.println("Enemy = " + enemy);
        System.out.println("Copy = " + copy);
        System.out.println("¿Es la misma instancia? " + (enemy == copy));

    }
}
