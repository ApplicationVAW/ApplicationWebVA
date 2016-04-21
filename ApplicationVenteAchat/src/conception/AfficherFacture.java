package conception;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commande.Commande;
import vente.Vente;

/**
 * Servlet implementation class AfficherFacture
 */
@WebServlet("/AfficherFacture")
public class AfficherFacture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherFacture() {
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
	
		Long codeCommande = Long.parseLong(request.getParameter("codeCommande"));
		//Commande com = new Commande();
		//Commande commande = com.getCommande(codeCommande);
		//Vente vente = new Vente();
		//Vente v = new Vente();
		//vente.setCommande(commande);
		//v.addVente(vente, commande);
		//Long codeVente = vente.getCodeVente();
		RequestDispatcher  disp = request.getRequestDispatcher("/view/facture.jsp");
		request.setAttribute("vente", codeCommande);
		disp.forward(request, response);
	
	}

}
