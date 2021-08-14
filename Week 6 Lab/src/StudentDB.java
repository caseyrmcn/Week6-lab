import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author casey
 */
public class StudentDB {
    //constants
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String CONNECTION_STRING = "jdbc:mysql://127.0.0.1:3306/cis255a";
    private final String USER_NAME = "root";
    private final String PASSWORD = "Reddog93";
    
    //behaviors
    //save a student object to the database
    public void add(Student stu ) throws ClassNotFoundException, SQLException {
        //ALWAYS use prepared statement  to write databases when we get input from users
        //to help prevent hacking
        //https://sqlzoo.net/hack
        //check for the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //conn to the DB
        Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME,  PASSWORD);
     
        //write student to db
        String sqlStr = "INESRT INTO students (StudentName, Test1, Test2, Test3) VALUES (?, ?, ?, ?,)";
        PreparedStatement pstmt = conn.prepareStatement(sqlStr);
        pstmt.setString(1, stu.getName());
       // pstmt.setDouble(2, stu.getTest1());
        //pstmt.setDouble(3, stu.getTest2());
        //pstmt.setDouble(4, stu.getTest3());
        
        pstmt.execute();
        
        //close the connection
        conn.close();
        
    }
    
}
