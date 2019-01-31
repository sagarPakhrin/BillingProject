package com.sagarlama;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AddStudent extends JFrame {
    static AddStudent frame;
    private JPanel contentPane;
    private MenuBar myMenubar=new MenuBar();
    private JTextField nameField;
    private JTextField emailField;
    private JTextField gradeField;
    private JTextField feeField;
    private JTextField paidField;
    private JTextField dueField;
    private JTextField addressField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField countryField;
    private JTextField contactNoField;
    private JButton addButton;
    private JButton cancelButton;

//    Main Method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    frame = new AddStudent();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public AddStudent(){
        super("Add new Student");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(450,450));

        contentPane = new JPanel(new GridBagLayout());
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        GridBagConstraints gc = new GridBagConstraints();
        setContentPane(contentPane);

        setJMenuBar(myMenubar);

//        Setting Heading
        JLabel lblAddAccountant = new JLabel("Add Student");
        lblAddAccountant.setForeground(Color.DARK_GRAY);
        lblAddAccountant.setFont(new Font("Tahoma", Font.PLAIN, 20));


//        Lables
        JLabel lblName = new JLabel("Name:");
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblGrade = new JLabel("Grade:");
        JLabel lblFee = new JLabel("Fee:");
        JLabel lblPaid = new JLabel("Paid:");
        JLabel lblDue = new JLabel("Due:");
        JLabel lblAddress = new JLabel("Address:");
        JLabel lblCity = new JLabel("City:");
        JLabel lblState = new JLabel("State:");
        JLabel lblCountry = new JLabel("Country:");
        JLabel lblContactNo = new JLabel("Contact No:");


//        Buttons
        addButton = new JButton("Submit");
        cancelButton = new JButton("Cancel");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                int grade = Integer.parseInt(gradeField.getText());
                int fee = Integer.parseInt(feeField.getText());
                int paid = Integer.parseInt(paidField.getText());
                int due = Integer.parseInt(dueField.getText());
                String address = addressField.getText();
                String city = cityField.getText();
                String state = stateField.getText();
                String country = countryField.getText();
                String contactno = contactNoField.getText();

                Student student = new Student(name, email, grade, fee, paid, due, address, city, state, country, contactno);
                int status = StudentDatabase.save(student);

                if (status > 0) {
                    JOptionPane.showMessageDialog(AddStudent.this, "Student added successfully!");
                    nameField.setText("");
                    emailField.setText("");
                    gradeField.setText("");
                    feeField.setText("");
                    paidField.setText("");
                    dueField.setText("");
                    addressField.setText("");
                    cityField.setText("");
                    stateField.setText("");
                    countryField.setText("");
                    contactNoField.setText("");
                } else {
                    JOptionPane.showMessageDialog(AddStudent.this, "Error adding the student, Please Try again");
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

//        TextFields

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        gradeField = new JTextField(20);
        feeField = new JTextField(20);
        paidField = new JTextField(20);
        dueField = new JTextField(20);
        addressField = new JTextField(20);
        cityField = new JTextField(20);
        stateField = new JTextField(20);
        countryField = new JTextField(20);
        contactNoField = new JTextField(20);


        dueField.setEditable(false);
        paidField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                int fee = Integer.parseInt(feeField.getText());
                int paid = Integer.parseInt(paidField.getText());
                int due = fee - paid;
                dueField.setText(Integer.toString(due));
            }
        });

//        Adding Lables to content pane
        gc.gridy=0;
        gc.gridx=0;
        gc.weightx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        contentPane.add(lblName,gc);
        gc.gridy++;
        contentPane.add(lblEmail,gc);
        gc.gridy++;
        contentPane.add(lblGrade,gc);
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
        contentPane.add(addButton,gc);



//        Adding TextFiels
        gc.gridy=0;
        gc.gridx=1;
        gc.weightx=0.5;
        gc.anchor=GridBagConstraints.LINE_START;
        contentPane.add(nameField,gc);
        gc.gridy++;
        contentPane.add(emailField,gc);
        gc.gridy++;
        contentPane.add(gradeField,gc);
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




        setLocationRelativeTo(null);
    }
}
