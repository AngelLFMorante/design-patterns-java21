package com.angelfernandez.designpatterns.creational.factorymethod;

public class MagazineFactory extends ContentFactory{
    @Override
    public LibraryContent createContent() {
        return new Magazine();
    }
}
