package conception;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.Client;

/**
 * Servlet implementation class SuppressionClient
 */
@WebServlet("/RechercheClient")
public class RechercheClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheClient() {
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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String cin = request.getParameter("cin");
		String page = request.getParameter("page");
		Client c = new Client();
		List<Client> res = null;
		
		List<Client> liste= c.afficherTousClients();
		if (cin.equals(null)){
			if(nom.equals(null)&& prenom!=null){
				for(Client cl :liste){
					if(cl.getPrenom().equals(prenom)){
					res.add(cl)	;
					}
				}
				
			}
			else if(prenom.equals(null)&& nom!=null){
				
				for(Client cl :liste){
					if(cl.getNom().equals(nom)){
					res.add(cl)	;
					}
				}
				
			}
			else{
				
				for(Client cl :liste){
					if(cl.getPrenom().equals(prenom) && cl.getNom().equals(nom)){
					res.add(cl)	;
					}
				}
				
			}
			
		}
		
		else {
			
			Long cinClient = Long.parseLong(cin);
			for(Client cl :liste){
				if(cl.getCin()==cinClient){
				res.add(cl)	;
				}
			}
			
			
		}
		
		RequestDispatcher disp = request.getRequestDispatcher(page);
		request.setAttribute("resultat", res);
		disp.forward(request, response);
		

	}

}
