
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener{
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balance,exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 670,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
       image.setBounds(0,0,700,750); //yeh likha kyuki sirf scaling krne se photo ka pixels fat raha tha toh abb proper image ayege
        add(image);
        
        
       JLabel text=new JLabel("please select your Transaction");
       text.setBounds(160,250,700,35);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,14));
       image.add(text);//sirf add  karne se text frame pe add hoga image pe nahi toh ham image.add karenge
       
        deposit =new JButton("Deposit");
       deposit.setBounds(120,352,100,18);
       deposit.addActionListener(this);
        image.add(deposit);
        
       withdrawl =new JButton("Cash Withdrawl");
      withdrawl.setBounds(260,352,130,18);
     withdrawl.addActionListener(this);
        image.add(withdrawl);
        
          fastcash =new JButton("Fast cash");
       fastcash.setBounds(120,380,100,18);
       fastcash.addActionListener(this);
        image.add(fastcash);
        
         ministatement =new JButton("Mini statement");
       ministatement.setBounds(260,380,130,18);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
         pinchange =new JButton("pin Change");
       pinchange.setBounds(120,408,100,18);
      pinchange.addActionListener(this);
        image.add(pinchange);
        
       balance =new JButton("Balance enquiry");
       balance.setBounds(260,408,130,18);
       balance.addActionListener(this);
        image.add(balance);
       
         exit =new JButton("EXIT");
       exit.setBounds(200,436,80,18);
       exit.addActionListener(this);//this keyword simply means i am working in this object
        image.add(exit);
       
        
       setSize(700,750);
       setLocation(300,0);
       setUndecorated(true);//upar x - vaigr nhi dikhaega
       setVisible(true);
    }
    
    public static void main(String args[]){
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exit){
            System.exit(0);//band hoo jayega
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==ministatement){
            
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
}
