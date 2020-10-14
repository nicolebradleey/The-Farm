package com.company;

import java.util.*;

public abstract class Food {

    public int pricePerKilo;
    public String type;
    public int kilo;

     public Food(String type, int pricePerKilo){
           this.type = type;
         this.pricePerKilo = pricePerKilo;
    }

    public static void getPriceFood(Player player, int pricePerKilo, String className) {
        boolean afford = true;
        Scanner input = new Scanner(System.in);
        while (afford) {
            System.out.println("How many kilos of " + className + " would you like? ");
            int choice = input.nextInt();
            int finalPrice = pricePerKilo * choice;

            if (finalPrice > player.initialMoney) {
                System.out.println("You can't afford this many kilos\n");
                Dialogs.sleep(1000);
            }
            if (className.equals("hay")) {
                System.out.println("That's a total of " + finalPrice + " silver pieces");
                player.hay.kilo += choice;
                player.initialMoney = player.initialMoney - finalPrice;
                afford = false;
            }
            if (className.equals("grain")) {
                System.out.println("That's a total of " + finalPrice + " silver pieces");
                player.grain.kilo += choice;
                player.initialMoney = player.initialMoney - finalPrice;
                afford = false;
            }
            if(className.equals("pellets")) {
                System.out.println("That's a total of " + finalPrice + " silver pieces");
                player.pellets.kilo += choice;
                player.initialMoney = player.initialMoney - finalPrice;
                afford = false;

            }
        }

    }
}




