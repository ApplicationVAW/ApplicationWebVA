package categorie;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;

import produit.Produit;
import util.HibernateUtil;

public class Categorie {
	private Long codeCategorie;
	private String nom;
	private String description;
	private Date dateAjout;
	private Set<Produit> produits = new HashSet<Produit>();
	
	//constructeurs
	
	public Categorie() {}

	public Categorie(String nom, String description, Date dateAjout) {
		super();
		this.nom = nom;
		this.description = description;
		this.dateAjout = dateAjout;
	}
	
	//getters and setters

	public Long getCodeCategorie() {
		return codeCategorie;
	}

	public void setCodeCategorie(Long codeCategorie) {
		this.codeCategorie = codeCategorie;
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

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
	
	// methodes de mappage

//ajouter une categorie	
	public void addCategorie(Categorie c){
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
	}

//retourner une categorie	
	public Categorie getCategorie(Long codeC){
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.beginTransaction();
		Categorie c = (Categorie) session.load(Categorie.class, codeC);
		return c;
	}

//retourner toutes les categories	
	public List<Categorie> getAllCategorie(){
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.beginTransaction();
		List<Categorie> listCateg = session.createQuery("from Categorie").list();
		return listCateg;	
	}
//modifier une categorie
	public void updateCategorie(Long codeC,String newNom, String newDesc){
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.beginTransaction();
		Categorie oldC = (Categorie) session.load(Categorie.class, codeC);
		oldC.setNom(newNom);
		oldC.setDescription(newDesc);
		oldC.setDateAjout(new Date());
		session.update(oldC);
		session.getTransaction().commit();
	}
//supprimer une categorie	
	public void deleteCategorie(Long idC){
		Session session = HibernateUtil.getSession().getCurrentSession();
		session.beginTransaction();
		Categorie c = (Categorie) session.load(Categorie.class, idC);
		session.delete(c);
		session.getTransaction().commit();
	}	
}
