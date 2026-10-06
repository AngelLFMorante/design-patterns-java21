package com.angelfernandez.designpatterns.creational.abstractfactory;

public class LightUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }

    @Override
    public Window createWindow() {
        return new LightWindow();
    }
}
