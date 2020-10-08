package com.company;

import java.util.*;

public class Goose extends Animal {


    public static int price = 150;

    public Goose(String name, String gender) {
        super(name, gender);
    }

    public static void createGoose(Player player) {

        if (player.initialMoney < 150) {
            System.out.println("Try buying another animal you pauper...");
            Store.createAnimal(player);
        } else {
            Scanner input = new Scanner(System.in);
            System.out.println("Please name your goose");
            String name1 = input.next();
            System.out.println("Male or Female?");
            String gender1 = input.next();

            Goose goose = new Goose(name1, gender1);     //stores created cow in players arraylist

            player.animals.add(goose); //stores created cow in players arraylist

            player.initialMoney = player.initialMoney - price;
        }
    }

}