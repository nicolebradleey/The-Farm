package com.company;

import java.util.Scanner;

public class Goat extends Animal{

    public static int price = 200;

    public Goat (String name, String gender){
        super(name, gender);
    }


    public static void createGoat(Player player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please name your goat");
        String name1 = input.next();
        System.out.println("Male or Female?");
        String gender1 = input.next();

        Goat goat = new Goat(name1, gender1);     //stores created cow in players arraylist

        player.animals.add(goat); //stores created cow in players arraylist

        player.initialMoney = player.initialMoney - price;
    }


}
