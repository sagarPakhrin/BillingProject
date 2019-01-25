package com.sagarlama;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
//    static AccountantSection frame;
    static Main frame;
    private JPanel contentPane;
    private JTextField nameField;
    private JPasswordField passwordField;
    private Color brand = new Color(211,24,33);
    private Color bgColor = new Color(61,77,111);
    private Color inputFieldColor = new Color(80,95,128);
    private Font labelFont = new Font("Crimson Text",Font.BOLD,17);


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    frame = new Main();
//                    uncomment the previous line and delete the line under this line after account section is finished
//                    frame = new AccountantSection();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public Main(){
        super("Login");
        setSize(500,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setup Menubar

        Container container = getContentPane();
        contentPane = new JPanel(new GridBagLayout());

//        Labels and Buttons declarations
        JLabel lblName = new JLabel("Username");
        JLabel lblPassword = new JLabel("Password");
        nameField=new JTextField(15);
        passwordField=new JPasswordField(15);
        JButton btnLogin = new JButton("Login");
        JButton btnBack = new JButton("Back");


//        Styling Lables
        lblName.setFont(labelFont);
        lblName.setForeground(Color.white);
        lblPassword.setFont(labelFont);
        lblPassword.setForeground(Color.white);


//        Styling input fields
        nameField.setBackground(inputFieldColor);
        nameField.setForeground(Color.white);
        passwordField.setBackground(inputFieldColor);
        passwordField.setForeground(Color.white);
        nameField.setBorder(BorderFactory.createMatteBorder(0,0,2,0,brand));
        passwordField.setBorder(BorderFactory.createMatteBorder(0,0,2,0,brand));


//        Styling jbuttons
        btnBack.setFont(labelFont);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);
        btnBack.setForeground(Color.white);
        btnBack.setBackground(new Color(52,56,94));
        btnLogin.setFont(labelFont);
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);
        btnLogin.setForeground(Color.white);
        btnLogin.setBackground(new Color(52,56,94));


//        GridBagLayout declaration
        GridBagConstraints gc = new GridBagConstraints();

//        Action Listener
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                boolean status = AccountDatabase.validate(name,password);
                System.out.println(status);
                if (status){
                    AccountantSection.main(new String[]{});
                    frame.dispose();
                }else{
                    JOptionPane.showMessageDialog(Main.this,"Incorrect username or password. Please Try again!!","Error Message",JOptionPane.ERROR_MESSAGE);
                }
            }
        });





//        adding Components
        gc.gridy=0;
        gc.gridx=0;
        gc.weightx = 1;
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.gridwidth=2;
        gc.insets = new Insets(4,10,4,10);
        contentPane.add(lblName,gc);

        gc.gridy++;
        contentPane.add(nameField,gc);

        gc.gridy++;
        contentPane.add(lblPassword,gc);

        gc.gridy++;
        contentPane.add(passwordField,gc);


        gc.gridy++;
        gc.gridwidth=1;
        contentPane.add(btnLogin,gc);

        gc.gridx++;
        contentPane.add(btnBack,gc);


        contentPane.setBackground(bgColor);
        setLocationRelativeTo(null);
        setResizable(false);
        container.add(contentPane);
    }
}
