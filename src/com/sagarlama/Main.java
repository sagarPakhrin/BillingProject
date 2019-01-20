package com.sagarlama;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    static Main frame;
    private JPanel contentPane;
    private JTextField nameField;
    private JPasswordField passwordField;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    frame = new Main();
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

        Container container = getContentPane();
        contentPane = new JPanel(new GridBagLayout());

//        Labels and Buttons declarations
        JLabel lblName = new JLabel("Username");
        JLabel lblPassword = new JLabel("Password");
        nameField=new JTextField(15);
        passwordField=new JPasswordField(15);
        JButton btnLogin = new JButton("Login");
        JButton btnBack = new JButton("Back");

//        GridBagLayout declaration
        GridBagConstraints gc = new GridBagConstraints();

//        Action Listener
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                boolean status = AccountDatabase.validate(name,password);
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
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        contentPane.add(lblName,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        contentPane.add(nameField,gc);

        gc.gridy++;
        gc.gridx=0;
        gc.anchor = GridBagConstraints.LINE_END;
        contentPane.add(lblPassword,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        contentPane.add(passwordField,gc);


        gc.gridy++;
        gc.gridx=0;
        gc.anchor = GridBagConstraints.LINE_END;
        contentPane.add(btnLogin,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        contentPane.add(btnBack,gc);


        setLocationRelativeTo(null);
        setResizable(false);
        container.add(contentPane);
    }
}
