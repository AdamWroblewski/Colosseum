package com.company.model.gladiators;

import java.util.Random;

public abstract class Gladiator {

    private Random random = new Random();

    private float baseHP;
    private float baseSP;
    private float baseDex;
    private int lvl;
    private String name;

    public Gladiator() {

    }

    public Gladiator(float hpModifier, float spModifier, float dexModifier) {
        baseHP = generateStatistic() * hpModifier;
        baseSP = generateStatistic() * spModifier;
        baseDex = generateStatistic() * dexModifier;
    }

    private int generateStatistic() {
        int lowerLimit = 1;
        int upperLimit = 100;
        return random.nextInt(100) + 1;
    }

    public void attack() {
        float lowerAttackRange = 0.1F;
        float upperAttackRange = 0.5F;
        float dmg = (float) (lowerAttackRange + Math.random() * (upperAttackRange - lowerAttackRange));
    }

    private int randomizeStatistic(int lowerRange, int upperRange) {
        return random.nextInt(upperRange - lowerRange) + lowerRange;
    }

    public float getHP() {
        return baseHP;
    }

    public float getSP() {
        return baseSP;
    }

    public float getDEX() {
        return baseDex;
    }

    public int getLvl() {
        return lvl;
    }

    protected void advanceLvl() {
        this.lvl++;
    }

    public String getName() {
        return name;
    }
}
