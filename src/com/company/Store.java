package com.company;


import java.util.*;

public class Store {
    static Scanner input = new Scanner(System.in);
    public int price;
    public Animal animal;
    public Food food;


    public static void createFood(Player player) {
        int choice;
        choice = Dialogs.promptInt("Which kind of food will you be purchasing today? \n1.Hay \n2.Grain \n3.Pellets.", 1, 5);

        switch (choice) {
            case 1 -> {
                System.out.println("Hay á 10 pieces of silver per kilo.");
                Hay.getPriceHay(player);
            }
            case 2 -> {
                System.out.println("Grain á 20 pieces of silver per kilo");
                Grain.getPriceGrain(player);
            }
            case 3 -> {
                System.out.println("Pellets á 30 pieces of silver per kilo");
                Pellets.getPricePellets(player);
            }
        }
    }

    public static void createAnimal(Player player) {
        int choice;
        choice = Dialogs.promptInt("Which animal would you like to purchase today? \n1.Cow á 300 pieces of silver. \n2.Pig á 250 pieces of silver.  " +
                "\n3.Goose á 150 pieces of silver" + " \n4.Goat á 200 pieces of silver. \n5.Donkey á 100 pieces of silver", 1, 5);

        switch (choice) {
            case 1 -> Cow.createAnimal(player, 300, "Cow");
            case 2 -> Pig.createAnimal(player, 250, "Pig");
            case 3 -> Goose.createAnimal(player, 150, "Goose" );
            case 4 -> Goat.createAnimal(player, 200, "Goat");
            case 5 -> Donkey.createAnimal(player, 100,  "Donkey");
        }

    }

    public void sellAnimal() {

    }


}
