package com.Registration;


   
import java.util.*;     
import java.sql.*;      
    
public class stuDao {   
    
    public static Connection getConnection()
    {   
    	Connection con=null;
  	  
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Register_db1", "root", "root");
	
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	   return con;
    }   
    
    public static int save(Student e1)
    {     
        int cnt=0;  
        
        try{    
            Connection con=stuDao.getConnection();     
            PreparedStatement ps=con.prepareStatement(    
                         "insert into register_db1.student(id,name,email,password,address,gender) values (?,?,?,?,?,?)");    
            
            ps.setInt(1, e1.getId());
            ps.setString(2,e1.getName());     
            ps.setString(3,e1.getEmail());      
            ps.setString(4,e1.getPassword());   
            ps.setString(5,e1.getAddress()); 
            ps.setString(6, e1.getGender());
                
            cnt=ps.executeUpdate();     
                
            con.close();   
        }   
        catch(Exception ex1)    
        {   
            ex1.printStackTrace();  
        }   
            
        return cnt;      
    }   
    public static int update(Student e1)
    {      
        int cnt=0;   
        try
        {    
            Connection con=stuDao.getConnection();     
            PreparedStatement ps=con.prepareStatement(    
                         "update register_db1.student set id=?, name=?,email=?,password=?,address=?,gender=? where id=?"); 
            
            ps.setInt(1, e1.getId());
            ps.setString(2,e1.getName());     
            ps.setString(3,e1.getEmail());      
            ps.setString(4,e1.getPassword());   
            ps.setString(5,e1.getAddress()); 
            ps.setString(6, e1.getGender());
            ps.setInt(7, e1.getId());
                
                
            cnt=ps.executeUpdate();     
                
            con.close();   
        }   
        catch(Exception ex1)    
        {
        	ex1.printStackTrace();
        	
        }    
            
        return cnt;      
    }   
    public static int delete(int id)
    {     
        int cnt=0;   
        try{    
            Connection con=stuDao.getConnection();     
            PreparedStatement ps1=con.prepareStatement("delete from register_db1.student where id=?");      
            ps1.setInt(1,id);      
            cnt=ps1.executeUpdate();     
                
            con.close();   
            
        }catch(Exception e1)
        {
        	e1.printStackTrace();
        	
        }     
            
        return cnt;      
    }   
    public static Student getStudentById(int id)
    {      
        Student e1=new Student();   
            
        try{    
            Connection con=stuDao.getConnection();     
            PreparedStatement ps1=con.prepareStatement("select * from register_db1.student where id=?");    
            ps1.setInt(1,id);      
            ResultSet rs=ps1.executeQuery();   
            if(rs.next()){     
                e1.setId(rs.getInt(1));    
                e1.setName(rs.getString(2));      
                e1.setEmail(rs.getString(3));
                e1.setPassword(rs.getString(4));
                e1.setAddress(rs.getString(5));
                e1.setGender(rs.getString(6));
            }   
            con.close();   
        }catch(Exception ex1)
        {
        	ex1.printStackTrace();
        	
        }   
            
        return e1;      
    }   
    public static List<Student> getAllStudent()
    {    
        List<Student> list=new ArrayList<Student>();    
            
        try{    
            Connection con=stuDao.getConnection();     
            PreparedStatement ps=con.prepareStatement("select * from register_db1.student");   
            ResultSet rs=ps.executeQuery(); 
            
            while(rs.next())
            {      
                Student e1=new Student(); 
                
                e1.setId(rs.getInt(1));    
                e1.setName(rs.getString(2));      
                e1.setEmail(rs.getString(3));
                e1.setPassword(rs.getString(4));
                e1.setAddress(rs.getString(5));
                e1.setGender(rs.getString(6));
                list.add(e1);   
            }   
            
            con.close();  
            
        }catch(Exception e1)
        {
        	e1.printStackTrace();
        }     
            
        return list;    
    }   
} 
	
