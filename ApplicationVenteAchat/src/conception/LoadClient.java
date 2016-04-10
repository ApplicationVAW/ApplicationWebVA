package conception;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.Client;

/**
 * Servlet implementation class LoadClient
 */
@WebServlet("/LoadClient")
public class LoadClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String cin = request.getParameter("cin");
		String page = request.getParameter("page");
		
		
		Client c = new Client();
		
		Long cinClient = Long.parseLong(cin);
		try{
		Client cli = c.afficherClientCin(cinClient);
				
		RequestDispatcher disp = request.getRequestDispatcher("/view/ajoutCommande1.jsp");
		request.setAttribute("nom" , cli.getNom());
		request.setAttribute("prenom" , cli.getPrenom());
		request.setAttribute("cin" , cli.getCin());
		request.setAttribute("ville" , cli.getVille());
		request.setAttribute("codepostale" , cli.getCodePostale());
		request.setAttribute("id" , cli.getCodeClient());
		disp.forward(request, response);
		}
		catch(Exception e){
			RequestDispatcher disp = request.getRequestDispatcher("/view/ajoutCommande1.jsp");
			int i = 3;
			request.setAttribute("res", i);
			disp.forward(request, response);
		}
		

	}

}

	

