package oblig;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private DeltagereDAO DeltagerDAO; 
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] ck = request.getCookies();
		boolean signedIn = false; 
		
		if(ck != null) {
			
			for(int i = 0; i < ck.length; i++) {
				
				if(ck[i].getName().equals("SignedIn")) {
					
					Cookie c = ck[i];
					
					if(c.getValue().equals(request.getSession().getAttribute("bruker").toString())) {
						 signedIn = true; 
						 break; 
						
					}
				}
			}
		}
		if(signedIn) {
			List<Deltagere> deltagere = DeltagerDAO.hentAlleDeltager(); 
			
			//Ta vare på data til jsp'en 
			request.setAttribute("deltagere", deltagere);
			
			request.setAttribute("innlogget", request.getSession().getAttribute("bruker").toString());
			request.getRequestDispatcher("WEB-INF/jsp/deltagerliste_MAL.jsp").forward(request, response);
		}else {
			//response.sendRedirect("Register"); 
			request.getRequestDispatcher("WEB-INF/jsp/logginn_MAL.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uName = request.getParameter("mobil"); 
		String pass = request.getParameter("passord");
		
		/*
		 * Feil med valideringen under innlogging! Lag metode i DAO for å hente lagret passord fra databasen.
		 * Muligens bruke saltet fra databasen og 
		 */
		
		String password = DeltagerDAO.hent(uName).getPassord().toString();  
		String salt = DeltagerDAO.hent(uName).getPassord().getPwd_salt(); 
		
		
		if(password.equals(PassordUtil.hashMedSalt(pass, salt) + salt)) {
			
			Cookie cookie = new Cookie("SignedIn", uName);
			cookie.setMaxAge(120);
			response.addCookie(cookie);
			
			request.getSession().setAttribute("bruker", uName);
			
			response.sendRedirect("Login");
		}else {
			response.sendRedirect("index.html");
		}
		
		
	}

}
