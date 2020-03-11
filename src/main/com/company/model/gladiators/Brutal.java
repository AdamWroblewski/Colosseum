package com.company.model.gladiators;

public class Brutal extends Gladiator {
    private static final float HP_MODIFIER = 1.25F;
    private static final float SP_MODIFIER = 1.25F;
    private static final float DEX_MODIFIER = 0.75F;

    public Brutal(){
        super(HP_MODIFIER, SP_MODIFIER, DEX_MODIFIER);
    }
}