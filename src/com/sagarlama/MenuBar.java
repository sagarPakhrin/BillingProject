package com.sagarlama;

import javax.swing.*;
import java.awt.*;
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
        JMenuItem editStudent = new JMenuItem("Edit Student");
        JMenuItem studentDetails = new JMenuItem("Student Details");
        JMenuItem dueFee = new JMenuItem("Due Fee");


//        Action Listeners

        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStudent.main(new String[]{});
            }
        });

        editStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditStudent.main(new String[]{});
            }
        });

        studentDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewStudent.main(new String[]{});
            }
        });

        dueFee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DueFee.main(new String[]{});
            }
        });

        deleteStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteStudent.main(new String[]{});
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(MenuBar.this,"Dou want to exit?","Confirm Exit!!",JOptionPane.OK_CANCEL_OPTION);
                if (action==JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });



//        Adding Mneumonics
        fileMenu.setMnemonic(KeyEvent.VK_F);
        editMenu.setMnemonic(KeyEvent.VK_E);
        exitItem.setMnemonic(KeyEvent.VK_X);
        viewMenu.setMnemonic(KeyEvent.VK_V);
        addStudent.setMnemonic(KeyEvent.VK_A);
        deleteStudent.setMnemonic(KeyEvent.VK_D);
        editStudent.setMnemonic(KeyEvent.VK_S);
        studentDetails.setMnemonic(KeyEvent.VK_S);
        dueFee.setMnemonic(KeyEvent.VK_D);


//        Adding Accelectors
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        addStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        deleteStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));





        fileMenu.add(addStudent);
        fileMenu.add(deleteStudent);
        fileMenu.add(exitItem);


        editMenu.add(editStudent);
        editMenu.add(deleteStudent);

        viewMenu.add(studentDetails);
        viewMenu.add(dueFee);


        add(fileMenu);
        add(editMenu);
        add(viewMenu);
    }
}
