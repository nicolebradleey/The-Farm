package com.company;

import java.util.*;

public class Hay extends Food {

    public static int pricePerKilo = 10;
    private static int choice;


    public static void getPriceHay(Player player) {
        boolean afford = true;
        Scanner input = new Scanner(System.in);
        while (afford) {
            Food.howManyKilos();
            int choice = input.nextInt();
            int finalPrice = pricePerKilo * choice;

            if (finalPrice > player.initialMoney) {
                System.out.println("You can't afford this many kilos\n");
                Dialogs.sleep(1000);


            } else {
                Dialogs.sleep(1000);
                System.out.println("That's a total of " + finalPrice + " silver pieces");
                player.hay.kilo += choice;
                player.initialMoney = player.initialMoney - finalPrice;
                afford = false;
            }
        }


        //System.out.println(player.hay.kilo);


    }

}
