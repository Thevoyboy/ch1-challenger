
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.api.jdbc.Statement;


public class own_serv extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ResultSet rs=null;
		String fname[]=new String[100];
		Connection con=null;
		String opt="";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic", "root", "1234");
		} catch (Exception e) {
			
			System.out.println(e);
		}
		try {
			Statement st =  (Statement) con.createStatement();
			 rs = st.executeQuery("select first_name from owners");
			 
			 
			int i=0;
			
			
			while(rs.next())
			{
				
				
				
		 fname[i] = rs.getString("first_name");
		i++;
			
			}
			

			

		} catch (Exception e) {
			
			System.out.println(e);
		}
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		
		
		for(int i=0;i<fname.length;i++)
		{
			if(fname[i]==null)
			{
				break;
			}
		opt=opt+"<option value = " +  fname[i]+	 ">" +fname[i]+"</option>";
	}

	
	pw.println("<form action='RET_OWN' method='get'><select id='item' name='item'>"+opt+"</select><input type='submit' value='Submit'></form>");
		 
	pw.println("id:<input type='text'>"+"<input type='submit' value='submit'>");
	}
	
	
}

