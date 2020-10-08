package com.company;

import java.util.Scanner;

public class Pig extends Animal {

    public static int price = 200;

    public Pig(String name, String gender) {
        super(name, gender);
    }

    public static void createPig(Player player) {


        if (player.initialMoney < 200) {
            System.out.println("You can't afford a Pig, choose another animal!");
            Store.createAnimal(player);
        } else {
            Scanner input = new Scanner(System.in);
            System.out.println("Please name your pig");
            String name1 = input.next();
            System.out.println("Male or Female?");
            String gender1 = input.next();

            Pig pig = new Pig(name1, gender1);     //stores created cow in players arraylist

            player.animals.add(pig); //stores created cow in players arraylist

            player.initialMoney = player.initialMoney - price;
        }
    }
}