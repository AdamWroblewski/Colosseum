package com.company.controller;

import com.company.model.combat.Combat;
import com.company.model.gladiators.Gladiator;
import com.company.model.tournamentTree.TournamentSchedule;
import com.company.view.MessageDisplayer;

import java.util.Scanner;

public class Colosseum {
    private static MessageDisplayer messageDisplayer = new MessageDisplayer();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        messageDisplayer.displayWelcomeMessage();
        int numberOfTournamentStages = scanner.nextInt();

        TournamentSchedule tournament = new TournamentSchedule(numberOfTournamentStages);
        TournamentController tournamentController = new TournamentController(tournament, messageDisplayer);
        Combat[] schedule = tournament.getTournamentSchedule();

        messageDisplayer.displayAllGladiatorsInfo(schedule);

        Gladiator winner = tournamentController.startTournament();
        messageDisplayer.displayWinnerOfTournament(winner);
    }
}
