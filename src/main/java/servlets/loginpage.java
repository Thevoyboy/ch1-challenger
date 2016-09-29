package servlets;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.api.pipe.NextAction;
 
public class loginpage extends HttpServlet  
{
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
 
		String user=req.getParameter("userName");
		String pass=req.getParameter("userPassword");
 
		if(user.equals("harsha")&&pass.equals("1234")){
                 pw.println("<form action='own_serv' method='get'><select id='item' name='item'>"+"</select><input type='submit' value='Submit'></form>");
		}
                else{
                 pw.println("Login Failed...!");
		 pw.close();
		}
	}
 
}