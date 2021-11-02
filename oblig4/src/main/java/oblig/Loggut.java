package oblig;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loggut
 */
@WebServlet("/Loggut")
public class Loggut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] c = request.getCookies(); 
		
		if(c != null) {
			
			for(int i = 0; i < c.length; i++) {
				c[i].setMaxAge(0);
				response.addCookie(c[i]);
			}
		}
		
		request.getRequestDispatcher("WEB-INF/jsp/ferdig_MAL.jsp").forward(request, response); 
		
	}

}
