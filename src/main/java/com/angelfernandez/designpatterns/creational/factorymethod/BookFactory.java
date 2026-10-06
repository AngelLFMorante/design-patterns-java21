package com.angelfernandez.designpatterns.creational.factorymethod;

public class BookFactory extends ContentFactory{
    @Override
    public LibraryContent createContent() {

        return new Book();
    }
}
