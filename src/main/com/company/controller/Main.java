package com.company.controller;

import com.company.model.gladiators.Gladiator;
import com.company.model.tournamentTree.TournamentSchedule;
import com.company.view.MessageDisplayer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MessageDisplayer messageDisplayer = new MessageDisplayer();
        messageDisplayer.displayWelcomeMessage();
        TournamentSchedule schedule = new TournamentSchedule(scanner.nextInt());
        Gladiator winner = schedule.startTournament();
        messageDisplayer.displayWinnerOfTournament(winner);
    }
}
