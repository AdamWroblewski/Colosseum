package com.company.model.gladiators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Gladiator {

    private Random random = new Random();

    private float baseHP;
    private float baseSP;
    private float baseDex;
    private int lvl = 1;
    private String name;
    private float damageDealt;

    private int upperChanceLimit = 100;

    private static List<String> names = new ArrayList<>(Arrays.asList(
            "Flash", "Demon", "Grace", "Wiggles",
            "Lucky", "Torch", "Charisma", "Jumper",
            "Jackal", "Princess", "Buster", "Shorty",
            "Bear", "Mad Dog", "Digger", "Cheery",
            "Smiley", "Bulldog", "Mistletoe", "Starfall",
            "Rip", "Devil", "Jackhammer", "Lock",
            "Indie", "Barber", "Mistletoe", "Bull",
            "Skinny", "Speed", "Knight", "Reaper"));

    public Gladiator(float hpModifier, float spModifier, float dexModifier) {
        name = names.remove(0);
        baseHP = generateStatistic() * hpModifier;
        baseSP = generateStatistic() * spModifier;
        baseDex = generateStatistic() * dexModifier;
    }

    private int generateStatistic() {
        return random.nextInt(upperChanceLimit) + 1; // + 1 to generate random number in range 1-100
    }

    public void attack(Gladiator enemy) {
        int lowerChangeLimit = 10;

        float unclampedChance = this.getDEX() - enemy.getDEX();
        float chance = Math.max(lowerChangeLimit, Math.min(unclampedChance, upperChanceLimit));
        float lowerAttackRange = 0.1F;
        float upperAttackRange = 0.5F;
        damageDealt = (float) (lowerAttackRange + Math.random() * (upperAttackRange - lowerAttackRange)) * this.getSP();

        if (random.nextFloat() * 100 < chance) { // * 100 to alignment of the order of number
            enemy.decreaseHP(enemy, damageDealt);
        } else
            damageDealt = 0;
    }

    private void decreaseHP(Gladiator enemy, float dmg) {
        enemy.baseHP -= dmg;
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

    public void advanceLvl() {
        this.lvl++;
    }

    public String getName() {
        return name;
    }

    public float getDamageDealt() {
        return damageDealt;
    }

    public int getLvl() {
        return lvl;
    }
}
