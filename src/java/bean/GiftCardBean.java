/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bean.*;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author nikolaj
 */
@Stateless
public class GiftCardBean {
        Connection con;
        Statement stmt;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //In the real world, this method should have madtoe a call to database objects to query data
   
    public void init(){
         try {    
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost/mygift?autoReconnect=true&useSSL=false", "root", "root");
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }
    public float getAccountValueStatement(String email){
                   float accountValue = 0;

        try{
           this.stmt = con.createStatement();
           ResultSet resultSet = stmt.executeQuery("SELECT moneyOnAccount FROM giftTaker WHERE email='"+email+"'");
           while(resultSet.next()){
               accountValue = resultSet.getFloat(1);
           }
                       stmt.close();

        } catch (SQLException ex) {
        }
        return accountValue;
    }
    
    
     public boolean getAccountStatement(String email, String eventCost) throws SQLException{
  

float amount = 0;
        try{
           this.stmt = con.createStatement();
           ResultSet resultSet = stmt.executeQuery("SELECT moneyOnAccount from giftTaker where email='"+email+"';");
           

         while (resultSet.next()){
              if(resultSet != null){
           amount = resultSet.getFloat(1);
           
                  }
       
         }

      }catch (SQLException ex) { 
         System.err.println(new java.util.Date()+" : "+ex.getMessage()); 
                   
      }
        if(amount>=Float.valueOf(eventCost)){
                                stmt.close();

            return true; 
        }
                    stmt.close();
        
        return false;
    }
     
         public void withdrawFromUserStatement(String email, String amount){
        try{
            //Creates new customer account
            PreparedStatement prestmt = (PreparedStatement) con.prepareStatement("UPDATE giftTaker SET moneyOnAccount=moneyOnAccount-? WHERE email=?;");
            prestmt.setFloat(1, Float.valueOf(amount));
            prestmt.setString(2, email);
            prestmt.executeUpdate();
            prestmt.close();
    
        } catch (SQLException ex) {
        }
    }
    
    public void closeConnection(){
        try {
            con.close();
        } catch (SQLException ex) {
        }
    }
}
