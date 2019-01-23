package com.sagarlama;

import javax.swing.*;
import java.util.List;

public class ViewStudent extends JFrame {
    static ViewStudent frame;
    public ViewStudent(){
        List<Student> list =StudentDatabase.view();
        int size=list.size();
        String data[][]=new String[size][12];
        int row=0;
        for (Student student:list){
            data[row][0]=String.valueOf(student.getRollno());
            data[row][1]=student.getName();
            data[row][2]=student.getEmail();
            data[row][3]=student.getCourse();
            data[row][4]=String.valueOf(student.getFee());
            data[row][5]=String.valueOf(student.getPaid());
            data[row][6]=String.valueOf(student.getDue());
            data[row][7]=student.getAddress();
            data[row][8]=student.getCity();
            data[row][9]=student.getState();
            data[row][10]=student.getCountry();
            data[row][11]=student.getContactno();
            row++;
        }
        String columnNames[]={"Rollno","Name","Email","Course","Fee","Paid","Due","Address","City","State","Country","Contact No"};
        JTable table = new JTable(data,columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800,400);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    frame = new ViewStudent();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
