package client;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import commande.Commande;
import util.HibernateUtil;

public class Client {
	
	
	
	private long codeClient ; 
	private String nom ;
	private Long cin ;
	private Long tel;
	private String prenom ;
	private String email ;
	private String adresse ;
	private String ville ;
	private long codePostale ;
	private Set<Commande> commandes = new HashSet<Commande>();
	
	//getters et setters
	
	public long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(long codeClient) {
		this.codeClient = codeClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public long getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(long codePostale) {
		this.codePostale = codePostale;
	}
	public Long getCin() {
		return cin;
	}
	public void setCin(Long cin) {
		this.cin = cin;
	}
	public Long getTel() {
		return tel;
	}
	public void setTel(Long tel) {
		this.tel = tel;
	}
	public Set<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	
	//constructeur avec parametre
	public Client(String nom, Long cin, Long tel, String prenom, String email, String adresse, String ville,
			long codePostale) {
		super();
		this.nom = nom;
		this.cin = cin;
		this.tel = tel;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostale = codePostale;
	}
	//constructeur sans parametre
	public Client() {
		super();
	}
	
	//ajout de client
	
	public void ajouterClient(Client client){
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.beginTransaction();
		session.save(client);
		session.getTransaction().commit();
	}
	
	
	//suppression de client
	
	public void supprimerClient(long code){
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.beginTransaction();
		Client c = (Client)session.get(Client.class, code);
		session.delete(c);
		session.getTransaction().commit();
	}
	
	
	//modification de client 
	
	public void modifierClient(long code , String nom, String prenom, String email, String adresse, String ville, long codePostale, Long tel, Long cin ){
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.beginTransaction();
		Client c = (Client)session.get(Client.class , code);
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setVille(ville);
		c.setEmail(email);
		c.setCodePostale(codePostale);
		c.setCin(cin);
		c.setTel(tel);
		session.update(c);
		session.getTransaction().commit();
		
	}
	
	//retourner un client
	
	public Client afficherClient(long code){
		
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.beginTransaction();
		Client c = (Client)session.get(Client.class, code);
		session.getTransaction().commit();
		return c ;
		
	}
	
	
	//retourner tous les client dans la base
	
	public List<Client> afficherTousClients(){
		
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.beginTransaction();
		List<Client> liste = session.createQuery("from client").list();
		session.getTransaction().commit();
		return liste ;
	}
	

}
