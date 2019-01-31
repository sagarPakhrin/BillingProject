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
    private JPanel btnPane;
    private MenuBar myMenubar=new MenuBar();
    private Color bgColor = new Color(66, 66, 66);
    private Color btnColor = new Color(66, 66, 66);
    private Color brand = new Color(10, 47, 54);
    private Font btnFont = new Font("Crimson Text",Font.BOLD,17);
    private Color inputFieldColor = new Color(115, 104, 101);
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
        contentPane.setBackground(bgColor);
        GridBagConstraints gc = new GridBagConstraints();
        btnPane = new JPanel(new GridBagLayout());
        btnPane.setBackground(bgColor);
        GridBagConstraints btnGc = new GridBagConstraints();
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
                AccountantSection.main(new String[]{});
                frame.dispose();
            }
        });


        addButton.setForeground(Color.white);
        addButton.setBackground(btnColor);
        addButton.setBorderPainted(false);
        addButton.setFont(btnFont);
        cancelButton.setForeground(Color.white);
        cancelButton.setBackground(btnColor);
        cancelButton.setBorderPainted(false);
        cancelButton.setFont(btnFont);



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



        nameField.setBackground(inputFieldColor);
        emailField.setBackground(inputFieldColor);
        gradeField.setBackground(inputFieldColor);
        feeField.setBackground(inputFieldColor);
        paidField.setBackground(inputFieldColor);
        dueField.setBackground(inputFieldColor);
        addressField.setBackground(inputFieldColor);
        cityField.setBackground(inputFieldColor);
        stateField.setBackground(inputFieldColor);
        countryField.setBackground(inputFieldColor);
        contactNoField.setBackground(inputFieldColor);

        nameField.setForeground(Color.white);
        emailField.setForeground(Color.white);
        gradeField.setForeground(Color.white);
        feeField.setForeground(Color.white);
        paidField.setForeground(Color.white);
        dueField.setForeground(Color.white);
        addressField.setForeground(Color.white);
        cityField.setForeground(Color.white);
        stateField.setForeground(Color.white);
        countryField.setForeground(Color.white);
        contactNoField.setForeground(Color.white);



        nameField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        emailField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        gradeField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        feeField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        paidField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        dueField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        addressField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        cityField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        stateField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        countryField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        contactNoField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));


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
        gc.insets = new Insets(4,10,4,10);
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


//        gc.gridy++;
//        gc.gridx=1;
//        contentPane.add(addButton,gc);



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


//        gc.gridy++;
//        gc.gridx=2;
//        contentPane.add(cancelButton,gc);

        btnGc.gridx=0;
        btnGc.gridy=0;
        btnGc.insets = new Insets(4,10,4,10);
        btnPane.add(addButton,btnGc);
        btnGc.gridx++;
        btnPane.add(cancelButton,btnGc);

        gc.gridx=0;
        gc.gridy++;
        gc.gridwidth=2;
        gc.fill=GridBagConstraints.HORIZONTAL;
        contentPane.add(btnPane,gc);

        setLocationRelativeTo(null);
    }
}
