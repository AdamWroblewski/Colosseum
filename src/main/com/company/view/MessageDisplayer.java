package com.company.view;

import com.company.model.gladiators.Gladiator;

public class MessageDisplayer {

    public void displayCombatMessage(Gladiator gladiator) {
        if (gladiator.getDamageDealt() > 0)
            System.out.println(String.format("%s deals %s damage", gladiator.getName(), gladiator.getDamageDealt()));
        else
            System.out.println(String.format("%s misses", gladiator.getName()));
    }

    public void displayWholeGladiatorData(Gladiator gladiator) {
        System.out.println(String.format("%s - %s,  %s HP, %s SP, %s DEX, %s LV",
                gladiator.getClass().getSimpleName(), gladiator.getName(),
                gladiator.getHP(), gladiator.getSP(),
                gladiator.getDEX(), gladiator.getLvl()));

    }

    public void displayMessageAfterWinningCombat(Gladiator winner, Gladiator loser) {
        System.out.println(String.format("%s dies, %s has won (new stats: %s HP, %s SP, %s DEX, %s LV)!",
                loser.getName(), winner.getName(),
                winner.getHP(), winner.getSP(),
                winner.getDEX(), winner.getLvl()));
    }
}
