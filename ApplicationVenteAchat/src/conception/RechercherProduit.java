package conception;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import produit.Produit;

/**
 * Servlet implementation class RechercherProduit
 */
@WebServlet("/RechercherProduit")
public class RechercherProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercherProduit() {
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
       
		String code = (String)request.getParameter("code");
		String page = (String)request.getParameter("page");
		Long codeProduit =  Long.parseLong(code);
		Produit p = new Produit();
		Produit produit = new Produit();
		try{
		produit = p.getProduit(codeProduit);
		String nom = produit.getNom();
		String description = produit.getDescription();
		double prix = produit.getPrix();
		int qte = produit.getQuantiteStock();
		String categ = produit.getCategorie().getNom();
		int res =1 ;
		int etat =1;
		request.setAttribute("nom",nom );
		request.setAttribute("description",description );
		request.setAttribute("prix", prix);
		request.setAttribute("qte",qte );
		request.setAttribute("code",codeProduit );
		request.setAttribute("etat", etat);
		request.setAttribute("categorie", categ);
		RequestDispatcher disp = request.getRequestDispatcher(page);
		disp.forward(request, response);
		
		
		}
		catch(Exception e){
			
		}
		
		
	}

}
