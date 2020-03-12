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
        Gladiator swordsman2 = new Swordsman();
        Gladiator brutal2 = new Brutal();
        Combat combat2 = new Combat(swordsman2, brutal2);
        Combat combat3 = new Combat(combat.simulateCombat(), combat2.simulateCombat());
        combat3.simulateCombat();
    }
}
