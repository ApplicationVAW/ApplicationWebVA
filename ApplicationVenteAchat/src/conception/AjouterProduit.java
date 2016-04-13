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
 * Servlet implementation class AjouterProduit
 */
@WebServlet("/AjouterProduit")
public class AjouterProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterProduit() {
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
         
         double pr = Double.parseDouble(prix);
         int qte = Integer.parseInt(qteStock);
         
         Categorie cat = new Categorie();
         Categorie category = new Categorie();
         category = cat.getCategorie(code);
         
         Produit produit = new Produit(nom,description,pr,qte);
         Produit p = new Produit();
         p.addProduit(produit,category );
         int res = 1;
         RequestDispatcher disp = request.getRequestDispatcher("/view/ajoutProduit.jsp");
         request.setAttribute("res", res);
         disp.forward(request, response);
         
         
         
         

		
	}

}
