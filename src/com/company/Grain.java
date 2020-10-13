package com.company;

import java.util.Scanner;

public class Grain extends Food {

    public static int pricePerKilo = 20;
    private static int choice;


    public static void getPriceGrain(Player player) {
        boolean afford = true;
        Scanner input = new Scanner(System.in);
        while (afford) {
            Food.howManyKilos();
            int choice = input.nextInt();
            int finalPrice = pricePerKilo * choice;

            if (finalPrice > player.initialMoney) {
                System.out.println("You can't afford this many kilos\n");
                Dialogs.sleep(1000);

            }
            else
            {

                System.out.println("That's a total of " + finalPrice + " silver pieces");
                Dialogs.sleep(1000);
                player.grain.kilo += choice;
                player.initialMoney = player.initialMoney - finalPrice;
                afford = false;
            }
        }

    }
}
