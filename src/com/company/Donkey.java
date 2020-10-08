package com.company;

import java.util.Scanner;

public class Donkey extends Animal {

    public static int price = 100;

    public Donkey(String name, String gender) {
        super(name, gender);
    }


    public static void createDonkey(Player player) {
        if (player.initialMoney < 100) {
            System.out.println("You can't even afford a Donkey, give up!");
            Store.createAnimal(player);
        } else {
            Scanner input = new Scanner(System.in);
            System.out.println("Please name your donkey");
            String name1 = input.next();
            System.out.println("Male or Female?");
            String gender1 = input.next();

            Donkey donkey = new Donkey(name1, gender1);     //stores created cow in players arraylist

            player.animals.add(donkey); //stores created cow in players arraylist

            player.initialMoney = player.initialMoney - price;
        }

    }
}