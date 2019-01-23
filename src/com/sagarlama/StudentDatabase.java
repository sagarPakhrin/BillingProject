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
    public static int save(Student student){
        int status=0;
        try{
            Connection con=AccountDatabase.getCon();
            PreparedStatement statement=con.prepareStatement("insert into student(name,email,course,fee,paid,due,address,city,state,country,contactno) values(?,?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1,student.getName());
            statement.setString(2,student.getEmail());
            statement.setString(3, student.getCourse());
            statement.setInt(4,student.getFee());
            statement.setInt(5,student.getPaid());
            statement.setInt(6,student.getDue());
            statement.setString(7,student.getAddress());
            statement.setString(8,student.getCity());
            statement.setString(9,student.getState());
            statement.setString(10,student.getCountry());
            statement.setString(11,student.getContactno());
            status=statement.executeUpdate();
            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;
    }

}
