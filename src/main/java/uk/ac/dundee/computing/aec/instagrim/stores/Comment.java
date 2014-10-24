/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.aec.instagrim.stores;

/**
 *
 * @author jamie
 */
public class Comment {
    
    private java.util.UUID commentID = null;
    private java.util.UUID pictureID = null;
    private String stringCommentID = null;
    private String stringPictureID = null;
    
    private String firstname = null;
    private String lastname = null;
    private String username = null;
    
    private String comment = null;

    
      
    
   public void setCommentID(java.util.UUID UUID)
   {
       commentID = UUID;       
   }
   
   public void setStringCommentID()
   {
       stringCommentID = commentID.toString();       
   }
    
   public void setPictureID(java.util.UUID UUID)
   {
       pictureID = UUID;
   }
   
   public void setStringPictureID()
   {
       stringPictureID = pictureID.toString();
   }
   
   public void setFirstName(String name)
   {
       firstname = name;
   }
   
   public String getFirstName()
   {
       return firstname;
   }
   
   public void setLastName(String name)
   {
       lastname = name;
   }
   
   public String getLastName()
   {
       return lastname;
   }
   
   public void setUsername(String username)
   {
       this.username = username;       
   }
   
   public String getUsername()
   {       
       return username;
   }
   
   public void setComment(String comment)
   {
       this.comment = comment;
   }
   
   public String getComment()
   {
       return comment;
   }

}
