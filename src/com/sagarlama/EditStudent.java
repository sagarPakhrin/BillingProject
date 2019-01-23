package com.sagarlama;

import javax.swing.*;
import java.awt.*;

public class EditStudent extends JFrame {
    static EditStudent frame;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    frame = new EditStudent();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public EditStudent(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(800,800));
    }
}
