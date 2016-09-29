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
import com.mysql.cj.jdbc.PreparedStatement;


public class RET_OWN extends HttpServlet {
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 String s=request.getParameter("item");
		 Connection con=null;
		 ResultSet rs=null;
		 PrintWriter pw=response.getWriter();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic","root", "1234");
			} catch (Exception e) {
				
				System.out.println(e);
			}
			try {
				PreparedStatement st =  (PreparedStatement) con.prepareStatement("select *  from owners where first_name=(?)");
				 
				 
				 st.setString(1, s);
					rs=st.executeQuery();
				
				
				response.setContentType("text/html");
				
				 
				while(rs.next())
				{
					
					
			  pw.println("<tr><td>"+rs.getInt(1)+"</td>&nbsp");
			  pw.println("&nbsp<td>"+rs.getString(2)+"</td>");
			  pw.println("&nbsp<td>"+rs.getString(3)+"</td>");
			  pw.println("&nbsp<td>"+rs.getString(4)+"</td>");
			  pw.println("&nbsp<td>"+rs.getString(5)+"</td>");
			  pw.println("&nbsp<td>"+rs.getString(6)+"</td></tr>");
			  
			pw.println("</table></center>");
				
				}
	         }
			catch(Exception e)
			{
			pw.println("no data");
			}
	}
}
	
