<%-- 
    Document   : error-404
    Created on : 26-Oct-2014, 21:46:53
    Author     : jamie
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
        
        <p>Sorry, the page you have requested does not exist.</p>
        
        <nav>
            <ul>

                <li><a href="upload.jsp">Upload</a></li>
                <li><a href="/Instagrim/Userlist">User Profiles</a></li>
                
     <c:choose>
                <c:when test="${LoggedIn.loggedin}">                 
                <li><a href="/Instagrim/Images/${LoggedIn.username}">Your Images</a></li>
                <li><a href="/Instagrim/Logout">Logout</a></li> 
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
