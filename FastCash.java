
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;//date class util aur sql dono mein hein toh compiler confuse ho gaya ki usko utana kaha se hein isliye ghame date mention karna pada


public class FastCash extends JFrame implements ActionListener{
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balance,back;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 670,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
       image.setBounds(0,0,700,750); //yeh likha kyuki sirf scaling krne se photo ka pixels fat raha tha toh abb proper image ayege
        add(image);
        
        
       JLabel text=new JLabel(" select withdrawl amount");
       text.setBounds(160,250,700,35);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,14));
       image.add(text);//sirf add  karne se text frame pe add hoga image pe nahi toh ham image.add karenge
       
        deposit =new JButton("Rs-100");
       deposit.setBounds(120,352,100,18);
       deposit.addActionListener(this);
        image.add(deposit);
        
       withdrawl =new JButton("Rs-500");
      withdrawl.setBounds(260,352,130,18);
     withdrawl.addActionListener(this);
        image.add(withdrawl);
        
          fastcash =new JButton("Rs-1000");
       fastcash.setBounds(120,380,100,18);
       fastcash.addActionListener(this);
        image.add(fastcash);
        
         ministatement =new JButton("Rs-2000");
       ministatement.setBounds(260,380,130,18);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
         pinchange =new JButton("Rs-5000");
       pinchange.setBounds(120,408,100,18);
      pinchange.addActionListener(this);
        image.add(pinchange);
        
       balance =new JButton("Rs-10000");
       balance.setBounds(260,408,130,18);
       balance.addActionListener(this);
        image.add(balance);
       
         back =new JButton("Back");
       back.setBounds(200,436,80,18);
       back.addActionListener(this);//this keyword simply means i am working in this object
        image.add(back);
       
        
       setSize(700,750);
       setLocation(300,0);
       setUndecorated(true);//upar x - vaigr nhi dikhaega
       setVisible(true);
    }
    
    public static void main(String args[]){
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount=((JButton)ae.getSource()).getText().substring(3);//rs 500 to 1st 3 index ko chodke baki print hoga
//ae.getsource object return krta hein jise hame typecast krna padta hein .ae.getsource se button ka access ata hein ki uska actual mein source kya hein
             conn c=new conn();
             try{
                 ResultSet rs=c.s.executeQuery("select * from bank where pin+'"+pinnumber+"'");
                 int balance=0;
                 while(rs.next()){//jitne bhi value upar se nikalke aye hein unko hame loop krna padega.aur rs.next()ek ek row ko loop karne mein madat krta hein
                    if(rs.getString("type").equals("Deposit")){
                        balance +=Integer.parseInt(rs.getString("amount"));//String ko integer mein convert kiya by using Integer.parseInt();
                    } else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                 }
                 
                 if(ae.getSource()!=back && balance<Integer.parseInt(amount)){
                     JOptionPane.showMessageDialog(null,"Insufficient balance");
                     return;
                 }
                 
                 Date date=new Date();
                 String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"RS"+amount+"debited successfully" );
                 
                 setVisible(false);
                 new Transactions(pinnumber).setVisible(true);
             }catch(Exception e){
                 System.out.println(e);
             }
        }
    }
}
