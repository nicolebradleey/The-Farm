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
            String nameCapitalized = name.substring(0,1).toUpperCase();
            String name1 = nameCapitalized + name.substring(1);

            int genderChoice  = Dialogs.promptInt("Is " + name1 + " a MALE (press 1) or" +
                    " a FEMALE (press 2) " + className.toLowerCase() + "?",1,2);   //make sure female or male is entered

            String gender = "";
           if(genderChoice == 1 ){
               gender = "male";
           }
           if(genderChoice == 2){
               gender = "female";
           }

            switch (className) {
                case "Pig" -> player.animals.add(new Pig(name1, gender));
                case "Cow" -> player.animals.add(new Cow(name1, gender));
                case "Goat" -> player.animals.add(new Goat(name1, gender));
                case "Goose" -> player.animals.add(new Goose(name1, gender));
                case "Donkey" -> player.animals.add(new Donkey(name1, gender));
            }
            Game.actionCounter++;
            player.money = player.money - price;
            int choice = Dialogs.promptInt("\nYou have " + player.money + " pieces of silver left. " +
                    "\nWould you like to buy another animal? 1 for YES 2 for NO. ",1,2);
            if(choice == 1){
                Store.buyAnimal(player);
            }
        }
        }


    public static void mateAnimals(Player player) { //behöver inte ha gender för finns i fields


        player.listOfAnimalsOwned();

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
            int choice = Dialogs.promptInt("You need to choose two animals of the same sex! Or press 2 to exit.",1,2);
            if(choice == 2){
                return;
            }
            wrongAnimal = true;
            continue;
        }
        if(!animalType1.equals(animalType2)) {
            int choice = Dialogs.promptInt("You need to choose two animals of the same type! Or press 2 to exit.",1,2);
                if(choice == 2){
                    return;
                }
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
                    "\n".repeat(1) + "Please enter a name for your baby " + animalType1 + ": ");
            String nameCapitalized = name.substring(0,1).toUpperCase();
            String name1 = nameCapitalized + name.substring(1);


            switch (animalType1) {
                case "pig" -> player.animals.add(new Pig(name1, gender1));
                case "cow" -> player.animals.add(new Cow(name1, gender1));
                case "goat" -> player.animals.add(new Goat(name1, gender1));
                case "goose" -> player.animals.add(new Goose(name1, gender1));
                case "donkey" -> player.animals.add(new Donkey(name1, gender1));
            }

            Game.actionCounter++;

        }
    }


}
