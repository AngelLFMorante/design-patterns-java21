package com.angelfernandez.designpatterns.creational.abstractfactory;

public class LightButton implements Button{
    @Override
    public void render() {
        System.out.println("Renderizado boton claro");
    }
}
