package com.company.model.tournamentTree;

import com.company.controller.Combat;
import com.company.model.gladiators.Gladiator;
import com.company.model.gladiators.Swordsman;

public class TournamentSchedule {
    private Combat[] tournamentSchedule;

    public TournamentSchedule(int numberOfRounds) {
        int numberOfFights = (int) Math.pow(2, numberOfRounds) - 1;
        tournamentSchedule = new Combat[numberOfFights];
        for (int i = 0; i < tournamentSchedule.length; i++) {
            if (i < tournamentSchedule.length / 2)
                tournamentSchedule[i] = null;
            else
                tournamentSchedule[i] = new Combat(new Swordsman(), new Swordsman());
        }
        System.out.println();
    }

    public Gladiator startTournament() {

        for (int i = tournamentSchedule.length - 1; i >= 0; i--) {
            if (i == 0)
                return new Combat(tournamentSchedule[1].simulateCombat(),
                        tournamentSchedule[2].simulateCombat()).simulateCombat();

            if (tournamentSchedule[i] == null) {
                tournamentSchedule[i] = new Combat(tournamentSchedule[i * 2 + 1].simulateCombat(),
                        tournamentSchedule[i * 2 + 2].simulateCombat());
            }
        }
        return null;
    }
}
