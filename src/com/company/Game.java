package com.company;

import java.util.*;

public class Game {
    Scanner input = new Scanner(System.in);
    public int rounds;    // 5-30
    public int playerTurn; // to choose how many will be playing. 1-4
    public ArrayList <Player> players = new ArrayList<>();



//    public Game() {
//        System.out.println("Welcome to The Farm! Please enter how many will be playing today (1-4 players) by entering your names: ");
//        String names = input.next();
//        newPlayer(names);
//
//        while (names.equals("")) {
//            newPlayer(names);//loop continues depending on how many names are entered
//
//        }
//
//    }



    public void menu() {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Purchase an animal");
                break;
            case 2:
                System.out.println("Purchase food");
                break;
            case 3:
                System.out.println("Feed an animal");
                break;
            case 4:
                System.out.println("Mating season");
                break;
            case 5:
                    System.out.println("Sell an animal");
            default:
                System.out.println("Are you sure you want to exit?");

        }
    }

    public void newPlayer (String newPlayer){
        players.add(new Player(newPlayer));
    }

    public void chooseRounds(int rounds){


    }







}


//a) Köpa max så många djur som hen har pengar till (varje typ av djur har ett fast ursprungspris, oavsett kön)
//b) Köpa max så mycket mat som hen har pengar till (mat köps i kg och har kilopris)
//c) Mata sina djur (vilken slags mat måste anges för varje djur man vill mata)
//d) Försöka få ett par djur att para sig, då skapas i 50% av fallen nya djur man äger
// (om djuren är av samma slag och olika kön, olka slags djur kan inte para sig). Om parningen lyckas kan spelaren döpa det/de nya djuret/djuren
// (olika slags djur kan ha olika många ungar/parning). Könet på djuren som skapas vid parning slumpas (50% hona, 50% hane).
//e) Sälja ett-flera djur (priset är ursprungspriset gånger hälsovärdet)