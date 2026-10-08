package com.angelfernandez.designpatterns.structural.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class CompositeTest {

    @Test
    void shouldTreatGoblinAsEnemyComponent() {

        EnemyComponent enemy = new Goblin();

        assertInstanceOf(Goblin.class, enemy);
    }

    @Test
    void shouldTreatOrcAsEnemyComponent() {

        EnemyComponent enemy = new Orc();

        assertInstanceOf(Orc.class, enemy);
    }

    @Test
    void shouldTreatEnemyGroupAsEnemyComponent() {

        EnemyComponent enemyGroup = new EnemyGroup();

        assertInstanceOf(EnemyGroup.class, enemyGroup);
    }

    @Test
    void shouldAllowNestedEnemyGroups() {

        EnemyGroup mainGroup = new EnemyGroup();
        EnemyGroup secondaryGroup = new EnemyGroup();

        secondaryGroup.addComponent(new Goblin());
        secondaryGroup.addComponent(new Orc());

        mainGroup.addComponent(new Goblin());
        mainGroup.addComponent(secondaryGroup);

        assertInstanceOf(EnemyComponent.class, mainGroup);
        assertInstanceOf(EnemyComponent.class, secondaryGroup);
    }
}