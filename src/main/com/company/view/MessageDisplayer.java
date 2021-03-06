package com.company.view;

import com.company.model.combat.Combat;
import com.company.model.gladiators.Gladiator;

import java.util.Scanner;

public class MessageDisplayer {

    Scanner scanner = new Scanner(System.in);

    public void displayCombatMessage(Gladiator attacker, Gladiator defender) {
        if (attacker.getDamageDealt() > 0) {
            System.out.println(String.format("%s deals %s damage", attacker.getName(), attacker.getDamageDealt()));
            displayDefenderCurrentHp(defender);
        } else
            System.out.println(String.format("%s misses", attacker.getName()));
    }

    public void displayWholeGladiatorData(Gladiator gladiator) {
        System.out.println(String.format("%s - %s,  %s HP, %s SP, %s DEX, %s LV",
                gladiator.getClass().getSimpleName(), gladiator.getName(),
                gladiator.getHP(), gladiator.getSP(),
                gladiator.getDEX(), gladiator.getLvl()));

    }

    public void displayAllGladiatorsInfo(Combat[] combats) {
        for (Combat combat : combats) {
            if (combat != null) {
                displayWholeGladiatorData(combat.getFirstGladiator());
                displayWholeGladiatorData(combat.getSecondGladiator());
                println();
            }
        }
    }

    public void displayMessageBeforeCombat(Gladiator firstGladiator, Gladiator secondGladiator) {
        System.out.println();
        System.out.println("Fight between: ");
        displayWholeGladiatorData(firstGladiator);
        displayWholeGladiatorData(secondGladiator);
        System.out.println("To start combat press enter.");
//        try {
//            System.in.read();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void displayMessageAfterWinningCombat(Gladiator winner, Gladiator loser) {
        System.out.println(String.format("%s dies, %s has won (new stats: %s HP, %s SP, %s DEX, %s LV)!",
                loser.getName(), winner.getName(),
                winner.getHP(), winner.getSP(),
                winner.getDEX(), winner.getLvl()));
    }

    private void displayDefenderCurrentHp(Gladiator gladiator) {
        System.out.println(String.format("%s has %s HP left", gladiator.getName(), gladiator.getHP()));
    }

    public void displayWinnerOfTournament(Gladiator gladiator) {
        System.out.println("The winner of tournament is: ");
        displayWholeGladiatorData(gladiator);
    }

    public void displayWelcomeMessage() {
        System.out.println("Ave and welcome to the Colosseum! How many stages of the Tournament do you wish to watch? : ");
    }

    public void println() {
        System.out.println();
    }
}
