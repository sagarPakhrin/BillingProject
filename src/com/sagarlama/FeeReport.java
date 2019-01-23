package com.sagarlama;

import javax.swing.*;
import java.awt.*;

public class FeeReport extends JFrame {
    static FeeReport frame;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame=new FeeReport();
                frame.setVisible(true);
            }
        });
    }




    public FeeReport(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(1000,1000));
    }
}
