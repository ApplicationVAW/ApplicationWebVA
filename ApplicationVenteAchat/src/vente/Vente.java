package vente;

import org.hibernate.Session;

import client.Client;
import commande.Commande;
import util.HibernateUtil;

public class Vente {
private Long codeVente;
private Commande commande;
//constructeurs
public Vente(Commande commande) {
	this.commande = commande;
}
public Vente() {}
//getters and setters 
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
      //methodes de mappage 

//ajouter une vente
	public void addVente(Vente vente, Commande commande){
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.beginTransaction();
		vente.setCommande(commande);
		session.save(vente);
		session.getTransaction().commit();
	}

}
