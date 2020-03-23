package com.company.controller;

import com.company.model.combat.Combat;
import com.company.model.gladiators.*;
import com.company.model.tournamentTree.TournamentSchedule;
import com.company.view.MessageDisplayer;

import java.util.Random;

public class TournamentController {

    private static Random random = new Random();
    private TournamentSchedule tournamentSchedule;
    private CombatController combatController;
    private MessageDisplayer messageDisplayer;
    private Combat[] combats;

    public TournamentController(TournamentSchedule tournamentSchedule, MessageDisplayer messageDisplayer) {
        this.tournamentSchedule = tournamentSchedule;
        this.messageDisplayer = messageDisplayer;
        this.combatController = new CombatController(messageDisplayer);
        createTournamentSchedule();
    }

    private void createTournamentSchedule() {
        combats = tournamentSchedule.getTournamentSchedule();
        for (int i = 0; i < combats.length; i++) {
            if (i < combats.length / 2)
                combats[i] = null;
            else
                combats[i] = new Combat(createRandomGladiator(), createRandomGladiator());
        }
    }

    public Gladiator startTournament() {
        for (int i = combats.length - 1; i >= 0; i--) {
            if (combats.length == 1) {
                return combatController.simulateCombat(combats[0]);
            }
            if (i == 0)
                return combatController.simulateCombat(new Combat(
                        combatController.simulateCombat(combats[1]),
                        combatController.simulateCombat(combats[2])));

            if (combats[i] == null) {
                combats[i] = new Combat(
                        combatController.simulateCombat(combats[i * 2 + 1]),
                        combatController.simulateCombat(combats[i * 2 + 2]));
            }
        }
        return null;
    }

    private Gladiator createRandomGladiator() {
        int indicator = random.nextInt(4);
        switch (indicator) {
            case 0:
                return new Swordsman();
            case 1:
                return new Archer();
            case 2:
                return new Brutal();
            case 3:
                return new Assassin();
        }
        return null;
    }

}
