

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Referral
 */
public class Referral extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email=request.getParameter("Email");
		String email="";
		for(int i=Email.length()-1;i>=0;i--)
		{
			int m=Email.charAt(i)+1;
			email +=(char)m;
		}
		Model m=new Model();
		m.setEmail(email);
	int k=	m.ref();
	if(k==1)
	{
		((HttpServletResponse) response).sendRedirect("/Gmail/Create.html");
	}
	else
	{
		((HttpServletResponse) response).sendRedirect("/Gmail/Wrong1.html");
	}
	}

}
