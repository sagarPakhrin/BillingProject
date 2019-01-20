package com.sagarlama;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDatabase {
    public static Connection getCon(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/BillingProject","root","Su1was4na3");
        }catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }

    public static boolean validate(String name, String password){
        boolean status = false;
        try{
            Connection connection = getCon();
            PreparedStatement statement=connection.prepareStatement("SELECT 2, 3 FROM accountant");
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                if (name==resultSet.getString("name")){
                    if (password == resultSet.getString("password")){
                        status=true;
                    }
                }
            }
            connection.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return status;
    }
}
