package com.company;
                                           //method -- buy animals, when buying it's also named. choose gender and type

import java.util.*;

public class Store {
        static Scanner input = new Scanner(System.in);
        public int price;
        public Animal animal;
        public Food food;



        public static void createFood(){

                System.out.println("We have hay, grain and pellets. Please choose one");
                String choice = input.next();

                switch (choice){
                        case "hay" -> System.out.println("Hay á 10 pieces of silver per kilo, how many kilos would you like?");
                        case "grain" -> System.out.println("Grain á 20 pieces of silver per kilo, how many kilos would you like?");
                        case "pellets" -> System.out.println("Pellets á 30 pieces of silver per kilo, how many kilos would you like?");
                }

        }
        public static void createAnimal(Player player){
                System.out.println("Which animal would you like to purchase today? \n1.Cow á 300 pieces of silver. \n2.Pig á 250 pieces of silver.  \n3.Goose á 150 pieces of silver" +
                        " \n4.Goat á 200 pieces of silver. \n5.Donkey á 100 pieces of silver");
                int choice = input.nextInt();
                switch(choice){
                        case 1-> Cow.createCow(player);
                        case 2 -> Pig.createPig(player);
                        case 3 -> Goose.createGoose(player);
                        case 4 -> Goat.createGoat(player);
                        case 5 -> Donkey.createDonkey(player);
                }


        }
        public void sellAnimal(){

        }

}
