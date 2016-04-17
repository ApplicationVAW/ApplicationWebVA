package conception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commande.Commande;
import commande.LigneCommande;
import produit.Produit;

/**
 * Servlet implementation class AjoutCommande2
 */
@WebServlet("/AjoutCommande2")
public class AjoutCommande2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutCommande2() {
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
		// TODO Auto-generated method stub
		String codeCom = (String)request.getParameter("codeCommande");
	    Long codeCommande = Long.parseLong(codeCom);
	    Commande commande = new Commande();
	    Commande commande1 = new Commande();
	    commande1 = commande.getCommande(codeCommande);
	    String quantite = (String)request.getParameter("qte");
	    int qte=Integer.parseInt(quantite);
	    String codeProd = (String)request.getParameter("codeProduit");
	    Long codeProduit = Long.parseLong(codeProd);
	    Produit p1 = new Produit();
	    LigneCommande ligne = new LigneCommande(p1.getProduit(codeProduit),qte);
	    ligne.addLigneCommande(ligne,commande1);
	    request.setAttribute("codeCommande", codeCommande);
	    RequestDispatcher disp = request.getRequestDispatcher("/view/AjoutLigneCommande.jsp");
        disp.forward(request, response);
	  	
			
	}

}
