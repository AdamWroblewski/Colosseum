package com.company.model.gladiators;

public class Assassin extends Gladiator {
    private static final float HP_MODIFIER = 0.75F;
    private static final float SP_MODIFIER = 1.25F;
    private static final float DEX_MODIFIER = 1.25F;

    public Assassin(){
        super(HP_MODIFIER, SP_MODIFIER, DEX_MODIFIER);
    }
}