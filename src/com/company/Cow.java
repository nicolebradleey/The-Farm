package com.company;
import java.util.*;

public class Cow extends Animal{

    public static int price = 300;

    public Cow (String name, String gender){
        super(name, gender);

    }

   public static void createCow(Player player){
        Scanner input = new Scanner(System.in);
       System.out.println("Please name your cow");
       String name1 = input.next();
       System.out.println("Male or Female?");
       String gender1 = input.next();

       Cow cow = new Cow(name1, gender1);     //stores created cow in players arraylist

      player.animals.add(cow); //stores created cow in players arraylist

       player.initialMoney = player.initialMoney - price;



//        for(var animal: player.animals){
//            System.out.println(animal.getClass().getSimpleName());    loop through array
//        }
   }




}
