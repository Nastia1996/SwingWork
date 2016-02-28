package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;



public class WorkTableModelCoffee extends AbstractTableModel {

    private ArrayList<Coffee> coffeeList;
    private int columnCount=3;


    public WorkTableModelCoffee(ArrayList<Coffee> coffees){
        this.coffeeList=coffees;
    }
    @Override
    public int getRowCount() {
        return coffeeList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Coffee coffee = coffeeList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return coffee.getTypeCoffee();
            case 1:
                return coffee.getConditionCoffee();
            case 2:
                return coffee.getPrice();
        }

        return "";
    }



    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Сорт кофе";
            case 1:
                return "Состояние";
            case 2:
                return "Цена за грамм";
        }
        return "";
    }


    public void removeRow(int row){
        coffeeList.remove(row);

    }
    public void clear(){
        coffeeList.clear();
    }

    public void addData(Coffee coffee){
        coffeeList.add(coffee);
    }
}
