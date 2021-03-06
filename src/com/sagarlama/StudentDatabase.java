package com.sagarlama;

import jdk.nashorn.internal.runtime.ECMAException;

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
                student.setGrade(resultSet.getInt("grade"));
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
            PreparedStatement statement=con.prepareStatement("insert into student(name,email,grade,fee,paid,due,address,city,state,country,contactno) values(?,?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1,student.getName());
            statement.setString(2,student.getEmail());
            statement.setInt(3, student.getGrade());
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

    public static List<Student> due(){
        List<Student> list = new ArrayList<Student>();
        try{
            Connection connection = AccountDatabase.getCon();
            PreparedStatement statement = connection.prepareStatement("select * from student where due>0");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Student student = new Student();
                student.setRollno(resultSet.getInt("rollno"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setGrade(resultSet.getInt("grade"));
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
            connection.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }

    public static int update(Student student){
        int status = 0;
        try {
            Connection connection = AccountDatabase.getCon();
            PreparedStatement statement=connection.prepareStatement("update student set name=?,email=?,grade=?,fee=?,paid=?,due=?,address=?,city=?,state=?,country=?,contactno=? where rollno=?");
            statement.setString(1,student.getName());
            statement.setString(2,student.getEmail());
            statement.setInt(3,student.getGrade());
            statement.setInt(4,student.getFee());
            statement.setInt(5,student.getPaid());
            statement.setInt(6,student.getDue());
            statement.setString(7,student.getAddress());
            statement.setString(8,student.getCity());
            statement.setString(9,student.getState());
            statement.setString(10,student.getCountry());
            statement.setString(11,student.getContactno());
            statement.setInt(12,student.getRollno());
            status=statement.executeUpdate();
            connection.close();
        } catch (Exception e){
            System.out.println(e);
        }
        return status;
    }

    public static int deleteStudent(Student student){
        int status = 0;
        try {
            Connection connection = AccountDatabase.getCon();
            PreparedStatement statement=connection.prepareStatement("delete from student where rollno = ?");
            statement.setInt(1,student.getRollno());
            status=statement.executeUpdate();
            connection.close();
        } catch (Exception e){
            System.out.println(e);
        }
        return status;
    }

    public static Student getStudentByRollNo(int rollno){
        Student student = new Student();
        try {
            Connection connection=AccountDatabase.getCon();
            PreparedStatement statement=connection.prepareStatement("select * from student where rollno=?");
            statement.setInt(1,rollno);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                student.setRollno(resultSet.getInt("rollno"));
                student.setName(resultSet.getString("name"));
                student.setRollno(resultSet.getInt("rollno"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setGrade(resultSet.getInt("Grade"));
                student.setFee(resultSet.getInt("fee"));
                student.setPaid(resultSet.getInt("paid"));
                student.setDue(resultSet.getInt("due"));
                student.setAddress(resultSet.getString("address"));
                student.setCity(resultSet.getString("city"));
                student.setState(resultSet.getString("state"));
                student.setCountry(resultSet.getString("country"));
                student.setContactno(resultSet.getString("contactno"));
            }
            connection.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return student;
    }

}
