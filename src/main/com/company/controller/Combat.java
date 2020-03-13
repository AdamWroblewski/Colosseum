package com.company.controller;

import com.company.model.gladiators.Gladiator;
import com.company.view.MessageDisplayer;

// todo rozdzielić na model i kontroler
public class Combat {

    private Gladiator firstGladiator;
    private Gladiator secondGladiator;
    private Gladiator winner = null;
    private Gladiator loser = null;

    private boolean isFightEnd = false;
    private MessageDisplayer messageDisplayer = new MessageDisplayer();

    public Combat() {
    }

    public Combat(Gladiator firstGladiator, Gladiator secondGladiator) {
        this.firstGladiator = firstGladiator;
        this.secondGladiator = secondGladiator;
        messageDisplayer.displayWholeGladiatorData(firstGladiator);
        messageDisplayer.displayWholeGladiatorData(secondGladiator);
    }

    // todo wywoływać tylko raz metodę simulateTurn, przekazać obiekt np. tablicę z gladiatorami
    public Gladiator simulateCombat() {
        messageDisplayer.displayMessageBeforeCombat(firstGladiator, secondGladiator);
        while (!isFightEnd) {
            simulateTurn(firstGladiator, secondGladiator);
            if (isFightEnd) break;

            simulateTurn(secondGladiator, firstGladiator);
            System.out.println();
        }
        assert winner != null;
        winner.advanceLvl();
        messageDisplayer.displayMessageAfterWinningCombat(winner, loser);

        return winner;
    }

    private void simulateTurn(Gladiator attacker, Gladiator defender) {
        attacker.attack(defender);
        messageDisplayer.displayCombatMessage(attacker);
        if (attacker.getDamageDealt() > 0)
            messageDisplayer.displayCurrentHp(defender);
        if (defender.getHP() < 0) {
            winner = attacker;
            loser = defender;
            isFightEnd = true;
        }
    }
}
