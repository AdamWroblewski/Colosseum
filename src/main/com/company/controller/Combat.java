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

    public Gladiator simulateCombat() {
        messageDisplayer.displayMessageBeforeCombat(firstGladiator, secondGladiator);
        Gladiator[] gladiators = {firstGladiator, secondGladiator};
        while (!isFightEnd) {
            changeGladiatorRoles(gladiators);
            simulateTurn(gladiators);
            System.out.println();
        }
        assert winner != null;
        winner.advanceLvl();
        messageDisplayer.displayMessageAfterWinningCombat(winner, loser);

        return winner;
    }

    private void changeGladiatorRoles(Gladiator[] gladiators) {
        Gladiator buffer = gladiators[0];
        gladiators[0] = gladiators[1];
        gladiators[1] = buffer;
    }

    private void simulateTurn(Gladiator[] gladiators) {
        Gladiator attacker = gladiators[0];
        Gladiator defender = gladiators[1];
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
