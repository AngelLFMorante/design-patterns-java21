package com.angelfernandez.designpatterns.structural.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class AdapterTest {


    @Test
    void shouldAdaptLegacyOrcToEnemy(){
        Enemy enemy = new OrcAdapter(new LegacyOrc());

        assertInstanceOf(OrcAdapter.class, enemy);
    }
}