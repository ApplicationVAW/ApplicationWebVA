

import java.util.Date;
import java.util.Iterator;

import categorie.Categorie;
import client.Client;
import commande.Commande;
import commande.LigneCommande;
import produit.Produit;

public class Test {

	public static void main(String[] args) {
		// load service 
		
		
		// les produits
		Categorie c = new Categorie();
		Produit p = new Produit();
		Produit p1 = new Produit("prod1","desc1",(double)15, 54);
		Produit p2 = new Produit("prod2","desc2",(double)11, 47);
		Produit p3 = new Produit("prod3","desc3",(double)13, 14);
		Produit p4 = new Produit("prod4","desc4",(double)14, 12);
		Produit p5 = new Produit("prod5","desc5",(double)17, 36);
		Produit p6 = new Produit("prod6","desc6",(double)10, 86);
		Categorie c1 = new Categorie("categ1", "desc1", new Date());
		Categorie c2 = new Categorie("categ2", "desc2", new Date());
		Categorie c3 = new Categorie("categ3", "desc3", new Date());
		c.addCategorie(c1);
		c.addCategorie(c2);
		c.addCategorie(c3);
		p.addProduit(p1,c1);
		p.addProduit(p2,c1);
		p.addProduit(p3,c2);
		p.addProduit(p4,c2);
		p.addProduit(p5,c3);
		p.addProduit(p6,c3);
		p.updateProduit(2L, "ameni", "ameni", 45.3, 45, c3);
		p.deleteProduit(1L);
		c.deleteCategorie(3L);
		
		
		             // afficher un produit
		Produit prod = p.getProduit(3L);
		prod.show();
		            // afficher liste produits
		System.out.println("la liste des produits est");
		Iterator <Produit> prdt = p.getAllProduit().iterator();
		while (prdt.hasNext()){
			Produit pr1 = prdt.next();
			pr1.show();
		}
		// les categories
		
		
	            	// afficher une categorie
		Categorie ca = c.getCategorie(2L);
		ca.show(); 
		           // afficher liste categorie
		System.out.println("la liste des categories est");
		Iterator <Categorie> categ = c.getAllCategorie().iterator();
		while (categ.hasNext()){
			Categorie c11 = categ.next();
			c11.show();
			}

		// affectation des produits aux categorie
		
		// affichage des produits d'une categorie 
		System.out.println("les produits de la categorie sont  ");
		Categorie c21 = c.getCategorie(2L);
		Iterator<Produit> it = c21.getProduits().iterator();
		while (it.hasNext()){
			Produit pc = it.next();
			pc.show();}
		
		
		//*****************************************************************************
		//ajouter un client 
		Client client = new Client();
		Commande commande = new Commande();
		LigneCommande ligneCommande = new LigneCommande();
		Client client1 = new Client("ameni",11036677, 23959033, "Hachicha", "ameni@gmail.com", "hfyrgr", "sfax", 5488);
		client.ajouterClient(client1);
		Commande commande1 = new Commande(new Date());
		Commande commande2 = new Commande(new Date());
		commande.addCommande(commande1, client1);
		commande.addCommande(commande2, client1);
		LigneCommande ligneCommande1 = new LigneCommande(p3, 5);
		LigneCommande ligneCommande2 = new LigneCommande(p4, 7);
		LigneCommande ligneCommande3 = new LigneCommande(p4, 45);
		ligneCommande.addLigneCommande(ligneCommande1, commande1);
		ligneCommande.addLigneCommande(ligneCommande2, commande2);
		ligneCommande.addLigneCommande(ligneCommande3, commande1);
		
		
 //affichage une commande
		
		Commande com1 = commande1.getCommande(1L);
		System.out.println("Num commande "+com1.getCodeCommande()+" Num client "+ com1.getClient().getCodeClient());
		Iterator<LigneCommande> itCom = com1.getLignes().iterator();
		while (itCom.hasNext()){
			LigneCommande lc = itCom.next();
			lc.show();}
		com1.verifierCommande(1L);
	
		
	}
}
		
		
		
	
