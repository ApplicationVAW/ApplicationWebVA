package conception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.Client;
import produit.Produit;

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
		/*List<Client> res = new ArrayList<Client>();
		
		
		
		List<Client> liste= c.afficherTousClients();
		int taille = liste.size();
		
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
			try{
			Long cinClient = Long.parseLong(cin);
			for(int i = 0 ; i<taille; i++){
				
				if(liste.get(i).getCin() == cinClient){
				 res.add(liste.get(i))	;
				 
				}
				else {
					write.println("a7na fil else mta3 ekhr else");
				}
			}
			
			
		
		}
		catch(Exception e){
			write.println("ma7abbech ya3mel cast");
		}
		}
		
		//res.add(c.afficherClient(1));
		Iterator <Client> prdt = res.iterator();
		while (prdt.hasNext()){
			Client pr1 = prdt.next();
		
    		
    	
    		
		
    	     
    	      write.println("hahaha"); 
    	     write.println(liste.size()); 
    	      write.println(pr1.getPrenom());
    	     write.println(pr1.getCin()); 
    	   write.println(pr1.getVille()); 
    	      write.println(pr1.getCodePostale());
		}*/
		Long cinClient = Long.parseLong(cin);
		try{
		Client cli = c.afficherClientCin(cinClient);
		
		
		
		
		RequestDispatcher disp = request.getRequestDispatcher(page);
		request.setAttribute("nom" , cli.getNom());
		request.setAttribute("prenom" , cli.getPrenom());
		request.setAttribute("cin" , cli.getCin());
		request.setAttribute("ville" , cli.getVille());
		request.setAttribute("codepostale" , cli.getCodePostale());
		request.setAttribute("id" , cli.getCodeClient());
		int etat = 1;
		request.setAttribute("etat",etat);
		disp.forward(request, response);
		}
		catch(Exception e){
			RequestDispatcher disp = request.getRequestDispatcher(page);
			int i = 3;
			request.setAttribute("res", i);
			disp.forward(request, response);
		}
		

	}

}
