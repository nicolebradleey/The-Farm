package com.company;

import java.util.*;

public class Game {
    Scanner input = new Scanner(System.in);
    public int rounds;    // 5-30
    public int currentRound = 1;
    static public ArrayList<Player> players = new ArrayList<>();
    static public ArrayList<Player> losers = new ArrayList<>();
    static public int actionCounter = 0;
    public Animal animal;


    public Game() {

        System.out.println("Welcome to The Farm! \n -------------------- \nPlease enter how many will be playing today (1-4 players).");
        var amountOfPlayers = input.nextInt();

        System.out.println("Please enter your names: ");
        for (int i = 0; i < amountOfPlayers; i++) {
            String playerName = input.next();
            newPlayer(playerName);
        }

        chooseRounds();

    }

    public void menu() {
        int choice;
        // Loop through all rounds
        while (currentRound <= rounds) {

            // Loop through each player
            for (var player : players) {
//                if (currentRound == rounds) {
//                    player.lastRound();
//                }

                System.out.println("\n".repeat(50) + "You have a balance of " + player.money + " pieces of silver.");
                player.healthDeterioration();

                player.showMyDetails();

                if (Game.losers.contains(player)) {
                    // The player has lost so he/shes can not take part in the round
                    continue;
                }


                System.out.println("\nRound " + currentRound + " of " + rounds + ". \n -------------------------" +
                        "\nWhat would you like to do, " + player.name + "?");
                Dialogs.sleep(500);


                actionCounter = 0;
                while (actionCounter == 0) {
                    choice = Dialogs.promptInt("\n1.Purchase an animal. \n2.Purchase food. \n3.Feed an animal. \n4.Mating season. \n5.Sell an animal ", 1, 5);

                    switch (choice) {
                        case 1 -> Store.buyAnimal(player);
                        case 2 -> Store.buyFood(player);
                        case 3 -> player.feedAnimal();
                        case 4 -> Animal.mateAnimals(player);
                        case 5 -> player.sellAnimal();
                        // default -> System.out.println("Game ending...");


                    }
                }
            }


            currentRound++; // increase currentRound counter

        }
    }

    public void newPlayer(String newPlayer) {

        players.add(new Player(newPlayer));
    }

    public void chooseRounds() {

        rounds = Dialogs.promptInt("How many rounds will be played today? Please choose between 5-30", 5, 30);
        for (int i = 0; i < rounds; i++) {
            System.out.println("\n".repeat(20));
            menu();


        }
    }


}

