package produit;

import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

public class Produit {
private Long codeProduit;
private String nom;
private String description;
private Double prix;

         // constructeurs
public Produit() {}
public Produit(String nom, String description, Double prix) {
	this.nom = nom;
	this.description = description;
	this.prix = prix;
}

        // getters and setters
public Long getCodeProduit() {
	return codeProduit;
}
public void setCodeProduit(Long codeProduit) {
	this.codeProduit = codeProduit;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Double getPrix() {
	return prix;
}
public void setPrix(Double prix) {
	this.prix = prix;
}

       // methodes de mappage 

// ajouter un produit à la base 
public void addProduit(Produit p){
	Session session = HibernateUtil.getSession().getCurrentSession();
	session.beginTransaction();
	session.save(p);
	session.getTransaction().commit();
}

//retourner un produit
public Produit getProduit(Long codeP){
	Session session = HibernateUtil.getSession().getCurrentSession();
	session.beginTransaction();
	Produit p = (Produit) session.load(Produit.class, codeP);
	return p;
}

//retourner tous les produits
public List<Produit> getAllProduit(){
	Session session = HibernateUtil.getSession().getCurrentSession();
	session.beginTransaction();
	List<Produit> listProd = session.createQuery("from Produit").list();
	return listProd;	
}
//modifier un produit 
public void updateProduit(Long codeP,String newNom, String newDesc, Double newPrix){
	Session session = HibernateUtil.getSession().getCurrentSession();
	session.beginTransaction();
	Produit oldP = (Produit) session.load(Produit.class, codeP);
	oldP.setNom(newNom);
	oldP.setDescription(newDesc);
	oldP.setPrix(newPrix);
	session.update(oldP);
	session.getTransaction().commit();
}
//supprimer un produit 
public void deleteProduit(Long idP){
	Session session = HibernateUtil.getSession().getCurrentSession();
	session.beginTransaction();
	Produit oldP = (Produit) session.load(Produit.class, idP);
	session.delete(oldP);
	session.getTransaction().commit();
		
}

}