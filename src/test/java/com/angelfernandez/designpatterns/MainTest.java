package com.angelfernandez.designpatterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MainTest {

    @Test
    void shouldRunFirstTest(){
        int expect = 2;
        int actual = 1;
        assertNotEquals(expect, actual);
    }

}