package com.angelfernandez.designpatterns.creational.abstractfactory;

public interface UIFactory {

    Button createButton();
    Checkbox createCheckbox();
    Window createWindow();

}
