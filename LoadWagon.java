package com.company;

import java.util.ArrayList;
import java.util.List;

public class LoadWagon {

    private String typeCoffee;
    private String conditionCoffee;
    private double price;
    private String typeCoffeePackage;
    private double sizePackage;
    private double priceCoffeePackage;

    public double getPriceCoffeePackage() {
        return priceCoffeePackage;
    }

    public LoadWagon(String typeCoffee, String conditionCoffee, double price, String typeCoffeePackage, double sizePackage) {
        this.typeCoffee = typeCoffee;
        this.conditionCoffee = conditionCoffee;
        this.price = price;
        this.typeCoffeePackage = typeCoffeePackage;
        this.sizePackage = sizePackage;
        this.priceCoffeePackage=sizePackage*price;
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
        this.price = price;
    }

    public String getTypeCoffeePackage() {
        return typeCoffeePackage;
    }

    public void setTypeCoffeePackage(String typeCoffeePackage) {
        this.typeCoffeePackage = typeCoffeePackage;
    }

    public double getSizePackage() {
        return sizePackage;
    }

    public void setSizePackage(double sizePackage) {
        this.sizePackage = sizePackage;
    }

    public double LoadWagon(ArrayList<CoffeePackage> coffeePackages){
        int i=0;
        double volumeC=0;

        for (i=0;i<coffeePackages.size();i++)
        {
            CoffeePackage pac=coffeePackages.get(i);
            volumeC=volumeC+pac.getSizePackage();
        }
        return volumeC;
    }

    public double PriceWagon(ArrayList<Coffee> coffee){
        int j=0;
        double price=0;

        for (j=0;j<coffee.size();j++){
            Coffee pac=coffee.get(j);
            price=price+pac.getPrice();
        }
        return price;
    }
}
