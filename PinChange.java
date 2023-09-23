
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    
    JPasswordField repin,pin;
    JButton change,back;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 650, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,650);
        add(image);
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(190,210,500,30);
        image.add(text);
        
        
        JLabel pintext=new JLabel("new pin:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(120,250,100,30);
        image.add(pintext);
        
        pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(270,250,100,20);
        image.add(pin);
        
        
        
           
        JLabel repintext=new JLabel("re- enter pin:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(120,280,200,30);
        image.add(repintext);
        
           repin=new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(270,280,100,20);
        image.add(repin);
        
        
       back=new JButton("Back");
        back.setBounds(260,360,120,20);
        back.addActionListener(this);
        image.add(back);
        
        change=new JButton("CHANGE");
        change.setBounds(260,330,120,20);
        change.addActionListener(this);
        image.add(change);
        
        
        setSize(700,650);
        setLocation(300,0);
        setVisible(true);
        
    }
    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
     if(ae.getSource()==change){
        try{
            String npin=pin.getText();
            String rpin=repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered pin doesnt match");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"please enter new pin");
                return;
            }
            
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"please re-enter new pin");
                return;
            }
            
            conn c=new conn();
            String query1="update bank set pin= '"+rpin+"'where pin='"+pinnumber+"'";
            String query2="update login set pin= '"+rpin+"'where pin='"+pinnumber+"'";
            String query3="update signupthree set pin= '"+rpin+"'where pin='"+pinnumber+"'";
            
            c.s.executeUpdate(query1);
             c.s.executeUpdate(query2);
              c.s.executeUpdate(query3);
            
              JOptionPane.showMessageDialog(null,"Pin changed succesfully");
              
              setVisible(false);
              new Transactions(rpin).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
        
      
     }else{
         setVisible(false);
         new Transactions(pinnumber).setVisible(true);
     }
    
    }
}
