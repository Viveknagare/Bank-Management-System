
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    //sab kuch constructor ke andra he banana hein to globally pinnumber ko declare karne ke jarurat bhi nahi
    
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel bank=new JLabel("INDIAN BANK");
        bank.setBounds(140,20,100,20);
        add(bank);
        
        JLabel card =new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        
        add(balance);
        
        
        try{
            conn c=new conn();
           ResultSet rs= c.s.executeQuery("select*from login where pin='"+pinnumber+"'");
           while(rs.next()){
               card.setText("Card number" +rs.getString("cardnumber").substring(0,4)+"xxxxxxxx"+rs.getString("cardnumber").substring(12));
               
           }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            conn c=new conn();
            int bal=0;
            ResultSet rs=c.s.executeQuery("select*from bank where pin='"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+ "<html>" +rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br><br>");
           if(rs.getString("type").equals("Deposit")){
                        bal +=Integer.parseInt(rs.getString("amount"));//String ko integer mein convert kiya by using Integer.parseInt();
                    } else{
                        bal=Integer.parseInt(rs.getString("amount"));
                    }
            }
            
            balance.setText("your current balance is rs"+bal);//isko yaha likha upar nahi kyuki bal locally try block mein declare hein
            
            
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
        
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }
    public static void main(String args[]){
        new MiniStatement("");
    }
    
}
