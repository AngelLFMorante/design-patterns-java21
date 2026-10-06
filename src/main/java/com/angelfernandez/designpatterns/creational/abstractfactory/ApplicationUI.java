package com.angelfernandez.designpatterns.creational.abstractfactory;

public class ApplicationUI {

    private final Button button;
    private final Checkbox checkbox;
    private final Window window;

    public ApplicationUI(UIFactory factory) {
        this.checkbox = factory.createCheckbox();
        this.window = factory.createWindow();
        this.button = factory.createButton();
    }

    public void render(){
        button.render();
        checkbox.render();
        window.render();
    }
}
