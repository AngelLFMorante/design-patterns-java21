package com.angelfernandez.designpatterns.creational.abstractfactory;

public class DarkButton implements Button{
    @Override
    public void render() {
        System.out.println("Renderizado boton oscuro");
    }
}
