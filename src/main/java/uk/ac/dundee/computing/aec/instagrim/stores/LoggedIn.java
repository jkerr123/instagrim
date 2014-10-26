/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instagrim.stores;

/**
 *
 * @author Administrator
 */
public class LoggedIn {
    boolean loggedin = false;
    String Username = null;
    String firstname = null;
    String lastname = null;
    public void LoggedIn(){
        
    }
    
    public void setUsername(String name){
        this.Username=name;
    }
    public String getUsername(){
        return Username;
    }
    
    public void setFirstname(String name)
    {
        this.firstname = name;
    }
    
    public String getFirstname()
    {
        return firstname;
    }
    
    public void setLastname(String name)
    {
        this.lastname = name;
    }
    
    public String getLastname()
    {
        return lastname;
    }
    
    public void setLoggedin(){
        loggedin=true;
    }
    public void setLoggedout(){
        loggedin=false;
    }
    
    public void setLoginState(boolean loggedin){
        this.loggedin=loggedin;
    }
    public boolean getloggedin(){
        return loggedin;
    }
}
