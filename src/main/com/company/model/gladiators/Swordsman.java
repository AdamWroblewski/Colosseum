package com.company.model.gladiators;

public class Swordsman extends Gladiator {
    private static final int HP_MODIFIER = 1;
    private static final int SP_MODIFIER = 1;
    private static final int DEX_MODIFIER = 1;

    public Swordsman() {
        super(HP_MODIFIER, SP_MODIFIER, DEX_MODIFIER);
    }
}
