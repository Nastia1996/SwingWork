package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame {

    private JLabel mainLabel=new JLabel("Добро пожаловать!");
    private JButton coffeeButton=new JButton("Список сортов кофе");
    private JButton coffeePackageButton=new JButton("Упаковки кофе");
    private JButton loadWagonButton=new JButton("Загрузка вагона");
    private JButton exitButton=new JButton("Выйти");



   public MainFrame(){
       setLayout(new GridBagLayout());
   }


   public void init(){
       setTitle("Главное меню");
       setSize(300,300);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//что произойдет при завершении программы
       setLocationRelativeTo(null);//форма откроется посередине экрана
       setBackground(new Color(14, 84, 32));
       add(mainLabel, new GridBagConstraints(2, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
       add(coffeeButton, new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
       add(coffeePackageButton, new GridBagConstraints(2, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
       add(loadWagonButton, new GridBagConstraints(2, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
       add(exitButton, new GridBagConstraints(3, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
       ActionButton();
       //pack();

       setVisible(true);
   }


    public void ActionButton(){
        coffeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WorkTableFrame workTableFrame=new WorkTableFrame();
                workTableFrame.initCoffee();
            }
        });

        coffeePackageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WorkTableFrame workTableFrame=new WorkTableFrame();
                workTableFrame.initPackageCoffee();
            }
        });


        loadWagonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WorkTableFrame workTableFrame=new WorkTableFrame();
                workTableFrame.initLoadWagon();
            }
        });
    }
}
