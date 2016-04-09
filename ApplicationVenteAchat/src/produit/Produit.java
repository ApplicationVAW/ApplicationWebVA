package produit;
import java.util.List;
import org.hibernate.Session;
import categorie.Categorie;
import util.HibernateUtil;

public class Produit {
private Long codeProduit;
private String nom;
private String description;
private Double prix;
private int quantiteStock;
private Categorie categorie;

         // constructeurs
public Produit() {}
public Produit(String nom, String description, Double prix, int quantiteStock) {
	this.nom = nom;
	this.description = description;
	this.prix = prix;
	this.quantiteStock = quantiteStock;
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

public Categorie getCategorie() {
	return categorie;
}
public void setCategorie(Categorie categorie) {
	this.categorie = categorie;
}

public int getQuantiteStock() {
	return quantiteStock;
}
public void setQuantiteStock(int quantiteStock) {
	this.quantiteStock = quantiteStock;
}

// methodes de mappage 
// ajouter un produit 
public void addProduit(Produit p, Categorie c){
	Session session = HibernateUtil.getSession().getCurrentSession();
	session.beginTransaction();
	p.setCategorie(c);
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

//modifier un produit 
public void updateProduit(Long codeP,String newNom, String newDesc, Double newPrix, int newQteStock, Categorie c){
	Session session = HibernateUtil.getSession().getCurrentSession();
	session.beginTransaction();
	Produit oldP = (Produit) session.load(Produit.class, codeP);
	oldP.setNom(newNom);
	oldP.setDescription(newDesc);
	oldP.setPrix(newPrix);
	oldP.setQuantiteStock(newQteStock);
	oldP.setCategorie(c);
	session.update(oldP);
	session.getTransaction().commit();
}

//supprimer un produit 
public void deleteProduit(Long idP){
	Session session = HibernateUtil.getSession().getCurrentSession();
	session.beginTransaction();
	Produit p = (Produit) session.load(Produit.class, idP);
	session.delete(p);
	session.getTransaction().commit();
}

//retourner tous les produits
public List<Produit> getAllProduit(){
	Session session = HibernateUtil.getSession().getCurrentSession();
	session.beginTransaction();
	List<Produit> listProd = session.createQuery("from Produit").list();
	return listProd;	
}
//methode show juste pour le test (va etre supprimée ensuite )
public void show() {
System.out.println(this.nom + " - " + this.description + " - " + this.prix + " - " + this.quantiteStock);
	
}




}