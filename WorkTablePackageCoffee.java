package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


public class WorkTablePackageCoffee extends AbstractTableModel {

    ArrayList<CoffeePackage> coffeePackages;
    private int countColumn=2;

    public WorkTablePackageCoffee(ArrayList<CoffeePackage> coffeePackages) {
        this.coffeePackages = coffeePackages;
    }

    @Override
    public int getRowCount() {
        return coffeePackages.size();
    }

    @Override
    public int getColumnCount() {
        return countColumn;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CoffeePackage coffeePackage = coffeePackages.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return coffeePackage.getTypeCoffeePackage();
            case 1:
                return coffeePackage.getSizePackage();

        }

        return "";
    }


    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Тип упаковки";
            case 1:
                return "Размер упаковки(кг)";

        }
        return "";
    }
    public void removeRow(int row){
        coffeePackages.remove(row);

    }
    public void clear(){
        coffeePackages.clear();
    }

    public void addData(CoffeePackage coffeePackage){
        coffeePackages.add(coffeePackage);
    }
}
