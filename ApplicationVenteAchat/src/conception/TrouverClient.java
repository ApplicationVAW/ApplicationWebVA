package conception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.Client;

/**
 * Servlet implementation class TrouverClient
 */
@WebServlet("/TrouverClient")
public class TrouverClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrouverClient() {
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
		 Client cl = new Client();
		 Client res = new Client();
		 res = cl.afficherClient(codeClient);
		// PrintWriter write = response.getWriter();
		 
		 
		 RequestDispatcher disp =  request.getRequestDispatcher("/view/m.jsp");
		 //request.setAttribute("client", res);
		    request.setAttribute("nom" , res.getNom());
			request.setAttribute("prenom" , res.getPrenom());
			request.setAttribute("cin" , res.getCin());
			request.setAttribute("email" , res.getEmail());
			request.setAttribute("ville" , res.getVille());
			request.setAttribute("tel" , res.getTel());
			request.setAttribute("codepostale" , res.getCodePostale());
			request.setAttribute("id" , res.getCodeClient());
			request.setAttribute("adresse" , res.getAdresse());
			
		 disp.forward(request, response);  
		
	}

}
