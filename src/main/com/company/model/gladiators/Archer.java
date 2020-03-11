package com.company.model.gladiators;

public class Archer extends Gladiator {
    private static final int HP_MODIFIER = 1;
    private static final int SP_MODIFIER = 1;
    private static final float DEX_MODIFIER = 1.25F;

    public Archer() {
        super(HP_MODIFIER, SP_MODIFIER, DEX_MODIFIER);
    }
}
