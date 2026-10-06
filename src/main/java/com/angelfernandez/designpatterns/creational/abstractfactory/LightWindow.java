package com.angelfernandez.designpatterns.creational.abstractfactory;

public class LightWindow implements Window {
    @Override
    public void render() {
        System.out.println("Renderizado window claro");
    }
}
