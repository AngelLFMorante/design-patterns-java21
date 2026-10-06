package com.angelfernandez.designpatterns.creational.factorymethod;

public class AudiobookFactory extends ContentFactory{
    @Override
    public LibraryContent createContent() {
        return new Audiobook();
    }
}
