package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AuthorizationFrame extends JFrame {


    private JLabel loginLabel=new JLabel("Логин: ");
    private JLabel passwordLabel=new JLabel("Пароль: ");
    private JTextField loginField=new JTextField(15);
    private JPasswordField passwordField=new JPasswordField(15);
    private JButton loginbutton=new JButton("Войти");
    private JButton registrationbutton=new JButton("Регистрация");

    public AuthorizationFrame(){
        setLayout(new GridBagLayout());
    }

    public void init(){
        setTitle("Вход в систему...");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//что произойдет при завершении программы
        setLocationRelativeTo(null);//форма откроется посередине экрана
        setBackground(Color.orange);
        add(loginLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(loginField, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(passwordLabel, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(passwordField, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(loginbutton, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(registrationbutton, new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        pack();
        ActionLoginButton();
        setVisible(true);
    }


    private void ActionLoginButton(){
        loginbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String login = loginField.getText();
                char[] password = passwordField.getPassword();
                if (login != null & password.length != 0) {
                        mainFrame();
                } else {
                    loginField.setText("");
                    passwordField.setText("");
                    JOptionPane.showMessageDialog(null,
                            "Некорректные данные",
                            "Некорректные данные",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        registrationbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationFrame registrationFrame=new RegistrationFrame();
                registrationFrame.init();
            }
        });
    }
    public boolean login(){
        String login;
        char []password;
        login=loginField.getText();
        password=passwordField.getPassword();
        LoginAndPassword loginAndPassword=new LoginAndPassword();
        if (loginAndPassword.prov(login,password)) return true;
        else return false;
    }

    public void mainFrame(){
        boolean prov=login();
        System.out.println(prov);
        if (prov) {
            MainFrame mainFrame=new MainFrame();
            mainFrame.init();
            dispose();

        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Неверный логин или пароль",
                    "Некорректные данные",
                    JOptionPane.ERROR_MESSAGE);}

    }
}
