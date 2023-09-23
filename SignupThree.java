
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SignupThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7; 
    JButton submit,cancel;
    String formno;
    
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);
        
        JLabel l1=new JLabel(" page 3: Account details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,0,400,40);
        add(l1);
        
         JLabel type=new JLabel("Account type");
        type.setFont(new Font("Raleway",Font.BOLD,18));
        type.setBounds(100,50,300,30);
        add(type);
        
        r1=new JRadioButton("saving account");
        r1.setFont(new Font("rRaleway",Font.BOLD,12));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,90,120,20);
        add(r1);
        
         r2=new JRadioButton("FD account");
        r2.setFont(new Font("rRaleway",Font.BOLD,12));
        r2.setBackground(Color.WHITE);
        r2.setBounds(100,120,120,20);
        add(r2);
        
         r3=new JRadioButton("Current account");
        r3.setFont(new Font("rRaleway",Font.BOLD,12));
        r3.setBackground(Color.WHITE);
        r3.setBounds(400,90,120,20);
        add(r3);
        
         r4=new JRadioButton("recurring account");
        r4.setFont(new Font("rRaleway",Font.BOLD,12));
        r4.setBackground(Color.WHITE);
        r4.setBounds(400,120,150,20);
        add(r4);
        
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
         groupaccount.add(r2);
          groupaccount.add(r3);
           groupaccount.add(r4);
           
           
            JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,18));
       card.setBounds(100,150,200,40);
        add(card);
        
         JLabel number=new JLabel("xxxx-xxxx-xxxx-4184");
        number.setFont(new Font("Raleway",Font.BOLD,18));
       number.setBounds(400,150,400,40);
        add(number);
        
         JLabel carddetail=new JLabel("Your 16 digit card number");
        carddetail.setFont(new Font("Raleway",Font.BOLD,10));
       carddetail.setBounds(100,170,400,40);
        add(carddetail);
        
        
          JLabel pin=new JLabel(" PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,18));
       pin.setBounds(100,200,200,40);
        add(pin);
        
         JLabel pnumber=new JLabel("xxxx");
       pnumber.setFont(new Font("Raleway",Font.BOLD,18));
       pnumber.setBounds(400,200,200,40);
        add(pnumber);
        
         JLabel pindetail=new JLabel("Your 4 digit pin");
        pindetail.setFont(new Font("Raleway",Font.BOLD,10));
       pindetail.setBounds(100,220,400,40);
        add(pindetail);
        
         JLabel services=new JLabel(" Services required");
       services.setFont(new Font("Raleway",Font.BOLD,18));
       services.setBounds(100,260,200,40);
        add(services);
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,300,200,22);
        add(c1);
        
         c2=new JCheckBox("internet banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(400,300,200,22);
        add(c2);
        
         c3=new JCheckBox("Mobile banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,350,200,22);
        add(c3);
        
         c4=new JCheckBox("Email and sms alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(400,350,300,22);
        add(c4);
        
         c5=new JCheckBox("Cheque book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,400,200,22);
        add(c5);
        
         c6=new JCheckBox("E Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(400,400,200,22);
        add(c6);
        
         c7=new JCheckBox("i hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,450,600,22);
        add(c7);
        
        submit =new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,500,100,30);
        submit.addActionListener(this);
        add(submit);
        
        
        cancel =new JButton("CANCEL");
         cancel.setBackground(Color.BLACK);
         cancel.setForeground(Color.WHITE);
         cancel.setFont(new Font("Raleway",Font.BOLD,14));
         cancel.setBounds(450,500,100,30);
         cancel.addActionListener(this);
        add( cancel);
       
        getContentPane().setBackground(Color.WHITE);
        
        
        setSize(850,650);
        setLocation(400,0);//jidhar frame ham kholna chahe
        setVisible(true);
        
    }
    
     @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType=null;
            if(r1.isSelected()){
                accountType="saving account";
            }else if(r2.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType="Current account";
            }else if(r4.isSelected()){
                accountType="recurring deposit account";
            }
            
            Random random=new Random();
            String cardnumber="" + Math.abs((random.nextLong() % 90000000L) + 1831010400000000L);
           String pinnumber="" + Math.abs((random.nextLong() %9000L) + 1000L);
            String facility="";
            if(c1.isSelected()){
                facility=facility +" Atm card";
            }else if(c2.isSelected()){
                facility=facility +" internet banking";
            }else if(c3.isSelected()){
                facility=facility +" Mobile banking";
            }else if(c4.isSelected()){
                facility=facility + " Email and sms alerts";
            }else if(c5.isSelected()){
                facility=facility + " cheque book";
            }else if(c6.isSelected()){
                facility=facility +" E-Statement";
            }
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else {
                    conn c=new conn();
                    String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                     String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null,"Card number:"+ cardnumber + "\n Pin:" +pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
   
    public static void main(String args[]){
        new SignupThree("");
    }

    
    
}
