package conception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import agent.Agent;
import net.sf.cglib.proxy.Dispatcher;

/**
 * Servlet implementation class ServletVerification
 */
@WebServlet("/servletVeriflogin")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		//recuperation des parametre envoyé
		String identifiant = (String)request.getParameter("identifiant");
		String mdp = (String)request.getParameter("motDePasse");
		
		//verification de conformité des donné saisie
		
		Boolean resultat ;
		Agent agent = new Agent();
	    resultat = agent.seConnecter(identifiant, mdp);
	    
		if (resultat==false){
			//le cas ou les donné sont non conforme
			
		RequestDispatcher disp = request.getRequestDispatcher("/view/loginAgent.jsp");
		int i = 2 ;
		request.setAttribute("connect", i);
	    disp.forward(request, response);
	    }
		else {
			//le cas ou les données sont conforme
			
			
			int i = 1 ;
			
			RequestDispatcher disp = request.getRequestDispatcher("/view/accueil.jsp");
			request.setAttribute("connect", i);
		    disp.forward(request, response);
		}
	
	}

}
