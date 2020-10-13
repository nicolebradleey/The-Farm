package com.company;

import java.util.*;

public abstract class Animal {    //change to abstract?

    public String name;
    public String gender;
    public int health = 100;
    public int price;

    public Animal(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }





    public static void createAnimal(Player player, int price, String className) {

        if (player.initialMoney < price) {
            System.out.println("You can't afford a " + className + ", choose another animal!");
            Store.createAnimal(player);
        } else {
            Scanner input = new Scanner(System.in);
            System.out.println("Please name your " + className.toLowerCase() + "?");
            String name1 = input.next();

            System.out.println("Is " + name1 + " a Male or a Female " + className.toLowerCase() + "?");
            String gender1 = input.next();

            switch (className) {
                case "Pig" -> player.animals.add(new Pig(name1, gender1));
                case "Cow" -> player.animals.add(new Cow(name1, gender1));
                case "Goat" -> player.animals.add(new Goat(name1, gender1));
                case "Goose" -> player.animals.add(new Goose(name1, gender1));
                case "Donkey" -> player.animals.add(new Donkey(name1, gender1));
            }

            player.initialMoney = player.initialMoney - price;
        }
    }


//    public void animalGender(){
//        if(Math.random()>0.5) gender = "male";
//        else {
//            gender = "female";
//        }
//    }
//

}