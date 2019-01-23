package com.sagarlama;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDatabase {

    public static List<Student> view(){
        List<Student> list = new ArrayList<Student>();
        try {
            Connection connection = AccountDatabase.getCon();
            PreparedStatement statement = connection.prepareStatement("select * from student");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Student student=new Student();
                student.setRollno(resultSet.getInt("rollno"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setCourse(resultSet.getString("course"));
                student.setFee(resultSet.getInt("fee"));
                student.setPaid(resultSet.getInt("paid"));
                student.setDue(resultSet.getInt("due"));
                student.setAddress(resultSet.getString("address"));
                student.setCity(resultSet.getString("city"));
                student.setState(resultSet.getString("state"));
                student.setCountry(resultSet.getString("country"));
                student.setContactno(resultSet.getString("contactno"));
                list.add(student);
            }
        } catch (Exception e) {System.out.println(e);}
        return list;
    }
}
