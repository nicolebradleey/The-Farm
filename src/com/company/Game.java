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
    static public int playerCounter = 0;


    public Game() {

        int amountOfPlayers = Dialogs.promptInt("Welcome to THE FARM! \n ------------------------------" +
                " \nPlease enter how many will be playing today (1-4 players).", 1, 4);


        System.out.println("Please enter your names: ");
        for (int i = 0; i < amountOfPlayers; i++) {
            String playerName = input.next();
            String nameCapitalized = playerName.substring(0, 1).toUpperCase();
            String name = nameCapitalized + playerName.substring(1);
            newPlayer(name);
            playerCounter++;
        }
        chooseRounds();

    }

    public void menu() {
        int choice;
        // Loop through all rounds
        while (currentRound <= rounds) {

            // Loop through each player
            for (var player : players) {

                if (Game.losers.contains(player)) {
                    continue;
                }

                System.out.println("\n".repeat(50) + "You have a balance of " + player.money + " pieces of silver.");
                player.healthDeterioration();

                System.out.println(player.showMyDetails());

                if (Game.losers.contains(player)) {
                    // The player has lost so he/she can not take part in the round
                    continue;
                }


                System.out.println("\nRound " + currentRound + " of " + rounds + ". \n ---------------------------" +
                        "\nWhat would you like to do, " + player.name + "?");
                Dialogs.sleep(500);


                actionCounter = 0;
                while (actionCounter == 0) {
                    choice = Dialogs.promptInt("\n1.Purchase an animal. \n2.Purchase food. \n3.Feed an animal. \n4.Mating season. \n5.Sell an animal \n6.EXIT.", 1, 6);

                    switch (choice) {
                        case 1 -> Store.buyAnimal(player);
                        case 2 -> Store.buyFood(player);
                        case 3 -> player.feedAnimal();
                        case 4 -> Animal.mateAnimals(player);
                        case 5 -> player.sellAnimal();
                        default -> System.exit(0);


                    }
                }
            }

            currentRound++; // increase currentRound counter

        }
        lastRound();
    }

    public void lastRound() {


        for (var player : players) {
            for (var animal : player.animals) {
                double animalHealth = ((double) animal.health / 100);
                double salePrice = animal.price * animalHealth;
                int newPrice = (int) Math.round(salePrice);
                player.money += newPrice;

            }
        }

        players.sort((Player a, Player b) -> a.money > b.money ? -1 : 1);


        for (var player : players) {
            System.out.println(player.name + " has " + player.money + " pieces of silver.");
        }

        ArrayList<Player> winners = new ArrayList<>();

        for (var player1 : players) {
            if (player1.money == players.get(0).money) {
                winners.add(player1);
            }
        }
        String winningNames = "";

        for (var winner : winners) {
            winningNames += winner.name + ", ";
        }

        winningNames += "is a WINNER!!!";
        System.out.println(winningNames);
        System.exit(0);

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

