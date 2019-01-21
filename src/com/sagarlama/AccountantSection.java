package com.sagarlama;

import javax.swing.*;
import java.awt.*;

public class AccountantSection extends JFrame{
    static AccountantSection frame;
    private JPanel contentPane;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    frame = new AccountantSection();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public AccountantSection(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(450,450);
        setLocationRelativeTo(null);
    }


}
