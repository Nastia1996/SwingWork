package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class WorkTableModelLoadWagon extends AbstractTableModel{

    private ArrayList<LoadWagon> loadWagonList;

    public WorkTableModelLoadWagon(ArrayList<LoadWagon> loadWagonList){
        this.loadWagonList=loadWagonList;
    }

    @Override
    public int getRowCount() {
        return loadWagonList.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LoadWagon loadWagon = loadWagonList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return loadWagon.getTypeCoffee();
            case 1:
                return loadWagon.getConditionCoffee();
            case 2:
                return loadWagon.getPrice();
            case 3:
                return loadWagon.getTypeCoffeePackage();
            case 4:
                return loadWagon.getSizePackage();
            case 5:
                return loadWagon.getPriceCoffeePackage();
        }

        return "";
    }


    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Тип кофе";
            case 1:
                return "Состояние ";
            case 2:
                return "Цена кофе за грамм";
            case 3:
                return "Размер упаковки(кг)";
            case 4:
                return "Тип упаковки";
            case 5:
                return "Цена упаковки";


        }
        return "";
    }
    public void removeRow(int row){
        loadWagonList.remove(row);

    }
    public void clear(){
        loadWagonList.clear();
    }

    public void addData(LoadWagon loadWagon){

        loadWagonList.add(loadWagon);
}
}
