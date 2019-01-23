package com.sagarlama;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditStudent extends JFrame {
    static EditStudent frame;
    private JPanel contentPane;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField courseField;
    private JTextField feeField;
    private JTextField paidField;
    private JTextField dueField;
    private JTextField addressField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField countryField;
    private JTextField contactNoField;
    private JButton updateButton;
    private JButton cancelButton;
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
        contentPane = new JPanel(new GridBagLayout());
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        GridBagConstraints gc = new GridBagConstraints();
        setContentPane(contentPane);









//        Lables
        JLabel lblName = new JLabel("Name:");
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblCourse = new JLabel("Course:");
        JLabel lblFee = new JLabel("Fee:");
        JLabel lblPaid = new JLabel("Paid:");
        JLabel lblDue = new JLabel("Due:");
        JLabel lblAddress = new JLabel("Address:");
        JLabel lblCity = new JLabel("City:");
        JLabel lblState = new JLabel("State:");
        JLabel lblCountry = new JLabel("Country:");
        JLabel lblContactNo = new JLabel("Contact No:");


//        Buttons
        updateButton = new JButton("Update");
        cancelButton = new JButton("Cancel");




        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });




        nameField = new JTextField(20);
        emailField = new JTextField(20);
        courseField = new JTextField(20);
        feeField = new JTextField(20);
        paidField = new JTextField(20);
        dueField = new JTextField(20);
        addressField = new JTextField(20);
        cityField = new JTextField(20);
        stateField = new JTextField(20);
        countryField = new JTextField(20);
        contactNoField = new JTextField(20);


//        Adding Lables to content pane
        gc.gridy=0;
        gc.gridx=0;
        gc.weightx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        contentPane.add(lblName,gc);
        gc.gridy++;
        contentPane.add(lblEmail,gc);
        gc.gridy++;
        contentPane.add(lblCourse,gc);
        gc.gridy++;
        contentPane.add(lblFee,gc);
        gc.gridy++;
        contentPane.add(lblPaid,gc);
        gc.gridy++;
        contentPane.add(lblDue,gc);
        gc.gridy++;
        contentPane.add(lblAddress,gc);
        gc.gridy++;
        contentPane.add(lblCity,gc);
        gc.gridy++;
        contentPane.add(lblState,gc);
        gc.gridy++;
        contentPane.add(lblCountry,gc);
        gc.gridy++;
        contentPane.add(lblContactNo,gc);
        gc.gridy++;
        contentPane.add(updateButton,gc);

//        Adding TextFiels
        gc.gridy=0;
        gc.gridx=1;
        gc.weightx=0.5;
        gc.anchor=GridBagConstraints.LINE_START;
        contentPane.add(nameField,gc);
        gc.gridy++;
        contentPane.add(emailField,gc);
        gc.gridy++;
        contentPane.add(courseField,gc);
        gc.gridy++;
        contentPane.add(feeField,gc);
        gc.gridy++;
        contentPane.add(paidField,gc);
        gc.gridy++;
        contentPane.add(dueField,gc);
        gc.gridy++;
        contentPane.add(addressField,gc);
        gc.gridy++;
        contentPane.add(cityField,gc);
        gc.gridy++;
        contentPane.add(stateField,gc);
        gc.gridy++;
        contentPane.add(countryField,gc);
        gc.gridy++;
        contentPane.add(contactNoField,gc);
        gc.gridy++;
        contentPane.add(cancelButton,gc);
    }
}
