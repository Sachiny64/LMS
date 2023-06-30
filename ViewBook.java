/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library_management;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;


public class ViewBook extends JFrame{
    String x[]={"Id","BookNo","Bookname","author","publisher","quantity","Issued","date"};
    JButton bt;
    String y[][]=new String [20][8];
    int i=0,j=0;
    JTable t;
    Font f,f1;
    ViewBook(){
        
    
    super("Book Information");
        setLocation(1,1);
        setSize(1000,400);
        
        f=new Font("Arial",Font.BOLD,15);
        
        try{
            ConnectionClass obj=new ConnectionClass();
            String q= "Select * from addbook";
            ResultSet rest =obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("Id");
                y[i][j++]=rest.getString("BookNo");
                y[i][j++]=rest.getString("Bookname");
                y[i][j++]=rest.getString("author");
                y[i][j++]=rest.getString("publisher");
                y[i][j++]=rest.getString("quantity");
                y[i][j++]=rest.getString("issuebook");
                y[i][j++]=rest.getString("date");
                i++;
                j=0;
                
            }
            t=new JTable(y,x);
            t.setFont(f);
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        //scroll bar
       JScrollPane sp=new JScrollPane(t);
       add(sp);
        
    }
    public static void main(String args[]){
        new ViewBook().setVisible(true);
        
    }
    
}
