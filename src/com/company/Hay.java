package com.company;
import java.util.*;

public class Hay extends Food {

    public static int pricePerKilo = 10;

    public Hay(String type, int pricePerKilo){

        super(type, pricePerKilo);
    }

    public static Food getPriceHay(Player player){
        Scanner input = new Scanner(System.in);
        System.out.println("Hay á 10 pieces of silver per kilo, how many kilos would you like?");
        int choice = input.nextInt();
        int finalPrice = pricePerKilo * choice;
        System.out.println("That's a total of " + finalPrice);



        return null;
    }




}
