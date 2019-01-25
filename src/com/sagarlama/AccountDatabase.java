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
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/BillingProject","root","");
        }catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }

    public static boolean validate(String n, String p){
        boolean status = false;
        try{
            Connection connection = getCon();
            PreparedStatement statement=connection.prepareStatement("SELECT * from accountant where name=? and password = ?");
            statement.setString(1,n);
            statement.setString(2,p);
            ResultSet resultSet=statement.executeQuery();
            status=resultSet.next();
            connection.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return status;
    }
}
