package com.company;


import java.util.*;

public class Store {
    static Scanner input = new Scanner(System.in);
    public int price;
    public Animal animal;
    public Food food;


    public static void buyFood(Player player) {
        int choice;
        choice = Dialogs.promptInt("\nWhich kind of food will you be purchasing today? \n                          " +
                "\n1.HAY á 10 pieces of silver per kilo" +
                " \n2.GRAIN á 20 pieces of silver per kilo \n3.PELLETS á 30 pieces of silver per kilo. \n4. Back to main menu.", 1, 4);

        switch (choice) {
            case 1 -> Hay.createFood(player,10,"hay");
            case 2 -> Grain.createFood(player,20,"grain");
            case 3 ->Pellets.createFood(player,30,"pellets");

        }
    }

    public static void buyAnimal(Player player) {

        int choice;
        choice = Dialogs.promptInt("\nWhich animal would you like to purchase today? \n                      " +
                "\n1.COW á 300 pieces of silver." +
                " \n2.PIG á 250 pieces of silver.  \n3.GOOSE á 150 pieces of silver" + " " +
                "\n4.GOAT á 200 pieces of silver. \n5.DONKEY á 100 pieces of silver. \n6. Back to main menu.", 1, 6);

        switch (choice) {
            case 1 -> Cow.createAnimal(player, 300, "Cow");
            case 2 -> Pig.createAnimal(player, 250, "Pig");
            case 3 -> Goose.createAnimal(player, 150, "Goose" );
            case 4 -> Goat.createAnimal(player, 200, "Goat");
            case 5 -> Donkey.createAnimal(player, 100,  "Donkey");

        }

    }

}
