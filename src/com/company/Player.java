package com.company;

import java.util.*;

public class Player {

    public int money = 100; //SÄTT TILL 2000
    public String name;
    public ArrayList<Animal> animals;
    public Hay hay = new Hay("hay", 10);
    public Grain grain = new Grain("grain", 20);
    public Pellets pellets = new Pellets("pellets", 30);


    public Player(String name) {
        this.name = name;
        this.animals = new ArrayList<>();

    }

    public String showMyDetails() {

        String details = "";
        details += "You have " + this.hay.kilo + " kilos of hay, " + grain.kilo + " kilos of grain and " + pellets.kilo + " kilos of pellets.\n";

        if (animals.isEmpty()) {
            details += "\nYou don't own any animals...";
        }

        if (animals.isEmpty() && money == 0) {

            details += "and you have no money. I hope you're not a sore loser. " + this.name + " IS OUT!";
            Game.losers.add(this);
            Dialogs.sleep(7000);
            if (Game.losers.size() == Game.playerCounter) {
                details += "GAME OVER";
                System.exit(0);
            }
        } else {
            int list = 0;
            for (var animal : animals) {
                list++;
                details += "\n" + list + ". " + animal.name + ": " + animal.getClass().getSimpleName().toUpperCase() + ", " + animal.gender.toUpperCase() + ", " + animal.health + "%";
            }
        }
        return details;
    }


    public void feedAnimal() {

        if (animals.isEmpty()) {
            System.out.println("You don't have any animals to feed!");
            Dialogs.sleep(1000);
            return;

        }
        listOfAnimalsOwned();

        int number = Dialogs.promptInt("\nWhich animal would you like to feed? Enter a number", 1, animals.size());

        String animalType = this.animals.get(number - 1).getClass().getSimpleName().toLowerCase();
        Animal animalToFeed = this.animals.get(number - 1);


        if (animalType.equals("cow") || animalType.equals("goat") || animalType.equals("donkey")) {

            int choice = Dialogs.promptInt("How many kilos of hay will you be needing today? You currently have " + this.hay.kilo + " kilos left." +
                    "\n(0 to go back)", 0, this.hay.kilo);
            if (choice == 0) {
                return;
            }
            this.hay.kilo = this.hay.kilo - choice;
            Game.actionCounter++;
            if (animalToFeed.health < 100) {    //makes it impossible for health to go above 100
                animalToFeed.health += (10 * choice);
            }
            if (animalToFeed.health >= 100) {
                animalToFeed.health = 100;
            }
        } else if (animalType.equals("pig")) {
            int choice = Dialogs.promptInt("How many kilos of pellets will you be feeding your pig? You currently have "
                    + this.pellets.kilo + " kilos left." + "\n(0 to go back)", 0, this.pellets.kilo);
            if (choice == 0) {
                return;
            }
            this.pellets.kilo = this.pellets.kilo - choice;
            Game.actionCounter++;
            if (animalToFeed.health < 100) {
                animalToFeed.health += (10 * choice);
            }
            if (animalToFeed.health >= 100) {
                animalToFeed.health = 100;
            }

        } else {      //goose
            int choice = Dialogs.promptInt("You have " + this.grain.kilo + " kilos of grain left, how many kilos will you need for your goose?" +
                    " \n(0 to go back)", 0, this.grain.kilo);
            if (choice == 0) {
                return;
            }
            this.grain.kilo = this.grain.kilo - choice;
            Game.actionCounter++;
            if (animalToFeed.health < 100) {
                animalToFeed.health += (10 * choice);
            }
            if (animalToFeed.health >= 100) {
                animalToFeed.health = 100;
            }
        }

    }

    public void healthDeterioration() {
        Random random = new Random();
        ArrayList<Animal> deadAnimals = new ArrayList<>();

        for (var animal : animals) {
            int percent = random.nextInt(30) + 10;
            animal.health -= percent;      // animal.health = animal.health - percent;
            if (animal.health <= 0) {
                System.out.println(animal.name + " has passed away due to negligence. Shame!");
                deadAnimals.add(animal);
            }
        }
        animals.removeAll(deadAnimals);
    }


    public void listOfAnimalsOwned() {

        int list = 0;
        System.out.println("You own the below animals: \n");
        for (var animal : animals) {
            list++;
            System.out.println(list + ". " + animal.name + " the " + animal.getClass().getSimpleName() + ", " + animal.gender+ ".");
            //prints list of animals with a number in front.
        }
    }

    public void sellAnimal() {

        ArrayList<Animal> soldAnimals = new ArrayList<>();

        if (animals.size() == 0) {
            System.out.println("\n You don't have any animals to sell, maybe try buying one first...");
            return;
        }

        listOfAnimalsOwned();
        int number = Dialogs.promptInt("\nWhich animal would you like to sell? Enter a number", 1, animals.size());

        String animalType = animals.get(number - 1).getClass().getSimpleName().toLowerCase();
        Animal animalToSell = animals.get(number - 1);   //-1 gets index of selected animal

        double animalHealth = ((double) animalToSell.health / 100);

        double salePrice = animalToSell.price * animalHealth;
        int newPrice = (int) Math.round(salePrice);

        money += newPrice;
        System.out.println("You've just made " + newPrice + " pieces of silver!");

        soldAnimals.add(animalToSell);

        animals.removeAll(soldAnimals);
        Game.actionCounter++;

        int choice = Dialogs.promptInt("\nYou have " + money + " pieces of silver left. " +
                "Would you like to sell another animal? 1 for yes 2 for no ", 1, 2);
        if (choice == 1) {
            sellAnimal();
        }
    }


}



