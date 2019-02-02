package com.sagarlama;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class DeleteStudent extends JFrame {
    static DeleteStudent frame;
    private JPanel contentPane;
    private JPanel topPane;
    private JPanel mainPane;
    private JPanel btnPane;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField gradeField;
    private JTextField feeField;
    private JTextField paidField;
    private JTextField dueField;
    private JTextArea addressField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField countryField;
    private JTextField contactNoField;
    private JTextField rollNoField;
    private Color inputFieldColor = new Color(143, 228, 216);
    private Color brand = new Color(245, 248, 255);
    private Font labelFont = new Font("Crimson Text",Font.BOLD,14);
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new DeleteStudent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public DeleteStudent() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contentPane = new JPanel(new GridBagLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(226,251,221));
        topPane = new JPanel(new GridBagLayout());
        mainPane = new JPanel(new GridBagLayout());
        btnPane = new JPanel(new GridBagLayout());
        topPane.setBackground(new Color(226,251,221));
        mainPane.setBackground(new Color(226,251,221));
        btnPane.setBackground(new Color(226,251,221));
        GridBagConstraints gc = new GridBagConstraints();
        GridBagConstraints btnGc = new GridBagConstraints();
        setContentPane(contentPane);
        setMinimumSize(new Dimension(525,450));
        setResizable(true);

        JLabel lblName = new JLabel("Name:");
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblGrade = new JLabel("Course:");
        JLabel lblFee = new JLabel("Fee:");
        JLabel lblPaid = new JLabel("Paid:");
        JLabel lblDue = new JLabel("Due:");
        JLabel lblAddress = new JLabel("Address:");
        JLabel lblCity = new JLabel("City:");
        JLabel lblState = new JLabel("State:");
        JLabel lblCountry = new JLabel("Country:");
        JLabel lblContactNo = new JLabel("Contact No:");
        JLabel lblRollNo = new JLabel("Roll No:");


        nameField= new JTextField(20);
        emailField = new JTextField(20);
        gradeField = new JTextField(20);
        feeField = new JTextField(20);
        paidField = new JTextField(20);
        dueField = new JTextField(20);
        cityField = new JTextField(20);
        stateField = new JTextField(20);
        countryField = new JTextField(20);
        contactNoField = new JTextField(20);
        rollNoField = new JTextField(20);
        addressField = new JTextArea();

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name=nameField.getText();
                String email=emailField.getText();
                int grade=Integer.parseInt(gradeField.getText());
                int fee=Integer.parseInt(feeField.getText());
                int paid=Integer.parseInt(paidField.getText());
                int due=Integer.parseInt(dueField.getText());
                String address=addressField.getText();
                String city=cityField.getText();
                String state=stateField.getText();
                String country=countryField.getText();
                String contactno=contactNoField.getText();
                int rollno=Integer.parseInt(rollNoField.getText());

                Student s=new Student(rollno,name,email,grade,fee,paid,due,address,city,state,country,contactno);
                int status=StudentDatabase.deleteStudent(s);

                if(status>0){
                    JOptionPane.showMessageDialog(DeleteStudent.this,"Student Deleted");
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
                    rollNoField.setText("");
                    contactNoField.setText("");
                }else{
                    JOptionPane.showMessageDialog(DeleteStudent.this,"Sorry, Unable to delete student!");
                }
            }
        });


        nameField.setBackground(inputFieldColor);
        emailField.setBackground(inputFieldColor);
        gradeField.setBackground(inputFieldColor);
        feeField.setBackground(inputFieldColor);
        dueField.setBackground(inputFieldColor);
        paidField.setBackground(inputFieldColor);
        addressField.setBackground(inputFieldColor);
        cityField.setBackground(inputFieldColor);
        stateField.setBackground(inputFieldColor);
        countryField.setBackground(inputFieldColor);
        rollNoField.setBackground(inputFieldColor);
        countryField.setBackground(inputFieldColor);
        contactNoField.setBackground(inputFieldColor);

        nameField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        emailField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        gradeField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        feeField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        dueField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        paidField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        addressField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        cityField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        stateField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        countryField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        rollNoField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        countryField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));
        contactNoField.setBorder(BorderFactory.createMatteBorder(0,0,0,0,brand));

        JButton btnBack = new JButton("Cancel");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AccountantSection.main(new String[]{});
                frame.dispose();
            }
        });



        JSeparator separator = new JSeparator();

        JButton btnLoadRecord = new JButton("Load Record");
        btnLoadRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String srollno=rollNoField.getText();
                if(srollno==null||srollno.trim().equals("")){
                    JOptionPane.showMessageDialog(DeleteStudent.this,"Please enter rollno first!");
                }else{
                    int rollno=Integer.parseInt(srollno);
                    Student s=StudentDatabase.getStudentByRollNo(rollno);
                    nameField.setText(s.getName());
                    emailField.setText(s.getEmail());
                    gradeField.setText(String.valueOf(s.getGrade()));
                    feeField.setText(String.valueOf(s.getFee()));
                    dueField.setText(String.valueOf(s.getPaid()));
                    paidField.setText(String.valueOf(s.getDue()));
                    addressField.setText(s.getAddress());
                    cityField.setText(s.getCity());
                    stateField.setText(s.getState());
                    countryField.setText(s.getCountry());
                    rollNoField.setText(String.valueOf(s.getRollno()));
                    contactNoField.setText(s.getContactno());
                }
            }
        });

        btnBack.setFont(labelFont);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);
        btnBack.setForeground(Color.white);
        btnBack.setBackground(new Color(42, 94, 84));
        btnLoadRecord.setFont(labelFont);
        btnLoadRecord.setBorderPainted(false);
        btnLoadRecord.setFocusPainted(false);
        btnLoadRecord.setForeground(Color.white);
        btnLoadRecord.setBackground(new Color(42, 94, 84));
        btnDelete.setFont(labelFont);
        btnDelete.setBorderPainted(false);
        btnDelete.setFocusPainted(false);
        btnDelete.setForeground(Color.white);
        btnDelete.setBackground(new Color(42, 94, 84));

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

        ;
        gc.gridy=0;
        gc.gridx=0;
        gc.weightx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets = new Insets(4,10,4,10);
        topPane.add(lblRollNo,gc);
        gc.gridx++;
        topPane.add(rollNoField,gc);
        gc.gridx++;
        gc.gridx++;
        topPane.add(btnLoadRecord,gc);


        gc.gridy=0;
        gc.gridx=0;
        gc.weightx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets = new Insets(4,10,4,10);
        mainPane.add(lblName,gc);
        gc.gridy++;
        mainPane.add(lblEmail,gc);
        gc.gridy++;
        mainPane.add(lblGrade,gc);
        gc.gridy++;
        mainPane.add(lblFee,gc);
        gc.gridy++;
        mainPane.add(lblPaid,gc);
        gc.gridy++;
        mainPane.add(lblDue,gc);
        gc.gridy++;
        mainPane.add(lblAddress,gc);
        gc.gridy++;
        mainPane.add(lblCity,gc);
        gc.gridy++;
        mainPane.add(lblState,gc);
        gc.gridy++;
        mainPane.add(lblCountry,gc);
        gc.gridy++;
        mainPane.add(lblContactNo,gc);





//        Adding TextFiels
        gc.gridy=0;
        gc.gridx=1;
        gc.weightx=0.5;
        gc.anchor=GridBagConstraints.LINE_START;
        mainPane.add(nameField,gc);
        gc.gridy++;
        mainPane.add(emailField,gc);
        gc.gridy++;
        mainPane.add(gradeField,gc);
        gc.gridy++;
        mainPane.add(feeField,gc);
        gc.gridy++;
        mainPane.add(paidField,gc);
        gc.gridy++;
        mainPane.add(dueField,gc);
        gc.gridy++;
        mainPane.add(addressField,gc);
        gc.gridy++;
        mainPane.add(cityField,gc);
        gc.gridy++;
        mainPane.add(stateField,gc);
        gc.gridy++;
        mainPane.add(countryField,gc);
        gc.gridy++;
        mainPane.add(contactNoField,gc);
//
//


        btnGc.gridx=0;
        btnGc.gridy=0;
        btnGc.insets = new Insets(4,10,4,10);
        btnPane.add(btnDelete,btnGc);
        btnGc.gridx++;
        btnPane.add(btnBack,btnGc);


        gc.gridy=0;
        gc.gridx=0;
        gc.fill= GridBagConstraints.HORIZONTAL;
        contentPane.add(topPane,gc);
        gc.gridy++;
        contentPane.add(mainPane,gc);
        gc.gridy++;
        contentPane.add(btnPane,gc);


        setLocationRelativeTo(null);
    }
}

