package com.angelfernandez.designpatterns.creational.abstractfactory;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class AbstractFactoryTest {

    @Test
    void shouldCreateLightFamily() {
        UIFactory factory = new LightUIFactory();

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();
        Window window = factory.createWindow();

        assertInstanceOf(LightButton.class, button);
        assertInstanceOf(LightCheckbox.class, checkbox);
        assertInstanceOf(LightWindow.class, window);
    }

    @Test
    void shouldCreateDarkFamily(){
        UIFactory factory = new DarkUIFactory();

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();
        Window window = factory.createWindow();

        assertInstanceOf(DarkButton.class, button);
        assertInstanceOf(DarkCheckbox.class, checkbox);
        assertInstanceOf(DarkWindow.class, window);
    }

}