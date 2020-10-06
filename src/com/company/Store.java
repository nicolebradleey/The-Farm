package com.company;
                                           //method -- buy animals, when buying it's also named. choose gender and type

import java.util.*;

public class Store {
        Scanner input = new Scanner(System.in);
        public int price;
        public Animal animal;  //create menu that opens up for store. one for food and one for animals
        public Food food;


        public static void sellFood(){
                Scanner input = new Scanner(System.in);
                System.out.println("We have hay, grain and pellets. Please choose one");
                String choice = input.next();

                switch (choice){
                        case "hay" -> System.out.println("Hay is £5 per kilo, how many kilos would you like?");
                        case "grain" -> System.out.println("Grain is £10 per kilo, how many kilos would you like?");
                        case "pellets" -> System.out.println("Pellets are £15 per kilo, how many kilos would you like?");
                }

        }
        public static void createAnimal(){
                Scanner input = new Scanner(System.in);
                System.out.println("Which animal would you like to purchase today?");

        }
        public static void createFood(){

        }
//        public sellAnimal(Animal Cow, Animal Goose, Animal Goat, Animal Pig, Animal Donkey){
//                return Animal;
//
//        }




}
