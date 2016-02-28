package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class WorkTableFrame extends JFrame {

    private JPanel panelMenu=new JPanel();
    private JPanel panelTable=new JPanel();
    private JLabel titleLabel=new JLabel();
    private JButton mainFrameButton=new JButton("Главное меню");

    private JButton addButton=new JButton("Добавить");
    private JButton deleteButton=new JButton("Удалить");
    private JButton clearButton=new JButton("Очистить таблицу");
    private JButton saveButton=new JButton("Сохранить данные");
    private JButton readButton=new JButton("Чтение данных");


    private ArrayList<Coffee> coffeeList= new ArrayList<Coffee>();
    private ArrayList<CoffeePackage> coffeePackages=new ArrayList<CoffeePackage>();

    private File fileCoffee = new File("Coffee.txt");
    private File fileCoffeePackage = new File("CoffeePackage.txt");


    public WorkTableFrame(){
        setLayout(new BorderLayout());
        setTitle("");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//что произойдет при завершении программы
        setLocationRelativeTo(null);//форма откроется посередине экрана
        add(panelMenu, BorderLayout.WEST);
        panelMenu.setLayout(new GridBagLayout());
        panelMenu.add(mainFrameButton, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panelMenu.setBackground(new Color(91, 94, 255));
        panelTable.setBackground(new Color(185, 236, 255));

}

    public void MainFrameButton(){
        mainFrameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void initCoffee(){
        setTitle("Кофе");
        MainFrameButton();
        add(panelTable, BorderLayout.CENTER);
        add(panelTable, BorderLayout.CENTER);
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

        panelTable.add(tableCoffeeScrollpane, new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panelTable.add(addButton, new GridBagConstraints(0, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panelTable.add(deleteButton, new GridBagConstraints(1, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panelTable.add(clearButton, new GridBagConstraints(2, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panelTable.add(saveButton, new GridBagConstraints(3, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panelTable.add(readButton, new GridBagConstraints(4, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        //чтение из файла(не работает)
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner scannerfile = null;
                try {
                    scannerfile = new Scanner(fileCoffee);
                    workTableModelCoffee.fireTableDataChanged();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        //сохранение данных в файл
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter filewriter = null;
                try {
                    filewriter = new FileWriter(new File("Coffee.txt"));
                    for (int i=0;i<coffeeList.size();++i)
                            filewriter.write(coffeeList.get(i) + "\n ");
                            filewriter.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
         }
        });

        //добавление новой записи в таблицу
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addFrame = new JFrame("Добавление кофе");
                addFrame.setSize(new Dimension(600, 600));
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//что произойдет при завершении программы
                setLocationRelativeTo(null);//форма откроется посередине экрана
                addFrame.setLayout(new GridBagLayout());
                JLabel label1 = new JLabel("Сорт кофе");
                JLabel label2 = new JLabel("Состояние ");
                JLabel label3 = new JLabel("Цена за грамм");
                JTextField textField1 = new JTextField(20);
                JTextField textField2 = new JTextField(20);
                JTextField textField3 = new JTextField(20);

                addFrame.add(label1, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                addFrame.add(label2, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                addFrame.add(label3, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                addFrame.add(textField1, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                addFrame.add(textField2, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                addFrame.add(textField3, new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

                JButton newAddButton = new JButton("Добавить кофе");
                addFrame.add(newAddButton, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                addFrame.pack();
                newAddButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String coffeeType = textField1.getText();
                        String coffeeCondition = textField2.getText();
                        String price = textField3.getText();

                        Coffee coffee = new Coffee(coffeeType, coffeeCondition, Double.valueOf(price));

                        workTableModelCoffee.addData(coffee);
                        workTableModelCoffee.fireTableDataChanged();
                        addFrame.dispose();
                    }
                });
                addFrame.setVisible(true);
            }
        });

        //удаление строки таблицы
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tableCoffee.getSelectedRow();
                System.out.println(i);
                if (i == -1) {
                    JOptionPane.showMessageDialog(null,
                            "Строка не выбрана!",
                            "Некорректные данные",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    workTableModelCoffee.removeRow(i);
                    workTableModelCoffee.fireTableDataChanged();
                }
            }
        });

        //удаление данных таблицы
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workTableModelCoffee.clear();
                workTableModelCoffee.fireTableDataChanged();
            }
        });

        setVisible(true);
    }


    public void initPackageCoffee(){
        MainFrameButton();
        setTitle("Упаковки кофе");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//что произойдет при завершении программы
        setLocationRelativeTo(null);//форма откроется посередине экрана
        add(panelTable, BorderLayout.CENTER);

        coffeePackages.add(new CoffeePackage("Small", 0.1));
        coffeePackages.add(new CoffeePackage("Middle", 0.5));
        coffeePackages.add(new CoffeePackage("Big", 0.9));

        WorkTablePackageCoffee workTablePackageCoffee=new WorkTablePackageCoffee(coffeePackages);
        JTable tableCoffeePackage=new JTable(workTablePackageCoffee);
        JScrollPane tableCoffeePackageScrollpane=new JScrollPane(tableCoffeePackage);
        tableCoffeePackageScrollpane.setPreferredSize(new Dimension(200, 200));
        tableCoffeePackage.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        panelTable.add(tableCoffeePackageScrollpane, new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panelTable.add(addButton, new GridBagConstraints(0, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panelTable.add(deleteButton, new GridBagConstraints(1, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panelTable.add(clearButton, new GridBagConstraints(2, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panelTable.add(saveButton, new GridBagConstraints(3, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panelTable.add(readButton, new GridBagConstraints(4, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter filewriter = null;
                try {
                    filewriter = new FileWriter(new File("CoffeePackage.txt"));
                    for (int i = 0; i < coffeePackages.size(); ++i)
                        filewriter.write(coffeePackages.get(i) + "\n ");
                    filewriter.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        //добавление новой записи в таблицу
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addFrame = new JFrame("Добавление упаковки кофе");
                addFrame.setSize(new Dimension(600, 600));
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//что произойдет при завершении программы
                setLocationRelativeTo(null);//форма откроется посередине экрана
                addFrame.setLayout(new GridBagLayout());
                JLabel label1 = new JLabel("Тип упаковки");
                JLabel label2 = new JLabel("Размер упаковки(кг)");
                JTextField textField1 = new JTextField(20);
                JTextField textField2 = new JTextField(20);
                addFrame.add(label1, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                addFrame.add(label2, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                addFrame.add(textField1, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                addFrame.add(textField2, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                JButton newAddButton = new JButton("Добавить упаковку");
                addFrame.add(newAddButton, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                addFrame.pack();

                newAddButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String coffeeTypePackage = textField1.getText();
                        String coffeePackageSize = textField2.getText();
                        CoffeePackage coffeePackage = new CoffeePackage(coffeeTypePackage,Double.valueOf(coffeePackageSize));
                        workTablePackageCoffee.addData(coffeePackage);
                        workTablePackageCoffee.fireTableDataChanged();
                        addFrame.dispose();
                    }
                });
                addFrame.setVisible(true);
            }
        });

        //удаление строки таблицы
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int i = tableCoffeePackage.getSelectedRow();
                System.out.println(i);
                if (i == -1) {
                    JOptionPane.showMessageDialog(null,
                            "Строка не выбрана!",
                            "Некорректные данные",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    workTablePackageCoffee.removeRow(i);
                    workTablePackageCoffee.fireTableDataChanged();
                }
            }
        });

        //удаление данных таблицы
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workTablePackageCoffee.clear();
                workTablePackageCoffee.fireTableDataChanged();
            }
        });
        setVisible(true);
    }

    public void initLoadWagon(){
        FrameLoadWagon frameLoadWagon=new FrameLoadWagon();
        frameLoadWagon.initFrameLoadWagon(coffeeList,coffeePackages);
    }
}
