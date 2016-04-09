package commande;


import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import org.hibernate.Session;
import client.Client;
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
	
	//retourner une commande
		public Commande getCommande(Long codeCom){
			Session session = HibernateUtil.getSession().getCurrentSession();
			session.beginTransaction();
			Commande com = (Commande) session.load(Commande.class, codeCom);
			return com;
		}
		
		
	//retourner une commande
		public Commande verifierCommande(Long codeCom){
			//com.getLignes();
			Commande com = getCommande(1L);
			Iterator<LigneCommande> it = com.getLignes().iterator();
			while (it.hasNext()){
				LigneCommande lc = it.next();
				int qteStock = lc.getProduit().getQuantiteStock();
				int qteDemande = lc.getQte();
				if(qteStock>qteDemande){
					System.out.println("le produit est disponible ");
				}
				else {System.out.println("quantité insuffisante ");}
			}
			
			return com;
				}
	

	
}
