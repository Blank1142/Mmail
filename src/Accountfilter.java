

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Accountfilter
 */
public class Accountfilter implements Filter {

    /**
     * Default constructor. 
     */
    public Accountfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String Name=request.getParameter("Name");
		String Email=request.getParameter("Email");
		String Mobile=request.getParameter("Mobile");
		String Password=request.getParameter("Password");
		String Cpassword=request.getParameter("Cpassword");
		
		if(Name.length()!=0 && Email.length()!=0 &&Mobile.length()!=0 && Password.length()!=0 && Cpassword.length()!=0)
		{
			if(Password.equals(Cpassword))
			{
				chain.doFilter(request, response);
			}
		}
		else
		{
			((HttpServletResponse) response).sendRedirect("/Gmail/Wrong.html");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
