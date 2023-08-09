package com.Registration;

  
import java.io.IOException;     
import java.io.PrintWriter;     

import javax.servlet.ServletException;      
    
import javax.servlet.http.HttpServlet;      
import javax.servlet.http.HttpServletRequest;   
import javax.servlet.http.HttpServletResponse;
    
public class EditServlet2 extends HttpServlet
{     
    public void doPost(HttpServletRequest request, HttpServletResponse response)     
      throws ServletException, IOException
    {    
    response.setContentType("text/html");   
    PrintWriter out=response.getWriter();   
        
    String id1=request.getParameter("id"); 
    int id=Integer.parseInt(id1);
    String name=request.getParameter("name");      
    String email=request.getParameter("email");    
    String password=request.getParameter("password");      
    String address=request.getParameter("address"); 
    String gender=request.getParameter("gender");
        
    Student e1=new Student();   
    e1.setId(id); 
    e1.setName(name);
    e1.setEmail(email);
    e1.setPassword(password);
    e1.setAddress(address);
    e1.setGender(gender);
    
        
        
    int status=stuDao.update(e1);   
    if(status>0)
    {   
        response.sendRedirect("ViewServlet");   
    }else
    {      
        out.println("something went Wrong");      
    }   
        
    out.close();    
  }   

}  

