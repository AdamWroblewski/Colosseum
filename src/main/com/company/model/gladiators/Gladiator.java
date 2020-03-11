package com.company.model.gladiators;

import java.util.Random;

public abstract class Gladiator {

    private Random random = new Random();

    private float baseHP;
    private float baseSP;
    private float baseDex;
    private int lvl = 1;
    private String name;

    public Gladiator() {

    }

    public Gladiator(float hpModifier, float spModifier, float dexModifier) {
        baseHP = generateStatistic() * hpModifier;
        baseSP = generateStatistic() * spModifier;
        baseDex = generateStatistic() * dexModifier;
    }

    private int generateStatistic() {
        int upperLimit = 100;
        return random.nextInt(upperLimit) + 1; // + 1 to generate random number in range 1-100
    }

    public void attack(Gladiator enemy) {
        float unclampedChance = this.getDEX() - enemy.getDEX();
        float chance = Math.max(10, Math.min(unclampedChance, 100));
        float lowerAttackRange = 0.1F;
        float upperAttackRange = 0.5F;
        float dmg = (float) (lowerAttackRange + Math.random() * (upperAttackRange - lowerAttackRange)) * this.getSP();

        if (random.nextFloat() * 100 < chance) {
            enemy.decreaseHP(dmg);
        }
    }

    private void decreaseHP(float dmg) {
        this.baseHP -= dmg / lvl;
    }

    public float getHP() {
        return baseHP * lvl;
    }

    public float getSP() {
        return baseSP * lvl;
    }

    public float getDEX() {
        return baseDex * lvl;
    }

    protected void advanceLvl() {
        this.lvl++;
    }

    public String getName() {
        return name;
    }
}
