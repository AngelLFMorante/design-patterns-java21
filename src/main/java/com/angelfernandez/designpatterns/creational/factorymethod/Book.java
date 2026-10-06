package com.angelfernandez.designpatterns.creational.factorymethod;

public class Book implements LibraryContent{

    @Override
    public void open() {
        System.out.println("Abriendo libro...");
    }
}
