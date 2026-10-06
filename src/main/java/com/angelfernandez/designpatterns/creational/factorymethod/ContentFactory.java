package com.angelfernandez.designpatterns.creational.factorymethod;

public abstract class ContentFactory {

    public abstract LibraryContent createContent();

    public void openContent() {
        LibraryContent content = createContent();
        content.open();
    }
}
