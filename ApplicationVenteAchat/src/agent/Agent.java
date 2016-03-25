package agent;

import org.hibernate.Session;

import util.HibernateUtil;

public class Agent {
	
	//coordonnée de chaque agent de la societé
	
	private String login ;
	private String motDePasse ;
	private String email ;
	private int  id ;
	
	//les getters et les setters
	
	public String getMotDePasse() {
		return motDePasse;
	}
	
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	// le constructeur
	
	public Agent(String login, String motdepasse, String email) {
		super();
		this.login = login;
		motDePasse = motdepasse;
		this.email = email;
	}
	
	
	public Agent() {
		super();
	}
	
	
	
	// la methode se connecter
	
	public boolean seConnecter(String login , String motdepasse){
		boolean authentif= false ;
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.beginTransaction();
		
		Agent agent = new Agent();
		agent = (Agent)session.load(Agent.class, login);
		
		//comparaison des donné saisie
		
		if (agent.getMotDePasse().equals(motdepasse)){
			authentif= true ;
		}
		else {
			authentif=false ;
		}
		
		session.getTransaction().commit();
		
		return authentif ;
	}
	

	
}
