package oblig;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import no.hvl.dat108.CookieUtil;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private DeltagereDAO DeltagerDAO; 
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		Cookie[] ck = request.getCookies();
		
		boolean newbie = true; 
		
		if(ck != null) {
			
			for(int i = 0; i < ck.length; i++) {
				
				if(ck[i].getName().equals("status")) {
					
					Cookie c = ck[i];
					String mob = DeltagerDAO.hent(ck[i].getValue().toString()).getMobilNr();
					if(c.getValue().toString().equals(mob)) {
						 newbie = false; 
						 break; 
						
					}
				}
			}
		}
		if(newbie) {
			request.getRequestDispatcher("WEB-INF/jsp/paameldingsskjema_MAL.jsp").forward(request, response);
		}else {
			//Mulig redirect til Login servlet!
			//request.getRequestDispatcher("WEB-INF/jsp/logginn_MAL.jsp").forward(request, response);
			String PK=""; 
			if(ck != null) {
				
				for(int i = 0; i < ck.length; i++) {
					
					if(ck[i].getName().equals("status")) {
						
						Cookie s = ck[i];
						PK = DeltagerDAO.hent(ck[i].getValue().toString()).getMobilNr();
					}
				}
			}
			
			
			Deltagere deltager = DeltagerDAO.hent(PK);
			
			request.setAttribute("nydeltager", deltager);
			request.getRequestDispatcher("WEB-INF/jsp/paameldingsbekreftelse_MAL.jsp")
			.forward(request, response);
			
			//response.sendRedirect("Login"); 
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fornavn = request.getParameter("fornavn"); 
		String etternavn = request.getParameter("etternavn"); 
		String mobNr = request.getParameter("mobil"); 
		Passord pass = Passord.lagPassord(request.getParameter("passord"));
		String kjonn = request.getParameter("kjonn"); 
		
		
		
		
		
		if(PassordUtil.validerMedSalt(request.getParameter("passord"), pass.getPwd_salt(), pass.getPwd_hash())) {
			
			Deltagere nyDeltager = new Deltagere(fornavn, etternavn, mobNr, pass, kjonn); 
			
			DeltagerDAO.leggTil(nyDeltager); 
			
			Cookie cookie = new Cookie("status", mobNr);
			cookie.setMaxAge(60);
			response.addCookie(cookie);
			

			//Mulig redirect login servlet 
			response.sendRedirect("Register");
			
			
		}else {

			response.sendRedirect("Register");
			
		}
	}

}
