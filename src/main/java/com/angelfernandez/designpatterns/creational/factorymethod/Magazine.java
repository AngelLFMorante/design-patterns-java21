package com.angelfernandez.designpatterns.creational.factorymethod;

public class Magazine implements LibraryContent{
    @Override
    public void open() {
        System.out.println("Abriendo Magazine...");
    }
}
