package com.company.controller;

import com.company.model.combat.Combat;
import com.company.model.gladiators.Gladiator;
import com.company.model.tournamentTree.TournamentSchedule;
import com.company.view.MessageDisplayer;

import java.util.Scanner;

public class Colosseum {

    public static void main(String[] args) {
        MessageDisplayer messageDisplayer = new MessageDisplayer();
        Scanner scanner = new Scanner(System.in);

        messageDisplayer.displayWelcomeMessage();
        int numberOfTournamentStages = scanner.nextInt();

        TournamentSchedule tournament = new TournamentSchedule();
        tournament.prepareTournamentSchedule(numberOfTournamentStages);
        TournamentController tournamentController = new TournamentController(tournament, messageDisplayer);

        Combat[] schedule = tournament.getTournamentSchedule();
        messageDisplayer.displayAllGladiatorsInfo(schedule);

        Gladiator winner = tournamentController.startTournament();
        messageDisplayer.displayWinnerOfTournament(winner);
    }
}
