package filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.UsuarioM;

/**
 * Servlet Filter implementation class Admin
 */
@WebFilter("/index.xhtml")
public class Admin implements Filter {

    /**
     * Default constructor. 
     */
    public Admin() {
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
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		 HttpServletRequest req = (HttpServletRequest)request;
		 HttpServletResponse res = (HttpServletResponse)response;
		 HttpSession session = (HttpSession)req.getSession();
		 UsuarioM login = (UsuarioM)session.getAttribute("usuario");
		 if(login == null) {
			
			 res.sendRedirect(req.getContextPath()+ "user.xhtml"); 
		 }else {
			 chain.doFilter(request, response);
		 }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
