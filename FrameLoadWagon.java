package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrameLoadWagon extends JFrame {

    JPanel panelCoffeeTable=new JPanel();
    JPanel panelCoffeePackageTable=new JPanel();
    JPanel panelLoadWagon=new JPanel();
    JButton deleteWagonButton=new JButton("Удалить продукт");
    JButton loadWagonButton=new JButton("Добавить в фургон");
    JLabel label=new JLabel("Объём фургона(kg)");
    JTextField textField= new JTextField(10);
    double sum=0;

    ArrayList<LoadWagon> loadWagons;

    public FrameLoadWagon() {
        setLayout(new BorderLayout());
    }

    public void initFrameLoadWagon(ArrayList<Coffee> coffeeList,ArrayList<CoffeePackage> coffeePackages){
        setTitle("Загрузка фургона");
        setSize(700, 700);
        panelCoffeePackageTable.setLayout(new GridBagLayout());
        panelCoffeeTable.setLayout(new GridBagLayout());
        panelLoadWagon.setLayout(new GridBagLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panelCoffeeTable, BorderLayout.WEST);
        add(panelCoffeePackageTable,BorderLayout.CENTER);
        add(panelLoadWagon,BorderLayout.EAST);
        setLocationRelativeTo(null);
        coffeeList.add(new Coffee("Arabica", "Grain",0.96));
        coffeeList.add(new Coffee("Arabica", "Instant",0.72));
        coffeeList.add(new Coffee("Arabica", "Ground",0.54));
        coffeeList.add(new Coffee("Robusta", "Grain",0.81));
        coffeeList.add(new Coffee("Robusta", "Instant",0.64));
        coffeeList.add(new Coffee("Robusta", "Ground",0.49));

        WorkTableModelCoffee workTableModelCoffee=new WorkTableModelCoffee(coffeeList);
        JTable tableCoffee=new JTable(workTableModelCoffee);
        JScrollPane tableCoffeeScrollpane=new JScrollPane(tableCoffee);
        tableCoffeeScrollpane.setPreferredSize(new Dimension(200, 200));
        tableCoffee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panelCoffeeTable.setBackground(new Color(100, 205, 244));
        panelCoffeePackageTable.setBackground(new Color(158, 165, 244));

        coffeePackages.add(new CoffeePackage("Small", 0.1));
        coffeePackages.add(new CoffeePackage("Middle", 0.5));
        coffeePackages.add(new CoffeePackage("Big", 0.9));

        WorkTablePackageCoffee workTablePackageCoffee=new WorkTablePackageCoffee(coffeePackages);
        JTable tableCoffeePackage=new JTable(workTablePackageCoffee);
        JScrollPane tableCoffeePackageScrollpane=new JScrollPane(tableCoffeePackage);
        tableCoffeePackageScrollpane.setPreferredSize(new Dimension(200, 200));
        tableCoffeePackage.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        panelCoffeeTable.add(tableCoffeeScrollpane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panelCoffeePackageTable.add(tableCoffeePackageScrollpane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        setVisible(true);
        ArrayList<LoadWagon> loadWagons=new ArrayList<LoadWagon>();
        WorkTableModelLoadWagon workTableModelLoadWagon=new WorkTableModelLoadWagon(loadWagons);
        JTable tableLoadWagon=new JTable(workTableModelLoadWagon);
        JScrollPane tableLoadWagonScrollpane=new JScrollPane(tableLoadWagon);
        tableLoadWagonScrollpane.setPreferredSize(new Dimension(300, 300));
        tableLoadWagon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panelLoadWagon.add(tableLoadWagonScrollpane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        panelLoadWagon.add(deleteWagonButton,new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panelLoadWagon.add(loadWagonButton,new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panelLoadWagon.add(label,new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panelLoadWagon.add(textField, new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        deleteWagonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tableLoadWagon.getSelectedRow();
                System.out.println(i);
                if (i == -1) {
                    JOptionPane.showMessageDialog(null,
                            "Строка не выбрана!",
                            "Некорректные данные",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    workTableModelLoadWagon.removeRow(i);
                    workTableModelLoadWagon.fireTableDataChanged();
                }
            }
        });



        loadWagonButton.addActionListener(new ActionListener() {
          @Override
            public void actionPerformed(ActionEvent e) {
                int i=tableCoffee.getSelectedRow();
                int j=tableCoffeePackage.getSelectedRow();
                if (i==-1 & j==-1){
                    JFrame addFrame = new JFrame("Добавление продукта");
                    addFrame.setSize(new Dimension(600, 600));
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//что произойдет при завершении программы
                    setLocationRelativeTo(null);//форма откроется посередине экрана
                    addFrame.setLayout(new GridBagLayout());

                    JLabel label1 = new JLabel("Сорт кофе");
                    JLabel label2 = new JLabel("Состояние");
                    JLabel label3 = new JLabel("Цена кофе за грамм");
                    JLabel label4 = new JLabel("Тип упаковки");
                    JLabel label5 = new JLabel("Размер упаковки(кг)");
                    JTextField textField1 = new JTextField(20);
                    JTextField textField2 = new JTextField(20);
                    JTextField textField3 = new JTextField(20);
                    JTextField textField4 = new JTextField(20);
                    JTextField textField5 = new JTextField(20);
                    addFrame.add(label1, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    addFrame.add(label2, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    addFrame.add(label3, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    addFrame.add(label4, new GridBagConstraints(0,3, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    addFrame.add(label5, new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

                    addFrame.add(textField1, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    addFrame.add(textField2, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    addFrame.add(textField3, new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    addFrame.add(textField4, new GridBagConstraints(1, 3, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    addFrame.add(textField5, new GridBagConstraints(1, 4, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

                    JButton newAddButton = new JButton("Добавить упаковку");
                    addFrame.add(newAddButton, new GridBagConstraints(1, 5, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    addFrame.pack();

                    newAddButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {


                            String coffeeType = textField1.getText();
                            String coffeeCondition = textField2.getText();
                            String price = textField3.getText();
                            String coffeeTypePackage = textField4.getText();
                            String coffeePackageSize = textField5.getText();

                            double size=Double.valueOf(textField.getText());
                            double sizepackage=Double.valueOf(coffeePackageSize);
                            System.out.println(size);
                            System.out.println(sizepackage);
                            sum += sizepackage;
                            if (size<sum){
                                JOptionPane.showMessageDialog(null,
                                        "Фургон переполнен!",
                                        "Некорректные данные",
                                        JOptionPane.ERROR_MESSAGE);


                            } else {
                            LoadWagon loadWagon=new LoadWagon(coffeeType,coffeeCondition, Double.valueOf(price),coffeeTypePackage,Double.valueOf(coffeePackageSize));
                            workTableModelLoadWagon.addData(loadWagon);
                            workTableModelLoadWagon.fireTableDataChanged();}
                            addFrame.dispose();


                        }
                    });
                    addFrame.setVisible(true);
                }
                else {
                    String typeCoffee=String.valueOf(tableCoffee.getValueAt(i, 0));
                    String conditionCoffee=String.valueOf(tableCoffee.getValueAt(i, 1));
                    Double priceCoffee=Double.valueOf(String.valueOf(tableCoffee.getValueAt(i, 2)));

                    System.out.println(typeCoffee);

                    String typePackage=String.valueOf(tableCoffeePackage.getValueAt(j, 0));
                    Double sizePackage=Double.valueOf(String.valueOf(tableCoffee.getValueAt(j, 1)));
                    System.out.println(sizePackage);
//

                    LoadWagon loadWagon=new LoadWagon(typeCoffee,conditionCoffee,priceCoffee,typePackage,sizePackage);
//                    loadWagons.add(loadWagon);
//                    WorkTableModelLoadWagon workTableModelLoadWagon=new WorkTableModelLoadWagon(loadWagons);
//                    workTableModelLoadWagon.fireTableDataChanged();

                }
            }
        });

    }
}

