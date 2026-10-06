package com.angelfernandez.designpatterns.creational.abstractfactory;

public class DarkUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }

    @Override
    public Window createWindow() {
        return new DarkWindow();
    }
}
