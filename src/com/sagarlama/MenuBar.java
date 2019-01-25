package com.sagarlama;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar {
    public MenuBar(){
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");


//        Menuitems for file menu
        JMenuItem addStudent = new JMenuItem("Add Student");
        JMenuItem deleteStudent = new JMenuItem("Delete Student");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(addStudent);
        fileMenu.add(deleteStudent);
        fileMenu.add(exitItem);


//        Adding Mneumonics
        fileMenu.setMnemonic(KeyEvent.VK_F);
        editMenu.setMnemonic(KeyEvent.VK_E);
        exitItem.setMnemonic(KeyEvent.VK_X);
        viewMenu.setMnemonic(KeyEvent.VK_V);


//        Adding Accelectors
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));


//        Action Listeners
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(MenuBar.this,"Dou want to exit?","Confirm Exit!!",JOptionPane.OK_CANCEL_OPTION);
                if (action==JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });
        add(fileMenu);
        add(editMenu);
        add(viewMenu);
    }
}
