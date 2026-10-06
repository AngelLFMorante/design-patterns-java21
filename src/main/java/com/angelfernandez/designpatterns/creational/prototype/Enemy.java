package com.angelfernandez.designpatterns.creational.prototype;

public class Enemy {
    private String type;
    private int health;
    private int damage;
    private String weapon;

    public Enemy(String type, int health, int damage, String weapon) {
        this.type = type;
        this.health = health;
        this.damage = damage;
        this.weapon = weapon;
    }

    public Enemy copy(){
        return new Enemy(this.type,this.health,this.damage,this.weapon);
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "type='" + type + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}
