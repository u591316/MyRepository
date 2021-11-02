package oblig;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deltagerliste
 */
@WebServlet("/Deltagerliste")
public class Deltagerliste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagereDAO DeltagerDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Deltagere>liste = DeltagerDAO.hentAlleDeltager();
		
		request.setAttribute("deltagere", liste);
		
		request.getRequestDispatcher("WEB-INF/jsp/deltagerliste_MAL.jsp").forward(request, response);
		
	}

}
