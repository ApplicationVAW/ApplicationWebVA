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
 * Servlet implementation class AjouterClient
 */
@WebServlet("/AjouterClient")
public class AjouterClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterClient() {
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
		// TODO Auto-generated method stub
         String nom =  request.getParameter("nom");
         String prenom =  request.getParameter("prenom");
         String email =  request.getParameter("email");
         Long cin = Long.parseLong(request.getParameter("cin"));
         String adresse =  request.getParameter("adresse");
         String ville =  request.getParameter("ville");
         Long codePostale =   Long.parseLong(request.getParameter("codePostale"));
         Long  telephone =  Long.parseLong(request.getParameter("telephone"));
         
         Client client = new Client(nom, cin, telephone, prenom, email, adresse, ville, codePostale);
         int res = 0 ;
         
         try{
        	 client.ajouterClient(client);
        	 res=1;
        	 RequestDispatcher disp =  request.getRequestDispatcher("/view/ajoutClient.jsp");
        	 request.setAttribute("res", res);
        	 disp.forward(request, response);
        	 
         } catch(Exception e){
        	 res = 2 ;
        	 RequestDispatcher disp =  request.getRequestDispatcher("/view/ajoutClient.jsp");
        	 request.setAttribute("res", res);
        	 disp.forward(request, response);
         }
         
	}

}
