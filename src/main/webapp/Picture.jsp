<%-- 
    Document   : Picture
    Created on : 24-Oct-2014, 13:50:41
    Author     : jamie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
    prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <img src="/Instagrim/Image/${Picture.SUUID}" height="500" width="500"></a><br/> 
        
                <form method="POST"  action="Register">
                
                    User Name:<input type="text" name="username"><br/>                  
                    Email:<input type="text" name="email"><br/>
                    First Name:<input type="text" name="firstname"><br/>
                    Last Name:<input type="text" name="lastname"><br/> 
                    <textarea name="Comment:" rows="3" cols="25">Please Enter Your Comment Here</textarea>
                <br/>
                
                <input type="submit" value="Comment"> 
            </form>

        
    </body>
</html>
