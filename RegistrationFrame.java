package com.company;

import javax.swing.*;
import java.awt.*;


public class RegistrationFrame extends JFrame {

    private JLabel firstnameLabel=new JLabel("Имя: ");
    private JLabel lastnameLabel=new JLabel("Фамилия: ");
    private JTextField firstnameField=new JTextField(15);
    private JTextField lastnameField=new JTextField(15);
    private JLabel emailLabel=new JLabel("Email: ");
    private JTextField emailField=new JTextField(15);
    private JLabel loginLabel=new JLabel("Логин: ");
    private JLabel passwordLabel=new JLabel("Пароль: ");
    private JTextField loginField=new JTextField(15);
    private JPasswordField passwordField=new JPasswordField(15);

    private JButton registrationbutton=new JButton("Регистрация");

    public RegistrationFrame(){
        setLayout(new GridBagLayout());
    }


    public void init(){
        setTitle("Регистрация...");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//что произойдет при завершении программы
        setLocationRelativeTo(null);//форма откроется посередине экрана
        setBackground(Color.orange);
        setLayout(new GridBagLayout());

        add(firstnameLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(firstnameField, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(lastnameLabel, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(lastnameField, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(emailLabel, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(emailField, new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(loginLabel, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(loginField, new GridBagConstraints(1, 3, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(passwordLabel, new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(passwordField, new GridBagConstraints(1, 4, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(registrationbutton, new GridBagConstraints(1, 5, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        pack();
        setVisible(true);
    }

    public void add(){

    }
}

