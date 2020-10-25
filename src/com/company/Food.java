package com.company;

import java.util.*;

public abstract class Food {

    public int pricePerKilo;
    public String type;
    public int kilo;

    public Food(String type, int pricePerKilo) {
        this.type = type;
        this.pricePerKilo = pricePerKilo;
    }

    public static void createFood(Player player, int pricePerKilo, String className) {


        int choice = Dialogs.promptInt("How many kilos of " + className + " would you like? ", 1, 10000);
        int finalPrice = pricePerKilo * choice;

        if (finalPrice > player.money) {
            System.out.println("You can't afford this many kilos\n");
            Dialogs.sleep(1000);
            return;
        }
        if (className.equals("hay")) {
            System.out.println("That's a total of " + finalPrice + " pieces of silver.");
            player.hay.kilo += choice;
            Game.actionCounter++;
            player.money = player.money - finalPrice;
        }
        if (className.equals("grain")) {
            System.out.println("That's a total of " + finalPrice + " pieces of silver.");
            player.grain.kilo += choice;
            Game.actionCounter++;
            player.money = player.money - finalPrice;

        }
        if (className.equals("pellets")) {
            System.out.println("That's a total of " + finalPrice + " pieces of silver.");
            player.pellets.kilo += choice;
            Game.actionCounter++;
            player.money = player.money - finalPrice;

        }


        int choice1 = Dialogs.promptInt("You have " + player.money
                + " pieces of silver left." + "\n".repeat(1) + "Would you like to buy more food? Enter 1 for YES or 2 for NO.", 1, 2);
        if (choice1 == 1) {
            Store.buyFood(player);
        }

    }

}


