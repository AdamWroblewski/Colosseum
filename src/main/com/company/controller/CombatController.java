package com.company.controller;

import com.company.model.combat.Combat;
import com.company.model.gladiators.Gladiator;
import com.company.view.MessageDisplayer;

public class CombatController {

    private MessageDisplayer messageDisplayer;

    public CombatController(MessageDisplayer messageDisplayer) {
        this.messageDisplayer = messageDisplayer;
    }

    public Gladiator simulateCombat(Combat combat) {
        Gladiator firstGladiator = combat.getFirstGladiator();
        Gladiator secondGladiator = combat.getSecondGladiator();
        messageDisplayer.displayMessageBeforeCombat(firstGladiator, secondGladiator);
        Gladiator[] gladiators = {firstGladiator, secondGladiator};

        while (!combat.isFightEnd()) {
            changeGladiatorRoles(gladiators);
            combat.simulateTurn(gladiators);
            messageDisplayer.displayCombatMessage(gladiators[0], gladiators[1]);
            messageDisplayer.println();
        }

        Gladiator winner = combat.getWinner();
        Gladiator loser = combat.getLoser();
        winner.advanceLvl();
        messageDisplayer.displayMessageAfterWinningCombat(winner, loser);
        return winner;
    }

    private static void changeGladiatorRoles(Gladiator[] gladiators) {
        Gladiator buffer = gladiators[0];
        gladiators[0] = gladiators[1];
        gladiators[1] = buffer;
    }
}
