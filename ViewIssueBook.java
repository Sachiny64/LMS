/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library_management;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;


public class ViewIssueBook extends JFrame{
    String x[]={"bookid","bookno","bookname","studentid","studentname","studentcontact","date"};
    JButton bt;
    String y[][]=new String [20][7];
    int i=0,j=0;
    JTable t;
    Font f,f1;
    ViewIssueBook(){
        super("Issue Book Information");
        setLocation(1,1);
        setSize(1000,400);
        
        f=new Font("Arial",Font.BOLD,15);
        
        try{
            ConnectionClass obj=new ConnectionClass();
            String q= "Select * from issuebook";
            ResultSet rest =obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("bookid");
                y[i][j++]=rest.getString("bookno");
                y[i][j++]=rest.getString("bookname");
                y[i][j++]=rest.getString("studentid");
                y[i][j++]=rest.getString("studentname");
                y[i][j++]=rest.getString("studentcontact");
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
        new ViewIssueBook().setVisible(true);
        
    }
    
}
