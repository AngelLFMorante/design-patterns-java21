package com.angelfernandez.designpatterns.creational.abstractfactory;

public class DarkCheckbox implements Checkbox{
    @Override
    public void render() {
        System.out.println("Renderizado checkbox oscuro");
    }
}
