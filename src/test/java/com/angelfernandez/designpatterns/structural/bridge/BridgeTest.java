package com.angelfernandez.designpatterns.structural.bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    @Test
    void shouldCreateWarriorWithSwordAttack(){
        Warrior warrior = new Warrior(new SwordAttack());

        assertInstanceOf(SwordAttack.class, warrior.attackStyle);
    }

    @Test
    void shouldCreateWarriorWithMagicAttack(){
        Warrior warrior = new Warrior(new MagicAttack());

        assertInstanceOf(MagicAttack.class, warrior.attackStyle);
    }
}