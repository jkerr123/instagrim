<%-- 
    Document   : UsersPics
    Created on : Sep 24, 2014, 2:52:48 PM
    Author     : Jamie
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
    prefix="c" %> 
<%@page import="com.datastax.driver.core.Row"%>
<%@page import="com.datastax.driver.core.BoundStatement"%>
<%@page import="com.datastax.driver.core.ResultSet"%>
<%@page import="com.datastax.driver.core.PreparedStatement"%>
<%@page import="com.datastax.driver.core.Session"%>
<%@page import="com.datastax.driver.core.Cluster"%>
<%@page import="uk.ac.dundee.computing.aec.instagrim.models.User"%>
<%@page import="java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>
<%@ page import="uk.ac.dundee.computing.aec.instagrim.lib.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instagrim</title>
        <link rel="stylesheet" type="text/css" href="/Instagrim/Styles.css" />
    </head>
    <body>
        <header>
        

        
        <h2>Your world in Black and White</h2>
        </header>
        
        
        <c:forEach items="${Users}" var="name">    
            <a href="/Instagrim/Images/${name}">${name}</a><br>     
        </c:forEach>
             

      
        <footer>
            <ul>
                <li class="footer"><a href="/Instagrim">Home</a></li>
            </ul>
        </footer>
    </body>
</html>

