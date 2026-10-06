package com.angelfernandez.designpatterns.creational.prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrototypeTest {

    @Test
    void shouldCreateDifferentInstance (){
        Enemy enemy = new Enemy("wizard", 100, 55, "magic");
        Enemy copy = enemy.copy();

        assertNotSame(enemy, copy);
    }

    @Test
    void shouldCopyEnemyData (){
        Enemy enemy = new Enemy("wizard", 100, 55, "magic");
        Enemy copy = enemy.copy();

        assertEquals(enemy.toString(), copy.toString());
    }
}