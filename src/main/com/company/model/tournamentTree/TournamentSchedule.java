package com.company.model.tournamentTree;

import com.company.controller.Combat;
import com.company.model.gladiators.*;

import java.util.Random;

// todo divide to model and controller
public class TournamentSchedule {

    private Combat[] tournamentSchedule;
    private Random random = new Random();

    public TournamentSchedule(int numberOfRounds) {
        int numberOfFights = (int) Math.pow(2, numberOfRounds) - 1;
        tournamentSchedule = new Combat[numberOfFights];
        for (int i = 0; i < tournamentSchedule.length; i++) {
            if (i < tournamentSchedule.length / 2)
                tournamentSchedule[i] = null;
            else
                tournamentSchedule[i] = new Combat(createRandomGladiator(), createRandomGladiator());
        }
        System.out.println();
    }

    public Gladiator startTournament() {

        for (int i = tournamentSchedule.length - 1; i >= 0; i--) {
            if (tournamentSchedule.length == 1) {
                return tournamentSchedule[0].simulateCombat();
            }
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
