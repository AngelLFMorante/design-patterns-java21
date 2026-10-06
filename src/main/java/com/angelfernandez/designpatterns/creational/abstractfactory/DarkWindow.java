package com.angelfernandez.designpatterns.creational.abstractfactory;

public class DarkWindow implements Window {
    @Override
    public void render() {
        System.out.println("Renderizado window oscuro");
    }
}
