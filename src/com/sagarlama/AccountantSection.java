package com.sagarlama;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AccountantSection extends JFrame{
    static AccountantSection frame;
    private JPanel contentPane;
    private MenuBar myMenuBar=new MenuBar();
    private Font btnFont = new Font("Crimson Text",Font.BOLD,17);
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
        GridBagConstraints gc = new GridBagConstraints();
        setLocationRelativeTo(null);
        contentPane = new JPanel(new GridBagLayout());
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setBackground(new Color(232,232,232));
        setContentPane(contentPane);

//        setting menubar
        setJMenuBar(myMenuBar);


        JLabel lblAccountantSection = new JLabel("Accountant Section");
        lblAccountantSection.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAccountantSection.setForeground(Color.DARK_GRAY);



        JButton btnNewButton = new JButton("Add Student");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddStudent.main(new String[]{});
                frame.dispose();
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
                Main.main(new String[]{});
                frame.dispose();
            }
        });

        btnNewButton.setForeground(Color.white);
        btnNewButton.setBackground(new Color(14, 75, 84));
        btnNewButton.setBorderPainted(false);
        btnNewButton.setFont(btnFont);
        btnViewStudent.setForeground(Color.white);
        btnViewStudent.setBackground(new Color(14, 75, 84));
        btnViewStudent.setBorderPainted(false);
        btnViewStudent.setFont(btnFont);
        btnEditStudent.setForeground(Color.white);
        btnEditStudent.setBackground(new Color(14, 75, 84));
        btnEditStudent.setBorderPainted(false);
        btnEditStudent.setFont(btnFont);
        btnDueFee.setForeground(Color.white);
        btnDueFee.setBackground(new Color(14, 75, 84));
        btnDueFee.setBorderPainted(false);
        btnDueFee.setFont(btnFont);
        btnLogout.setForeground(Color.white);
        btnLogout.setBackground(new Color(14, 75, 84));
        btnLogout.setBorderPainted(false);
        btnLogout.setFont(btnFont);




        gc.gridy=0;
        gc.gridx=0;
        gc.insets = new Insets(4,10,4,10);
        gc.fill=GridBagConstraints.HORIZONTAL;
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





        setMinimumSize(new Dimension(400,400));
        setLocationRelativeTo(null);
        setResizable(false);
    }

}
