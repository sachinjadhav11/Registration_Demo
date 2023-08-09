package com.Registration;


   
import java.io.IOException;     
import java.io.PrintWriter;     
    
import javax.servlet.ServletException;      
     
import javax.servlet.http.HttpServlet;      
import javax.servlet.http.HttpServletRequest;   
import javax.servlet.http.HttpServletResponse;


public class EditServlet1 extends HttpServlet 
{     
    protected void doGet(HttpServletRequest request, HttpServletResponse response)      
           throws ServletException, IOException
    {   
        response.setContentType("text/html");     
        PrintWriter out=response.getWriter();   
        out.println("<h1>Update Student</h1>");   
        String sid=request.getParameter("id");    
        int id1=Integer.parseInt(sid);      
            
        Student e1=stuDao.getStudentById(id1);      
            
        out.print("<form action='EditServlet2' method='post'>");    
        out.print("<table>");   
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e1.getId()+"'/></td></tr>");     
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e1.getName()+"'/></td></tr>");      
        out.print("<tr><td>email:</td><td><input type='email' name='email' value='"+e1.getEmail()+"'/></td></tr>"); 
        out.print("<tr><td>password:</td><td><input type='password' name='password' value='"+e1.getPassword()+"'/></td></tr>");      
        out.print("<tr><td>address:</td><td><input type='text' name='address' value='"+e1.getAddress()+"'/></td></tr>"); 
        out.print("<tr><td>gender:</td><td><input type='text' name='gender' value='"+e1.getGender()+"'/></td></tr>");      

        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");     
        out.print("</table>");      
        out.print("</form>");   
            
        out.close();    
    }   
}   
	
