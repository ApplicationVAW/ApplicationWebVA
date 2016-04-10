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
import client.Client;
import commande.Commande;

/**
 * Servlet implementation class AjoutCommande1
 */
@WebServlet("/AjoutCommande1")
public class AjoutCommande1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutCommande1() {
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
	
		String id = (String)request.getParameter("code");
	    Long codeClient = Long.parseLong(id);
		
		 Client client = new Client();
		 Client client1 = new Client();
		 client1 = client.afficherClient(codeClient);
		 Commande commande = new Commande();
		 Commande commande1 = new Commande(new Date());
		 commande.addCommande(commande1, client1);
		 //int res = 1;
         RequestDispatcher disp = request.getRequestDispatcher("/view/AjoutLigneCommande.jsp");
        //request.setAttribute("res", res);
         disp.forward(request, response);
		/* response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(client1.getNom());*/
		 
		
	}

}
