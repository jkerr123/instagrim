<%-- 
    Document   : userprofile
    Created on : 22-Oct-2014, 20:30:47
    Author     : jamie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
    prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>${User.get(3)}'s Profile</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        


    </head>
    <body>
        <header>
            <h1>InstaGrim!</h1>
            <h2>Your world in Black and White</h2>
        </header>
        
        
        <p> Username: ${User.get(3)} </p>
        <p> First name: ${User.get(1)} </p>
        <p> Surname: ${User.get(0)} </p>        
        <p> Email: ${User.get(2)} </p>
        <p> <a href="/Instagrim/Images/${User.get(3)}">This User's Images</a></p>
        
        <nav>
            <ul>

               
                <li><a href="/Instagrim/upload.jsp">Upload</a></li>
                <li><a href="/Instagrim/Userlist">Profiles</a></li>
                
     <c:choose>
                <c:when test="${LoggedIn.loggedin}">                 
                <li><a href="/Instagrim/Images/${LoggedIn.username}">Your Images</a></li>
                <form method="POST"  action="Logout">                
                <input type="submit" value="Logout"> 
                </form>
                </c:when>
                
                
                
                <c:otherwise>
                <li><a href="/Instagrim/register.jsp">Register</a></li>
                <li><a href="/Instagrim/login.jsp">Login</a></li>
                </c:otherwise>
     </c:choose>
                
            </ul>
                
            

        </nav>
        <footer>
            <ul>
                <li class="footer"><a href="/Instagrim">Home</a></li>
                <li>&COPY; Andy C</li>
            </ul>
        </footer>
    </body>
</html>


           

