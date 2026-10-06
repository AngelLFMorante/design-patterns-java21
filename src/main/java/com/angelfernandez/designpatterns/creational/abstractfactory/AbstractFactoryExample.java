package com.angelfernandez.designpatterns.creational.abstractfactory;

public class AbstractFactoryExample {

    public static void main(String[] args) {
        UIFactory lightFactory = new LightUIFactory();
        ApplicationUI applicationLightUI = new ApplicationUI(lightFactory);

        System.out.println("=== LIGHT THEME ===");
        applicationLightUI.render();

        UIFactory darkFactory = new DarkUIFactory();
        ApplicationUI applicationDarkUI = new ApplicationUI(darkFactory);

        System.out.println("=== DARK THEME ===");
        applicationDarkUI.render();

    }
}
