/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instagrim.models;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import uk.ac.dundee.computing.aec.instagrim.lib.AeSimpleSHA1;
import uk.ac.dundee.computing.aec.instagrim.stores.Pic;

/**
 *
 * @author Administrator
 */
public class User {
    Cluster cluster;
    public User(){
        
    }
    
    public boolean RegisterUser(String username, String password, String email, String firstname, String lastname){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        
        if(checkUserExists(username))
        {      
            System.out.println("User exists");
        }
        else
        {
                Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("insert into userprofiles (login, email, firstname, lastname, password) Values(?,?,?,?,?)");
       
        BoundStatement boundStatement = new BoundStatement(ps);
        session.execute(boundStatement.bind(username, email, firstname, lastname, EncodedPassword));  
       
        
       return true;
       }
       
       return false;
    }
    
    public boolean checkUserExists(String username)
    {
        
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select login from userprofiles where login =?");
        
                BoundStatement boundStatement = new BoundStatement(ps);
         ResultSet results = null;
                results = session.execute(boundStatement.bind(username));
        
        if (results.one() != null)
        {
            return true;
        } 

        return false;
    }
    
    public boolean isValidUser(String username, String Password){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select password from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username));
        if (rs.isExhausted()) {
            System.out.println("No Images returned");
            return false;
        } else {
            for (Row row : rs) {
               
                String StoredPass = row.getString("password");
                if (StoredPass.compareTo(EncodedPassword) == 0)
                    return true;
            }
        }
   
    
    return false;  
    }
    
    public LinkedList<String> getUserInfo(String username)
    {
        
        LinkedList<String> userinfo = new LinkedList<>();        
        
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select * from userprofiles where login =?;");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute(boundStatement.bind( 
               username ));
        if (rs.isExhausted()) {
            
            return null;
        } else {
            for (Row row : rs) {                
                String user = row.getString("login");
                String email = row.getString("email");
                String firstname = row.getString("firstname");
                String lastname = row.getString("lastname");
                userinfo.push(user);
                userinfo.push(email);
                userinfo.push(firstname);
                userinfo.push(lastname);
            }
        }
        return userinfo;       
        
    }
    
    public LinkedList<String> getUserList()
    {
        
        LinkedList<String> users = new LinkedList<>();
        
        
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select * from userprofiles;");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
      rs = session.execute(boundStatement.bind( 
                ));
        if (rs.isExhausted()) {
            
            return null;
        } else {
            for (Row row : rs) {                
                String name = row.getString("login");                
                users.push(name);
            }
        }
        return users;
    }
    
    public boolean modifyProfile(String username, String firstname, String lastname, String email)
    {
        
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("update userprofiles set firstname =?, lastname =?, email =? where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        boundStatement.bind(firstname, lastname, email, username);
        
        return true;
        
    }
    
       public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    
}