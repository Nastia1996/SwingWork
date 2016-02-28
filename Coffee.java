package com.company;

import java.util.Random;

public class Coffee {
    private String typeCoffee;
    private String conditionCoffee;
    private double price;


    public Coffee(String typeCoffee, String conditionCoffee,double price) {
        this.typeCoffee = typeCoffee;
        this.conditionCoffee = conditionCoffee;
        this.price=price;
    }

    public String getTypeCoffee() {
        return typeCoffee;
    }

    public void setTypeCoffee(String typeCoffee) {
        this.typeCoffee = typeCoffee;
    }

    public String getConditionCoffee() {
        return conditionCoffee;
    }

    public void setConditionCoffee(String conditionCoffee) {
        this.conditionCoffee = conditionCoffee;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price=price;


    }

    @Override
    public String toString() {
        return "Coffee{" +
                "price=" + price +
                ", conditionCoffee='" + conditionCoffee + '\'' +
                ", typeCoffee='" + typeCoffee + '\'' +
                '}';
    }

//    private void price(String typeCoffee,String conditionCoffee){
//
//        if (typeCoffee == "Arabica" && conditionCoffee == "Grain") {
//            price = 0.93;
//        } else if (typeCoffee == "Arabica" && conditionCoffee == "Ground") {
//            price = 0.75;
//        } else if (typeCoffee == "Arabica" && conditionCoffee == "Instant" ){
//            price = 0.45;
//        }
//
//
//        if (typeCoffee == "Robusta" && conditionCoffee == "Grain") {
//            price = 0.8;
//        } else if (typeCoffee == "Robusta" && conditionCoffee == "Ground") {
//            price = 0.55;
//        } else if (typeCoffee == "Robusta" && conditionCoffee == "Instant" ){
//            price = 0.35;
//        }
//
//
//    }
}
