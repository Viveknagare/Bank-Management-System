
package bank.management.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;



public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,700 , Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        back=new JButton("Back");
        back.setBounds(260,360,120,30);
        back.addActionListener(this);
        image.add(back);
        
        conn c=new conn();
        int balance=0;
             try{
                 ResultSet rs=c.s.executeQuery("select * from bank where pin+'"+pinnumber+"'");
                
                 while(rs.next()){//jitne bhi value upar se nikalke aye hein unko hame loop krna padega.aur rs.next()ek ek row ko loop karne mein madat krta hein
                    if(rs.getString("type").equals("Deposit")){
                        balance +=Integer.parseInt(rs.getString("amount"));//String ko integer mein convert kiya by using Integer.parseInt();
                    } else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                 }
             }catch(Exception e){
                 System.out.println(e);
             }
             
             JLabel text=new JLabel("your current account balance is Rs"+balance);
             text.setForeground(Color.WHITE);
             text.setBounds(120,250,400,40);
             image.add(text);
                 
                 
        
        setSize(700,650);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       setVisible(false);
       new Transactions(pinnumber).setVisible(true);
    }
    
}
