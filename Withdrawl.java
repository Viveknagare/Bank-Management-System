
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JButton withdraw,back;
    JTextField amount;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 650, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,820,650);
        add(image);
        
        JLabel text=new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        text.setBounds(190,210,380,20);
        image.add(text);
        
       amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,18));
        amount.setBounds(200,250,250,22);
        image.add(amount);
        
      withdraw=new JButton("Withdraw");
        withdraw.setBounds(360,340,100,25);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back=new JButton("Back");
        back.setBounds(360,370,100,25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(700,650);
        setLocation(300,0);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new Withdrawl("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==withdraw){
           String number=amount.getText();
           Date date=new Date();
           if(number.equals("")){
               JOptionPane.showMessageDialog(null,"please enter the amount you want to withdraw");
           }else{
               try{
                  conn c=new conn();
                  String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+number+"')";
                  c.s.executeUpdate(query);
                  JOptionPane.showMessageDialog(null, "Rs" +number+"withdraw successfully");
                  setVisible(false);
                  new Transactions(pinnumber).setVisible(true);
               }catch(Exception e){
                   System.out.println(e);
               }
           } 
           
       }else if(ae.getSource()==back){
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
       }
    }
    
}
