package com.angelfernandez.designpatterns.structural.adapter;

public class OrcAdapter implements Enemy{

    private final LegacyOrc legacyOrc;

    public OrcAdapter(LegacyOrc legacyOrc) {
        this.legacyOrc = legacyOrc;
    }

    @Override
    public void attack() {
        legacyOrc.strikeWithClub();
    }
}
