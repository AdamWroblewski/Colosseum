package com.company;

import com.company.controller.Combat;
import com.company.model.gladiators.Brutal;
import com.company.model.gladiators.Gladiator;
import com.company.model.gladiators.Swordsman;

public class Main {


    public static void main(String[] args) {
        Gladiator swordsman = new Swordsman();
        Gladiator brutal = new Brutal();
        Combat combat = new Combat(swordsman, brutal);
        combat.simulateCombat();
    }
}
