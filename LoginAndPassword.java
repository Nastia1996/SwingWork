package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginAndPassword {


    private String login;
    private String password;
    private ArrayList<String > loginList;
    private ArrayList<char []> passwordList;



    public LoginAndPassword(){
        loginList=new ArrayList<String>();
        passwordList=new ArrayList<>();

        char []pasList={'1','2','3'};
        passwordList.add(pasList);

        String str="123";
        loginList.add(str);
    }

    public void add(String login,char[] password){
        loginList.add(login) ;
        passwordList.add(password) ;
    }

    public boolean prov(String login,char[] password){
        int k=-1;
        int p=-1;
        for (int i=0;i<loginList.size();i++){
            if (loginList.get(i).equals(login)) k=0;
            if (Arrays.equals(passwordList.get(i),password)) p=0;
            System.out.println(k+"   "+p);
        }
        if (k==0 && p==0) return true;
        else return  false;
    }

}
