

import java.util.Date;
import java.util.Iterator;

import categorie.Categorie;
import produit.Produit;

public class Test {

	public static void main(String[] args) {
		// load service 
		
		
		// les produits
		Categorie c = new Categorie();
		Produit p = new Produit();
		Produit p1 = new Produit("prod1","desc1",(double)15);
		Produit p2 = new Produit("prod2","desc2",(double)11);
		Produit p3 = new Produit("prod3","desc3",(double)13);
		Produit p4 = new Produit("prod4","desc4",(double)14);
		Produit p5 = new Produit("prod5","desc5",(double)17);
		Produit p6 = new Produit("prod6","desc6",(double)10);
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
		p.updateProduit(2L, "ameni", "ameni", 45.3, c3);
		p.deleteProduit(1L);
		c.deleteCategorie(3L);
		
		/*
		             // afficher un produit
		Produit pr = s.getProduit(1L);
		pr.show();
		            // afficher liste produits
		System.out.println("la liste des produits est");
		Iterator <Produit> prdt = s.getAllProduit().iterator();
		while (prdt.hasNext()){
			Produit p = prdt.next();
			p.show();
		}
		// les categories
		
		
	            	// afficher une categorie
		Categorie ca = s.getCategorie(2L);
		ca.show(); 
		           // afficher liste categorie
		System.out.println("la liste des categories est");
		Iterator <Categorie> categ = s.getAllCategorie().iterator();
		while (categ.hasNext()){
			Categorie c = categ.next();
			c.show();
			}

		// affectation des produits aux categorie
		
		// affichage des produits d'une categorie 
		System.out.println("les produits de la categorie sont  ");
		Categorie c = s.getCategorie(1L);
		Iterator<Produit> it = c.getProduits().iterator();
		while (it.hasNext()){
			Produit pc = it.next();
			pc.show();}
		
		//supp prod
		
		*/
		
		
	}

}
