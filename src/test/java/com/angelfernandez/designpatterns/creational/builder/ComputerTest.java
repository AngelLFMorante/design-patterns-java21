package com.angelfernandez.designpatterns.creational.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ComputerTest {

    @Test
    void shouldCreateComputer(){
        Computer computer = new Computer.Builder()
                .processor("Intel pentium 4")
                .graphicsCard("3070ti")
                .storage(250)
                .ram(32)
                .wifi(true)
                .bluetooth(false)
                .build();

        assertEquals("Computer{processor='Intel pentium 4', graphicsCard='3070ti', ram=32, storage=250, wifi=true, bluetooth=false}", computer.toString());
    }

    @Test
    void shouldThrowExceptionWhenProcessorIsMissing(){
        IllegalStateException exception = assertThrows(IllegalStateException.class, ()->{
            new Computer.Builder()
                    .processor(null)
                    .graphicsCard("3070ti")
                    .ram(32)
                    .build();
        });
        assertEquals("Procesador no puede estar vacio", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenRamIsZero(){
        IllegalStateException exception = assertThrows(IllegalStateException.class, ()->{
            new Computer.Builder()
                    .processor("Ryzen7")
                    .graphicsCard("3070ti")
                    .ram(0)
                    .build();
        });
        assertEquals("La RAM debe ser mayor que 0", exception.getMessage());
    }

}