package bank.management.system;


import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener{
   
    JLabel personalDetails,name,fname,dob,gender,email,marital,address,city,state,pincode;
    JTextField pan,aadhar;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    String formno;
    
    JComboBox religion,category,occupation,education,income;
    SignupTwo(String formno)
    {
        this.formno=formno;//yeh sign up 1 mein generate kiya tha toh yeh is class mein bhi chaiye jisse mein pehle class ka database aur is class ka database relate kar saku
        setLayout(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setSize(800,580);
        setLocation(200,10);
        getContentPane().setBackground(Color.WHITE);
        
        
        
        
        
        personalDetails = new JLabel("PAGE 1: Additional Details ");
       personalDetails.setFont(new Font("Raleway",Font.BOLD,18));
       personalDetails.setBounds(260,60,400,30);
        add(personalDetails);
        
        name = new JLabel("Religion: ");
        name.setFont(new Font("Raleway",Font.BOLD,14));
        name.setBounds(100,100,200,30);
        add(name);
        
        String valReligion[]={"Hindu","Muslim","sikh","christian","other"};//array of string to pass it in jcombobox for selecting religion by drop down
         religion=new JComboBox(valReligion);
        religion.setBounds(300,100,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
       
        
        fname = new JLabel("Category: ");
        fname.setFont(new Font("Raleway",Font.BOLD,14));
        fname.setBounds(100,140,200,30);
        add(fname);
        
         String valcategory[]={"general","OBC","sc","st","others"};
         category=new JComboBox(valcategory);//yeh drop down box ham choice class se bhi bana sakte hein
        category.setBounds(300,140,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        dob = new JLabel("Income: ");
        dob.setFont(new Font("Raleway",Font.BOLD,14));
        dob.setBounds(100,180,200,30);
        add(dob);
        
        
          String incomecategory[]={"null","<1,50,000","<2,50,000","<5,00,000","upto 10 lakhs"};
         income=new JComboBox(incomecategory);//yeh drop down box ham choice class se bhi bana sakte hein
        income.setBounds(300,180,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        
        
        gender = new JLabel("Educational ");
        gender.setFont(new Font("Raleway",Font.BOLD,14));
        gender.setBounds(100,220,200,30);
        add(gender);
        
       
        email = new JLabel("Qualification: ");
        email.setFont(new Font("Raleway",Font.BOLD,14));
        email.setBounds(100,240,200,30);
        add(email);
        
        String educationvalues[]={"non-graduate","graduation","<post-graduate","Doctarate","others"};
          education=new JComboBox(educationvalues);//yeh drop down box ham choice class se bhi bana sakte hein
        education.setBounds(300,240,400,30);
       education.setBackground(Color.WHITE);
        add(education);
        
       
        
     
        marital = new JLabel("Occupation: ");
        marital.setFont(new Font("Raleway",Font.BOLD,14));
        marital.setBounds(100,300,200,30);
        add(marital);
        
          String occupationalvalues[]={"salaried","self-employed","byisnessman","student","retired","others"};
       occupation=new JComboBox(occupationalvalues);//yeh drop down box ham choice class se bhi bana sakte hein
        occupation.setBounds(300,300,400,30);
       occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
        
       
        
        address = new JLabel("PAN number: ");
        address.setFont(new Font("Raleway",Font.BOLD,14));
        address.setBounds(100,340,100,30);
        add(address);
       
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,13));
        pan.setBounds(300,340,400,30);
        add(pan);        
        
        city = new JLabel("Aadhar number: ");
        city.setFont(new Font("Raleway",Font.BOLD,14));
        city.setBounds(100,380,200,30);
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,13));
        aadhar.setBounds(300,380,400,30);
        add(aadhar);   
        
        state = new JLabel("Senior citizen: ");
        state.setFont(new Font("Raleway",Font.BOLD,14));
        state.setBounds(100,420,200,30);
        add(state);
        
        syes=new JRadioButton("yes");
        syes.setBounds(300,420,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno=new JRadioButton("no");
        sno.setBounds(400,420,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        
        pincode = new JLabel("Existing Account: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,14));
        pincode.setBounds(100,460,200,30);
        add(pincode);
        
        eyes=new JRadioButton("yes");
        eyes.setBounds(300,460,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno=new JRadioButton("no");
        eno.setBounds(400,460,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup emaritalgroup=new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);
        
        next= new JButton("NEXT");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setForeground(Color.BLUE);
        //next.setBackground(Color.black);
        next.setBounds(620,500,80,30);
        add(next);
        next.addActionListener(this);
        setVisible(true);
    }   
    public void actionPerformed(ActionEvent ae)
    {
       
        String sreligion=(String)religion.getSelectedItem();//yeh ek object return karta hein par hame chaiye string toh string mein typecast kiya
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation= (String)occupation.getSelectedItem();
      String seniorcitizen=null;
       
        if(syes.isSelected())
           seniorcitizen= "Yes";
        else if(sno.isSelected())
          seniorcitizen ="No";
        
        String existingaccount= null;
        if(eyes.isSelected())
            existingaccount="Yes";
        else if(eno.isSelected())
            existingaccount="Yes";
        String span=pan.getText();
        String saadhar=aadhar.getText();
        
     try{
         
            conn c=new conn();  //udhar conn class mein main function nahi banaya kyuki uske object idhar dusre class mein ham use kar sake.//isme database ko call marne hein
            String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
             c.s.executeUpdate(query);//executeupdate ek dml command chalane ke liye function hein
             
             setVisible(false);
             new SignupThree(formno).setVisible(true);
                     }
         catch(Exception e){
         System.out.println(e);
     }
    }
    public static void main(String args[])
    {
        new SignupTwo("");
    }
            
}