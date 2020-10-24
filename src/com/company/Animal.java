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
            String name = Dialogs.prompt("Please name your " + className.toLowerCase() + "?");
            String gender  = Dialogs.prompt("Is " + name + " a Male or a Female " + className.toLowerCase() + "?");   //make sure female or male is entered

            switch (className) {
                case "Pig" -> player.animals.add(new Pig(name, gender));
                case "Cow" -> player.animals.add(new Cow(name, gender));
                case "Goat" -> player.animals.add(new Goat(name, gender));
                case "Goose" -> player.animals.add(new Goose(name, gender));
                case "Donkey" -> player.animals.add(new Donkey(name, gender));
            }
            Game.actionCounter++;
            player.money = player.money - price;
            int choice = Dialogs.promptInt("You have " + player.money + " pieces of silver left. " +
                    "Would you like to buy another animal? 1 for yes 2 for no ",1,2);
            if(choice == 1){
                Store.buyAnimal(player);
            }
        }
    }

    public static void mateAnimals(Player player) { //behöver inte ha gender för finns i fields


        player.listOfAnimalsOwned();                 //WHEN YOU DONT HAVE TWO ANIMALS OF SAME TYPE, BREAK!!

        if(player.animals.size() <= 1){
            System.out.println("\nIn case it wasn't obvious, you need more than one animal to create another...");
            return;
        }

        int number1 = Dialogs.promptInt("\nPick animal one: ", 1, player.animals.size());

        String animalType1 = player.animals.get(number1 - 1).getClass().getSimpleName().toLowerCase();  //returns whats on place number1 as a string
       Animal animal1 = player.animals.get(number1 - 1);


       boolean wrongAnimal = false;

        do{
        int number2 = Dialogs.promptInt("\nPick animal two: ", 1, player.animals.size());

        String animalType2 = player.animals.get(number2 - 1).getClass().getSimpleName().toLowerCase();
        Animal animal2 = player.animals.get(number2-1);


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
            System.out.println("Better luck next time...");
            Dialogs.sleep(1000);
            Game.actionCounter ++;
            return;
        }

        Random random = new Random();
        int randomNumberOfBabies = random.nextInt(3)+1;
        int counter = 0;


        while(counter <= randomNumberOfBabies){

            counter++;

            String gender1 = Math.random() > 0.5 ? "male" : "female";


            String name = Dialogs.prompt("It's a " + player.animals.get(player.animals.size() - 1).gender +
                    " " + player.animals.get(player.animals.size() - 1).getClass().getSimpleName() + "!!!" +
                    "\nPlease enter a name for your baby " + animalType1 + ": ");


            switch (animalType1) {
                case "pig" -> player.animals.add(new Pig(name, gender1));
                case "cow" -> player.animals.add(new Cow(name, gender1));
                case "goat" -> player.animals.add(new Goat(name, gender1));
                case "goose" -> player.animals.add(new Goose(name, gender1));
                case "donkey" -> player.animals.add(new Donkey(name, gender1));
            }

            Game.actionCounter++;

        }
    }


}
