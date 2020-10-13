package com.company;


import java.util.*;

public class Player {

    public int initialMoney = 2000;
    public String name;
    public ArrayList<Animal> animals;
    public Hay hay = new Hay();
    public Grain grain = new Grain();
    public Pellets pellets = new Pellets();
    public String showMyDetails;


    public Player(String name) {
        this.name = name;
        this.animals = new ArrayList<>();

    }

    public void showMyDetails() {
        System.out.println("You have " + this.hay.kilo + " kilos of hay, " + grain.kilo + " kilos of grain and " + pellets.kilo + " kilos of pellets." +
                "You own the following animals " + animals.size()); //change to display class of animal

        for (var animal : animals) {
            System.out.println("The name of your animal is " + animal.name + "and it's a "+ animal.getClass().getSimpleName() + " and it's " + animal.gender);
        }
    }


    public void feedAnimal() {
        Scanner input = new Scanner(System.in);

        int animalType = Dialogs.promptInt("What would you like to feed today? \n.1.Cow. \n2.Goat. \n3.Donkey. \n4.Pig. \n5.Goose ", 1, 5);

        if (animalType == 1 || animalType == 2 || animalType == 3) {
            int choice = Dialogs.promptInt("How many kilos of hay will you be needing today? You currently have " + this.hay.kilo + " kilos left.", 0, 10000);

            this.hay.kilo = this.hay.kilo - choice;

        } else if (animalType == 4) {
            int choice = Dialogs.promptInt("How many kilos of pellets will you be feeding your pig? You currently have " + this.pellets.kilo + " kilos left.", 0, 10000);

            this.pellets.kilo = this.pellets.kilo - choice;
        } else {
            int choice = Dialogs.promptInt("You have " + this.grain.kilo + " kilos of grain left, how many kilos will you need for your goose?", 0, 10000);
            this.grain.kilo = this.grain.kilo - choice;
        }


    }


    public void mateAnimals() {


    }


}
