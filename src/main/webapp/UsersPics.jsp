<%-- 
    Document   : UsersPics
    Created on : Sep 24, 2014, 2:52:48 PM
    Author     : Administrator
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
    prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${User}'s Pics</title>
        <link rel="stylesheet" type="text/css" href="/Instagrim/Styles.css" />
    </head>
    <body>
        <header>
        
        <h1>InstaGrim!</h1>
        <h2>Your world in Black and White</h2>
        </header>
        
        <nav>
            <ul>
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
 
        <article>
            <h1>${User}'s Pics</h1>

        
        <c:forEach items="${Pics}" var="pic">                
            <c:choose>                
            <c:when test="${not empty pic.SUUID}">
            <a href="/Instagrim/Picture/${pic.SUUID}" ><img src="/Instagrim/Thumb/${pic.SUUID}"></a><br/> 
            </c:when>
            <c:otherwise> No Pictures Found </c:otherwise>
            </c:choose>
        </c:forEach>
        </article>
        
        <footer>
            
            <ul>
                <li class="footer"><a href="/Instagrim">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
