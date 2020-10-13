package com.company;

import java.util.*;

public class Player {

    public int initialMoney = 2000;
    public String name;
    public ArrayList<Animal> animals;
    public Hay hay = new Hay();
    public Grain grain = new Grain();
    public Pellets pellets = new Pellets();


    public Player(String name) {
        this.name = name;
        this.animals = new ArrayList<>();

    }

    public void showMyDetails() {
        System.out.println("You have " + this.hay.kilo + " kilos of hay, " + grain.kilo + " kilos of grain and " + pellets.kilo + " kilos of pellets.");

        for (var animal : animals) {
            System.out.println("You own " + animal.name + " the " + animal.gender + " " + animal.getClass().getSimpleName() + ". " +
                    animal.name + "'s health is at: " + animal.health + "%");
        }
    }


    public void feedAnimal() {
        Scanner input = new Scanner(System.in);
        int list = 0;
        System.out.println("You own the below animals: ");
        for (var animal : animals) {
            list++;
            System.out.println(list + ". " + animal.name + " the " + animal.getClass().getSimpleName() + ".");   //prints list of animals with a number in front.
        }

        int number = Dialogs.promptInt("\nWhich animal would you like to feed? Enter a number", 1, animals.size());

        String animalType = this.animals.get(number - 1).getClass().getSimpleName().toLowerCase();

        if (animalType.equals("cow") || animalType.equals("goat") || animalType.equals("donkey")) {
            int choice = Dialogs.promptInt("How many kilos of hay will you be needing today? You currently have " + this.hay.kilo + " kilos left.", 0, 10000);
            this.hay.kilo = this.hay.kilo - choice;

        } else if (animalType.equals("pig")) {
            int choice = Dialogs.promptInt("How many kilos of pellets will you be feeding your pig? You currently have " + this.pellets.kilo + " kilos left.", 0, 10000);
            this.pellets.kilo = this.pellets.kilo - choice;

        } else {      //goose
            int choice = Dialogs.promptInt("You have " + this.grain.kilo + " kilos of grain left, how many kilos will you need for your goose?", 0, 10000);
            this.grain.kilo = this.grain.kilo - choice;
        }

    }

    public void healthDeterioration() {
        Random random = new Random();
        int percent = random.nextInt(30) + 10;
        ArrayList <Animal> deadAnimals = new ArrayList<>();

        for (var animal : this.animals) {
            animal.health -= percent;      // animal.health = animal.health - percent;
            if(animal.health <= 0){
                System.out.println(animal.name + " has passed away due to negligence.");
                deadAnimals.add(animal);
            }
         }animals.removeAll(deadAnimals);
    }

    public void healthImprovement() {


    }

    public void mateAnimals() {
    }

}
//Om man matar ett djur stiger dess hälsovärde - varje kg mat förbättrar djurets hälsa med 10 procent.