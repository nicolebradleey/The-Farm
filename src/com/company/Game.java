package com.company;

import java.util.*;

public class Game {
    Scanner input = new Scanner(System.in);
    public int rounds;    // 5-30
    public int currentRound = 1;
    public ArrayList<Player> players = new ArrayList<>();
    public Player playingNow;


    public Game() {

        welcomeMessage();
        var amountOfPlayers = input.nextInt();                                            //if (numOfPlayers > 4) {/System.out.println("Please only enter up to 4 players"); fix later


        System.out.println("Please enter your names: ");
        for (int i = 0; i < amountOfPlayers; i++) {
            String playerName = input.next();
            newPlayer(playerName);
        }

        chooseRounds();


        //System.out.println("HOW MANY PLAYERS " + players.size());
        // System.out.println(players.get(0).name);


    }


    public void menu() {

        // Loop through all rounds
        while (currentRound <= rounds) {

            // Loop through each player
            for (var player : players) {
                System.out.println("\n".repeat(50) + "You have a balance of " + player.initialMoney + " pieces of silver.");
                System.out.println("Round " + currentRound + " of " + rounds + "\nWhat would you like to do, " + player.name + "?");

                System.out.println("\n1.Purchase an animal. \n2.Purchase food. \n3.Feed an animal. \n4.Mating season. \n5.Sell an animal " +
                        "\nPress any other key to exit.");
                int choice = input.nextInt();

                switch (choice) {
                    case 1 -> Store.createAnimal(player);
                    case 2 -> Store.createFood();
                    case 3 -> System.out.println("Feed an animal");
                    case 4 -> System.out.println("Mating season");
                    case 5 -> System.out.println("Sell an animal");
                    default -> System.out.println("Are you sure you want to exit?");   //figure out how to use this with with both number and letters

                }

            }

            currentRound++; // increase currentRound counter

        }
    }

    public void welcomeMessage() {
        System.out.println("Welcome to The Farm! \n -------------------- \nPlease enter how many will be playing today (1-4 players).");  //create try catch

    }

    public void newPlayer(String newPlayer) {

        players.add(new Player(newPlayer));
    }

    public void chooseRounds() {
        System.out.println("How many rounds will be played today? Please choose between 5-30");    //create try catch, kolla dialogs på bloggen
        rounds = input.nextInt();
        if (rounds >= 5)
            for (int i = 0; i < rounds; i++) {
                System.out.println("\n".repeat(20));
                menu();

            }
        else {
            System.out.println("Please enter between 5-30 rounds");
            rounds = input.nextInt();
        }

    }
}
//a) Köpa max så många djur som hen har pengar till (varje typ av djur har ett fast ursprungspris, oavsett kön)
//b) Köpa max så mycket mat som hen har pengar till (mat köps i kg och har kilopris)
//c) Mata sina djur (vilken slags mat måste anges för varje djur man vill mata)
//d) Försöka få ett par djur att para sig, då skapas i 50% av fallen nya djur man äger
// (om djuren är av samma slag och olika kön, olka slags djur kan inte para sig). Om parningen lyckas kan spelaren döpa det/de nya djuret/djuren
// (olika slags djur kan ha olika många ungar/parning). Könet på djuren som skapas vid parning slumpas (50% hona, 50% hane).
//e) Sälja ett-flera djur (priset är ursprungspriset gånger hälsovärdet)