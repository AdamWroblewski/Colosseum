package com.company.controller;

import com.company.model.gladiators.Gladiator;
import com.company.view.MessageDisplayer;

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

    public Gladiator simulateCombat() {

        while (!isFightEnd) {
            simulateTurn(firstGladiator, secondGladiator);
            if (isFightEnd) break;

            simulateTurn(secondGladiator, firstGladiator);
        }
        assert winner != null;
        winner.advanceLvl();
        messageDisplayer.displayMessageAfterWinningCombat(winner, loser);

        return winner;
    }

    private void simulateTurn(Gladiator attacker, Gladiator defender) {
        attacker.attack(defender);
        messageDisplayer.displayCombatMessage(attacker);
        if (defender.getHP() < 0) {
            winner = attacker;
            loser = defender;
            isFightEnd = true;
        }
    }
}
