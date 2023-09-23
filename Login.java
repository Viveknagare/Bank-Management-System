package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener  {
    
   JButton login,signup,clear;
   JTextField cardTextField;
   JPasswordField pinTextField;
    Login(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("AUTOMATED TELLER MACHINE");
       
        
        setLayout(null);//due to which we can make our custom layouts by using boundsfunction
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        //Image class hoti hein awt package ke andar
        //imageicon ko jlabel mein daal sakte hein par image ko nahi
        //isliye hamne i2 ko wapis i3 mein dala jo image icon ka object hein
        JLabel label=new JLabel(i3);
        //i2 pass kiya toh pehle wala bada image ayega
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text=new JLabel("welcome to ATM");
       text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
                //layout null kiya toh jab tak aap iske bounds nhi set krte tab tak yeh screen pe dekhega nhi
        add(text);
        
        JLabel cardno=new JLabel("Card no.");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,40);
        add(cardno);
        
         cardTextField=new JTextField();
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin=new JLabel("PIN:");
       pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
       
         pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
         login =new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear =new JButton("CLEAR");//JButton uparrr globally declare kiya hein isliye yaha firse nahi likha
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup =new JButton("SIGN UP");
        signup.setBounds(300,350,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(300,100);
    }
    
    @Override
   public void actionPerformed(ActionEvent ae){//actionevent class batate hein ki apne konsa action perform kiya aur ae action event class ka object hein
       // whwnever we implement interface like noe we have implemented interface
    //which has some abstract methods so we need to override the method wherever
    //we have implemented the interface like now we are writing comments in a overriden method...
    //getsource jo button click kiya uska kya source hein
    if(ae.getSource()==clear){
        
      cardTextField.setText("");
      pinTextField.setText("");
      
    }else if(ae.getSource()==login){
        conn c=new conn();
        String cardnumber=cardTextField.getText();
        String pinnumber=pinTextField.getText();//yeh symbol batat hein ki woh passwordfield hein ap gettext se nh nikal sakte prr chal jayega ham karenge
        String query="select *from login where cardnumber='"+cardnumber+"' and pin='"+pinnumber+"'";
        try{
            ResultSet rs=c.s.executeQuery(query);//yeh resutset ko return krta hein, jo return hota hein uska datatype he result set hota hein.aur yeh class hote hein sql package ke anndar
            if(rs.next()){//next( check krege ki kuch data aya ki nhi query execute hone ke baad agar aya toh next window transaction pee jayega
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Incorrect card number or pin");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }else if(ae.getSource()==signup){
        setVisible(false);
        new SignupOne().setVisible(true);//signupOne page ka object banaya toh uska constructor call hoga aur setvisible se frame dekhege
    }
    
  }
    
    public static void main(String args[]){
       new Login();
    }
    
}
