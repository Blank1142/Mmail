

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Account
 */
public class Account extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name=request.getParameter("Name");
		String name="";
		for(int i=Name.length()-1;i>=0;i--)
		{
			int m=Name.charAt(i)+1;
			name +=(char)m;
		}
		String Email=request.getParameter("Email");
		String email="";
		for(int i=Email.length()-1;i>=0;i--)
		{
			int m=Email.charAt(i)+1;
			email +=(char)m;
		}
		String Mobile=request.getParameter("Mobile");
		String mobile="";
		for(int i=Mobile.length()-1;i>=0;i--)
		{
			int m=Mobile.charAt(i)+1;
			mobile +=(char)m;
		}
		String Password=request.getParameter("Password");
		String password="";
		for(int i=Password.length()-1;i>=0;i--)
		{
			int m=Password.charAt(i)+1;
			password +=(char)m;
		}
		Model m=new Model();
		m.setName(name);
		m.setEmail(email);
		m.setMobile(mobile);
		m.setPassword(password);
		int s=m.register();
		if(s==1)
		{
			((HttpServletResponse) response).sendRedirect("/Gmail/Success.html");
		}
		else
		{
			((HttpServletResponse) response).sendRedirect("/Gmail/Wrong.html");
		}
	}
}
