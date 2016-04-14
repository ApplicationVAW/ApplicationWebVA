package conception;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import categorie.Categorie;
import produit.Produit;

/**
 * Servlet implementation class ModifierProduitServlet
 */
@WebServlet("/ModifierProduitServlet")
public class ModifierProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProduitServlet() {
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

		String nom =  request.getParameter("nom");
        String description =  request.getParameter("description");
        String prix =  request.getParameter("prix");
        String qteStock =  request.getParameter("qte");
        String[] categorie = request.getParameterValues("categorie");
        Long code = Long.parseLong(categorie[0]);
        String codeproduit = (String)request.getParameter("code");
        Long cdprd = Long.parseLong(codeproduit);
        double prx = Double.parseDouble(prix);
        int qte = Integer.parseInt(qteStock);
        Produit p = new Produit();
        Produit produit = p.getProduit(cdprd);
        
        double pr = Double.parseDouble(prix);
       
        
        Categorie cat = new Categorie();
        Categorie category = new Categorie();
        category = cat.getCategorie(code);
        
        produit.updateProduit(cdprd, nom, description, prx, qte, category);
        
        int res = 1 ;
        request.setAttribute("res", res);
        RequestDispatcher disp = request.getRequestDispatcher("/view/ModifProduit.jsp");
        disp.forward(request, response);
		
	}

}
