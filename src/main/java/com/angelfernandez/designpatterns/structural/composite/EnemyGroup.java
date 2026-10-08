package com.angelfernandez.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class EnemyGroup implements EnemyComponent{

    private final List<EnemyComponent> components = new ArrayList<>();

    public void addComponent(EnemyComponent component){
        components.add(component);
    }

    @Override
    public void attack() {
        components.forEach(EnemyComponent::attack);
    }
}
