

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email=request.getParameter("Email");
		String email="";
		for(int i=Email.length()-1;i>=0;i--)
		{
			int m=Email.charAt(i)+1;
			email +=(char)m;
		}
		String Password=request.getParameter("Password");
		String password="";
		for(int i=Password.length()-1;i>=0;i--)
		{
			int m=Password.charAt(i)+1;
			password +=(char)m;
		}
		Model m=new Model();
		m.setEmail(email);
		m.setPassword(password);
		int x=m.login();
		if(x==1)
		{
			int s=m.Delete();
			if(s==1)
			{
				response.sendRedirect("/Gmail/Sucdeleted.html");
			}
		}
		else
		{
			response.sendRedirect("/Gmail/Wrong2.html");
		}
	}

}
