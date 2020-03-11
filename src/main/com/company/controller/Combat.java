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

    public Combat(Gladiator firstGladiator, Gladiator secondGladiator) {
        this.firstGladiator = firstGladiator;
        this.secondGladiator = secondGladiator;
    }

    public void simulateCombat() {

        while (!isFightEnd) {
            simulateTrun(firstGladiator, secondGladiator);
            if (isFightEnd) break;

            simulateTrun(secondGladiator, firstGladiator);
        }
        assert winner != null;
        winner.advanceLvl();
        messageDisplayer.displayMessageAfterWinningCombat(winner, loser);
    }

    private void simulateTrun(Gladiator attacker, Gladiator defender) {
        attacker.attack(defender);
        messageDisplayer.displayCombatMessage(attacker);
        if (defender.getHP() < 0) {
            winner = attacker;
            loser = defender;
            isFightEnd = true;
        }
    }
}
