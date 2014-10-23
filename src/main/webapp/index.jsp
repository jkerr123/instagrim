<%-- 
    Document   : index
    Created on : Sep 28, 2014, 7:01:44 PM
    Author     : Administrator
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
    prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>Instagrim</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        


    </head>
    <body>
        <header>
            <h1>InstaGrim ! </h1>
            <h2>Your world in Black and White</h2>
        </header>
        
        <p>${message}</p>
        
        <nav>
            <ul>

               
                <li><a href="upload.jsp">Upload</a></li>
                <li><a href="/Instagrim/Userlist">Profiles</a></li>
                
     <c:choose>
                <c:when test="${LoggedIn.loggedin}">                 
                <li><a href="/Instagrim/Images/${LoggedIn.username}">Your Images</a></li>
                <form method="POST"  action="Logout">                
                <input type="submit" value="Logout"> 
                </form>
                </c:when>
                
                
                
                <c:otherwise>
                <li><a href="register.jsp">Register</a></li>
                <li><a href="login.jsp">Login</a></li>
                </c:otherwise>
     </c:choose>
                
            </ul>
                
            

        </nav>
        <footer>
            <ul>
                <li class="footer"><a href="/Instagrim">Home</a></li>
                <li>&COPY; Jamie Kerr</li>
            </ul>
        </footer>
    </body>
</html>
