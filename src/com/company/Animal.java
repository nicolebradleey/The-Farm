package com.company;

public abstract class Animal {    //change to abstract?

    public String name;
    public String gender;
    public int health = 100;
    public int price;

    public Animal(String name, String gender){
        this.name=name;
        this.gender=gender;
    }

    public void healthDeterioration(int health) {


    }


//    public void animalGender(){
//        if(Math.random()>0.5) gender = "male";
//        else {
//            gender = "female";
//        }
//    }
//

}