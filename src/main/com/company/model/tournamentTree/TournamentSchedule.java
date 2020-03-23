package com.company.model.tournamentTree;

import com.company.model.combat.Combat;

public class TournamentSchedule implements Tournamentable {

    private Combat[] tournamentSchedule;

    public void prepareTournamentSchedule(int numberOfRounds) {
        int numberOfFights = (int) Math.pow(2, numberOfRounds) - 1;
        tournamentSchedule = new Combat[numberOfFights];
    }

    public Combat[] getTournamentSchedule() {
        return tournamentSchedule;
    }
}
