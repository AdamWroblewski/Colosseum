package com.company.model.tournamentTree;

import com.company.model.combat.Combat;
import com.company.model.gladiators.*;

import java.util.Random;

public class TournamentSchedule {

    private Combat[] tournamentSchedule;

    public TournamentSchedule(int numberOfRounds) {
        int numberOfFights = (int) Math.pow(2, numberOfRounds) - 1;
        tournamentSchedule = new Combat[numberOfFights];
    }

    public Combat[] getTournamentSchedule() {
        return tournamentSchedule;
    }
}
