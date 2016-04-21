package vente;

import java.util.Set;

import org.hibernate.Session;

import commande.Commande;
import commande.LigneCommande;
import util.HibernateUtil;

public class Vente {
	private Long codeVente;
	private Commande commande;

	// constructeurs
	public Vente(Commande commande) {
		this.commande = commande;
	}

	public Vente() {
	}

	// getters and setters
	public Long getCodeVente() {
		return codeVente;
	}

	public void setCodeVente(Long codeVente) {
		this.codeVente = codeVente;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	// methodes de mappage

	// ajouter une vente
	public void addVente(Vente vente, Commande commande) {
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.beginTransaction();
		vente.setCommande(commande);
		session.save(vente);
		session.getTransaction().commit();
	}
	
	
	
	// calcul montant total
	
	public double calculerMontantTotal(Commande c){
		double montant =0  ;
		Commande commande = new Commande();
		LigneCommande l = new LigneCommande();
		Set<LigneCommande> liste = c.getLignes();
		for(LigneCommande ligne: liste){
			boolean etat = commande.verifCommande(ligne);
	           if(etat){
	        	   montant = montant + l.calculerPrixProduit(ligne);
	           }
		}
		
		return montant;
	}
	
	

}
