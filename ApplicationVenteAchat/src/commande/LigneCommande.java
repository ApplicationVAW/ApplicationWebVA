package commande;

import org.hibernate.Session;
import produit.Produit;
import util.HibernateUtil;

public class LigneCommande {
	private Long idLigne;
	private Produit produit;
	private int qte;
    private Commande commande;
	//constructeurs
	public LigneCommande(Produit produit, int qte) {
		super();
		this.produit = produit;
		this.qte = qte;
	}
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	//getters and setters
	public Long getIdLigne() {
		return idLigne;
	}
	public void setIdLigne(Long idLigne) {
		this.idLigne = idLigne;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	//methodes de mappage 
	
// ajouter une ligne de commande
	public void addLigneCommande(LigneCommande l, Commande c){
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.beginTransaction();
		l.setCommande(c);
		session.save(l);
		session.getTransaction().commit();
	}

// afficher une ligne pour le test 
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("code produit "+this.produit.getCodeProduit()+" - "+ this.produit.getNom()+" - " + this.qte);	
	}
	
	

}
