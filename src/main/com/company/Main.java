package com.company;

import com.company.model.gladiators.Assassin;
import com.company.model.gladiators.Gladiator;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Gladiator swordsman = new Assassin();
        System.out.println("hp: " + swordsman.getHP());
        System.out.println("sp: " + swordsman.getSP());
        System.out.println("dex: " + swordsman.getDEX());
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            System.out.println(0.1 + Math.random() * (0.5 - 0.1));
        }
    }
}
