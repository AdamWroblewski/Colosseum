package com.company.model.tournamentTree;

import com.company.controller.Combat;
import com.company.model.gladiators.Gladiator;
import com.company.model.gladiators.Swordsman;

public class TournamentSchedule {
    private Combat[] tournamentSchedule;
    private static int numberOfFights;

    public TournamentSchedule(int numberOfRounds) {
        numberOfFights = (int) Math.pow(2, numberOfRounds) - 1;
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

        while (numberOfFights > 0) {
            numberOfFights /= 2;

            for (int i = numberOfFights; i > numberOfFights / 2; i--) {
//                if (i == 0) {
//                    tournamentSchedule[0] = new Combat(
//                            tournamentSchedule[1].simulateCombat(),
//                            tournamentSchedule[2].simulateCombat()
//                    );
//                    return tournamentSchedule[0].simulateCombat();
//                }
                if (i == 1) {
                    System.out.println(i);
                    tournamentSchedule[i - 1] = new Combat(
                            tournamentSchedule[i].simulateCombat(),
                            tournamentSchedule[i + 1].simulateCombat()
                    );
                } else {
                    tournamentSchedule[i] = new Combat(
                            tournamentSchedule[i + 1].simulateCombat(),
                            tournamentSchedule[i + 2].simulateCombat()
                    );
                }
            }
        }

        return null;
    }
}
