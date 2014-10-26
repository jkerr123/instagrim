/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.aec.instagrim.servlets;

import com.datastax.driver.core.Cluster;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.dundee.computing.aec.instagrim.lib.CassandraHosts;
import uk.ac.dundee.computing.aec.instagrim.lib.Convertors;
import uk.ac.dundee.computing.aec.instagrim.models.User;

/**
 *
 * @author jamie
 */
@WebServlet(name = "UserList", urlPatterns = {"/Userlist", "/UserProfile/*"})
public class UserList extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Cluster cluster;
    private HashMap CommandsMap = new HashMap();
    
    public UserList()
    {
        CommandsMap.put("Userlist", 1);
        CommandsMap.put("UserProfile", 2);
    }
    
    
    
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String args[] = Convertors.SplitRequestPath(request);
        
        
        int command;
        try {
            command = (Integer) CommandsMap.get(args[1]);
        } catch (Exception et) {
            System.out.println("Error1");
            return;
        }
        switch (command) {
            case 1:
                getUserList(request, response);
                break;
            case 2:
                getUserProfile(request, response, args[2]);
                break;
            default:
                System.out.println("Error2");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
  
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    public void getUserProfile(HttpServletRequest request, HttpServletResponse response, String username) throws ServletException, IOException
    {
        User user = new User();
        user.setCluster(cluster);
        LinkedList<String> userprofile = user.getUserInfo(username);
        RequestDispatcher rd = request.getRequestDispatcher("/userprofile.jsp");
        request.setAttribute("User", userprofile);
        rd.forward(request, response);        
    }
    
    public void editUserProfile(HttpServletRequest request, HttpServletResponse response, String username) throws ServletException, IOException
    {
        
        
        
        
    }
    
    public void getUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User user = new User();
        user.setCluster(cluster);
        LinkedList<String> users = user.getUserList();
        RequestDispatcher rd = request.getRequestDispatcher("/profilelist.jsp");
        request.setAttribute("Users", users);
        rd.forward(request, response);               
    }
    

}
