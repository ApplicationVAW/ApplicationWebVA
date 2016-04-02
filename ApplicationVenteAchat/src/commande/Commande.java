package commande;


import java.util.Date;
import java.util.Set;

import org.hibernate.Session;

import categorie.Categorie;
import client.Client;
import produit.Produit;
import util.HibernateUtil;


public class Commande {
	private Long codeCommande;
	private Date dateCommande;
    private Set<LigneCommande> lignes;
    private Client client;
    //constructeurs
	public Commande() {}
	
	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	// getters and setters 
	public Long getCodeCommande() {
		return codeCommande;
	}
	public void setCodeCommande(Long codeCommande) {
		this.codeCommande = codeCommande;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	
	public Set<LigneCommande> getLignes() {
		return lignes;
	}

	public void setLignes(Set<LigneCommande> lignes) {
		this.lignes = lignes;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	// methodes de mappage 
	
// ajouter une commande	
	public void addCommande(Commande commande, Client client){
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.beginTransaction();
		commande.setClient(client);
		session.save(commande);
		session.getTransaction().commit();
	}
	

	
}
