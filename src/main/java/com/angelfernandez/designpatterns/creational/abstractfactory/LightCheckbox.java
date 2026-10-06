package com.angelfernandez.designpatterns.creational.abstractfactory;

public class LightCheckbox implements Checkbox{
    @Override
    public void render() {
        System.out.println("Renderizado checkbox claro");
    }
}
