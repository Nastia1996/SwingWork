package com.company;


public class CoffeePackage {
    String typeCoffeePackage;
    double sizePackage;

    public CoffeePackage(String typeCoffeePackage, double sizePackage) {
        this.typeCoffeePackage = typeCoffeePackage;
        this.sizePackage = sizePackage;
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

    @Override
    public String toString() {
        return "CoffeePackage{" +
                "typeCoffeePackage='" + typeCoffeePackage + '\'' +
                ", sizePackage=" + sizePackage +
                '}';
    }
}
