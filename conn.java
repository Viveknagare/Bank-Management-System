
package bank.management.system;

import java.sql.*;

public class conn {
    
    Connection c;//connection class ka globally c object banaya 
    Statement s;
    
    public conn(){
        try{//try catch lagayge kyuki msql external entity hein error ane ke chances bohot jyada hein
            /*steps in jdbc
            step1:register the driver
            step2:create connection
            step3:create statement
            step4:execute query
            Step5:close connection
            //my sql connector ke andar driver hota hein
            */
           // Class.forName(com.mysql.cj.jdbc.Driver);// step1:class Class mein static method hoti hein forName jisme ham apne driver ka naam pass karte hein.yeh step mein hamne driver ko load kiya.java khudse class path se driver ko register kar deta hein
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","Vivek@1831");//connection class ka object banaya aur usko value diya DM class se Getconnection method call kiya aur url as a string pass kiya by default mysql local host pe chalta hein toh local host aur 3306 nahi likha tabhi chalega                                                 //step 2:create connection
            s=c.createStatement();//connection ke help se create statement ko call kiya
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
}
