/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library_management;

/**
 *
 * @author hp
 */

    
    
import java.sql.*;
public class ConnectionClass {
    Connection con;
    Statement stm;
    ConnectionClass(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Sachin","root","");
            stm=con.createStatement();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new ConnectionClass();
    }
}
