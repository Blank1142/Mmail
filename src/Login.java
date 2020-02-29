

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email=request.getParameter("Email");
		String email="";
		for(int i=Email.length()-1;i>=0;i--)
		{
			int m=Email.charAt(i)+1;
			email +=(char)m
					;}
		String Password=request.getParameter("Password");
		String password="";
		for(int i=Password.length()-1;i>=0;i--)
		{
			int m=Password.charAt(i)+1;
			password +=(char)m
					;}
		Model m=new Model();
		m.setEmail(email);
		m.setPassword(password);
		int x=m.login();
		if(x==1)
		{
			String Name=m.getName();
			String Email1=m.getEmail();
			String name="";
			for(int i=Name.length()-1;i>=0;i--)
			{
				int s=Name.charAt(i)-1;
				name+=(char)s;
			}
			String email1="";
			for(int i=Email1.length()-1;i>=0;i--)
			{
				int s=Email1.charAt(i)-1;
				email1+=(char)s;
			}
			String Mobile=m.getMobile();
			String mobile="";
			for(int i=Mobile.length()-1;i>=0;i--)
			{
				int s=Mobile.charAt(i)-1;
				mobile+=(char)s;
			}
			HttpSession session=request.getSession(true);
			session.setAttribute("Name", name);
			session.setAttribute("Email", email1);
			session.setAttribute("Mobile", mobile);
			
			response.sendRedirect("/Gmail/Login.jsp");
			}
		else
		{
			response.sendRedirect("/Gmail/Wrong.html");
		}
	}
}
