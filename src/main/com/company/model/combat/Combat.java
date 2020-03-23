package com.company.model.combat;

import com.company.model.gladiators.Gladiator;

public class Combat {

    private Gladiator firstGladiator;
    private Gladiator secondGladiator;
    private boolean isFightEnd = false;
    private Gladiator winner;
    private Gladiator loser;

    public Combat(Gladiator firstGladiator, Gladiator secondGladiator) {
        this.firstGladiator = firstGladiator;
        this.secondGladiator = secondGladiator;
    }

    public Gladiator getFirstGladiator() {
        return firstGladiator;
    }

    public Gladiator getSecondGladiator() {
        return secondGladiator;
    }

    public void simulateTurn(Gladiator[] gladiators) {
        Gladiator attacker = gladiators[0];
        Gladiator defender = gladiators[1];
        attacker.attack(defender);
        if (!defender.isAlive()) {
            winner = attacker;
            loser = defender;
            isFightEnd = true;
        }
    }

    public boolean isFightEnd() {
        return isFightEnd;
    }

    public Gladiator getWinner() {
        return winner;
    }

    public Gladiator getLoser() {
        return loser;
    }
}
