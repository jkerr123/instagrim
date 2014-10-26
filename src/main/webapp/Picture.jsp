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
        <title>${Picture.name}</title>
    </head>
    <body>
        
        
        <img src="/Instagrim/Image/${Picture.SUUID}" height="500" width="500"></a><br/> 
    <c:if test="${LoggedIn.getloggedin()}">
                <form method="POST"  action="Image">                                               
                    <textarea name="Comment" rows="3" cols="25"></textarea>
                    <input hidden type="text" name="picid" value="${Picture.SUUID}">
                <br/>                 
                <input type="submit" value="Comment"> 
            </form>
    <br>
    </c:if>
            <c:forEach items="${Comments}" var="comment">  
                
                <p> Username: ${comment.getUsername()}<br>
                    First Name: ${comment.getFirstName()}<br>
                Last Name: ${comment.getLastName()}<br>
                Comment: ${comment.getComment()}<br></p>             
        </c:forEach>

        
    </body>
</html>
