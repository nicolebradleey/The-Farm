package com.company;

import java.util.*;

public abstract class Animal {    //change to abstract?

    public String name;
    public String gender;
    public int health = 100;
    public int price;
    public Player player;

    public Animal(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public static void createAnimal(Player player, int price, String className) {

        if (player.money < price) {
            System.out.println("You can't afford a " + className + ", choose another animal!");
            Store.buyAnimal(player);
        } else {
            Scanner input = new Scanner(System.in);
            System.out.println("Please name your " + className.toLowerCase() + "?");
            String name = input.next();

            System.out.println("Is " + name + " a Male or a Female " + className.toLowerCase() + "?");    //DIALOGS PROMPT STRING LIKE IN MATEANIMALS BABYNAME
            String gender = input.next();

            switch (className) {
                case "Pig" -> player.animals.add(new Pig(name, gender));
                case "Cow" -> player.animals.add(new Cow(name, gender));
                case "Goat" -> player.animals.add(new Goat(name, gender));
                case "Goose" -> player.animals.add(new Goose(name, gender));
                case "Donkey" -> player.animals.add(new Donkey(name, gender));
            }
            System.out.println("Would you like to buy another animal? ");
            Game.actionCounter++;
            player.money = player.money - price;      //make a loop to buy more animals . Ask if they want to buy more animals yes or no 1/2. Yes call method again, no = go back to menu.
        }
    }

    public static void mateAnimals(Player player) { //behöver inte ha gender för finns i fields


        player.listOfAnimalsOwned();
        int number1 = Dialogs.promptInt("\nPick animal one: ", 1, player.animals.size());    //IF ONLY ONE ANIMAL IS OWNED GO BACK TO MENU

        String animalType1 = player.animals.get(number1 - 1).getClass().getSimpleName().toLowerCase();  //returns whats on place number1 as a string
       Animal animal1 = player.animals.get(number1 - 1);

        System.out.println("animal 1 " + animalType1);

       boolean wrongAnimal = false;

        do{
        int number2 = Dialogs.promptInt("\nPick animal two: ", 1, player.animals.size());

        String animalType2 = player.animals.get(number2 - 1).getClass().getSimpleName().toLowerCase();
        Animal animal2 = player.animals.get(number2-1);

            System.out.println("animal 2 " + animalType2);

        if (animal1.gender.equals(animal2.gender)) {
            System.out.println("You can't mate two animals of the same sex, choose another animal.");
            wrongAnimal = true;
            continue;
        }
        if(!animalType1.equals(animalType2)) {
            System.out.println("You need to choose two animals of the same type!");
            wrongAnimal = true;
            continue;
        }
        wrongAnimal = false;

        }while(wrongAnimal);


        if(Math.random() > 0.5){
            System.out.println("Better luck next time!");
            Game.actionCounter ++;
            return;
        }

        String name = Dialogs.prompt("Please enter a name: "); //CHANGE ORDER SO SEX IS KNOWN BEFORE NAMING ANIMAL!!!
        String gender1 = Math.random() > 0.5 ? "male" : "female";

        switch (animalType1) {
            case "pig" -> player.animals.add(new Pig(name, gender1));
            case "cow" -> player.animals.add(new Cow(name, gender1));
            case "goat" -> player.animals.add(new Goat(name, gender1));
            case "goose" -> player.animals.add(new Goose(name, gender1));
            case "donkey" -> player.animals.add(new Donkey(name, gender1));
        }
        System.out.println("It's a " + player.animals.get(player.animals.size()-1).gender +
                " " + player.animals.get(player.animals.size()-1).getClass().getSimpleName() + "!!!");


    }


}
