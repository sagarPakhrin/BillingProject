package com.sagarlama;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setSize(400,400);
        GridBagConstraints gc = new GridBagConstraints();
        setLocationRelativeTo(null);
        contentPane = new JPanel(new GridBagLayout());
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);

//        setting menubar
        setJMenuBar(createMenuBar());


        JLabel lblAccountantSection = new JLabel("Accountant Section");
        lblAccountantSection.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAccountantSection.setForeground(Color.DARK_GRAY);



        JButton btnNewButton = new JButton("Add Student");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddStudent.main(new String[]{});
            }
        });


        JButton btnViewStudent = new JButton("View Student");
        btnViewStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewStudent.main(new String[]{});
            }
        });

        JButton btnEditStudent = new JButton("Edit Student");
        btnEditStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                EditStudent.main(new String[]{});
                frame.dispose();
            }
        });

        JButton btnDueFee = new JButton("Due Fee");
        btnDueFee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DueFee.main(new String[]{});
            }
        });

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                FeeReport.main(new String[]{});
                frame.dispose();
            }
        });
        gc.gridy=0;
        gc.gridx=0;
        contentPane.add(lblAccountantSection,gc);
        gc.gridy++;
        contentPane.add(btnNewButton,gc);
        gc.gridy++;
        contentPane.add(btnViewStudent,gc);
        gc.gridy++;
        contentPane.add(btnEditStudent,gc);
        gc.gridy++;
        contentPane.add(btnDueFee,gc);
        gc.gridy++;
        contentPane.add(btnLogout,gc);
    }




    //    Adding Menues
    public JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");


//        Menuitems for file menu
        JMenuItem addStudent = new JMenuItem("Add Student");
        JMenuItem deleteStudent = new JMenuItem("Delete Student");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(addStudent);
        fileMenu.add(deleteStudent);
        fileMenu.add(exitItem);

        return menuBar;
    }
}
