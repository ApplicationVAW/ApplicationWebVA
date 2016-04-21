<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Facture</title>
    
    <link href="${pageContext.request.contextPath}/view/css/facture.css" rel="stylesheet" media="all">
    
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

  
    
       <link href="${pageContext.request.contextPath}/view/css/bootstrap1.min.css" rel="stylesheet">
  
     <script src="${pageContext.request.contextPath}/view/js/bootstrap.min.js"></script>
   <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
   
 
     <script src="${pageContext.request.contextPath}/view/js/jquery.min.js"></script>
     <script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-growl/1.0.6/bootstrap-growl.min.js"></script>
     


<script type="text/javascript">

function printDiv(divName) {
    var printContents = document.getElementById(divName).innerHTML;
    var originalContents = document.body.innerHTML;

    document.body.innerHTML = printContents;

    window.print();

    document.body.innerHTML = originalContents;
}
</script>


</head>

<body>



<div class="nav-side-menu">
    <div class="brand">
   nom du societé
    </div>
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>

    <div class="menu-list">

        <ul id="menu-content" class="menu-content collapse in">
            <li>
                <a href="#">
                    <i class="fa fa-dashboard fa-lg"></i> Parametre
                </a>
            </li>

            <li  data-toggle="collapse" data-target="#products" class="collapsed">
                <a href="#"><i class="fa fa-gift fa-lg"></i> Commande <span class="arrow"></span></a>
            </li>
            <ul class="sub-menu collapse" id="products">
                <li class="#"><a href="${pageContext.request.contextPath}/view/ajoutCommande1.jsp">Ajouter commande</a></li>
                 <li><a href="#">Modifier commande</a></li>
                <li><a href="#">Supprimer commande</a></li>
                <li><a href="#">Chercher commande</a></li>
                <li><a href="#">Afficher tous commande</a></li>
             </ul>

            <li data-toggle="collapse" data-target="#produit" class="collapsed">
                    <a href="#"><i class="fa fa-globe fa-lg"></i> Produit <span class="arrow"></span></a>
            </li>
                <ul class="sub-menu collapse" id="produit">
                 <li><a href="${pageContext.request.contextPath}/view/ajoutProduit.jsp">Ajouter produit</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/view/ModifProduit.jsp">Modifier produit</a></li>
                <li><a href="${pageContext.request.contextPath}/view/SupprProduit.jsp">Supprimer produit</a></li>
                
                <li><a href="${pageContext.request.contextPath}/view/listeProduit.jsp">Afficher Produits</a></li>
            
            </ul>


            <li data-toggle="collapse" data-target="#service" class="collapsed">
                <a href="#"><i class="fa fa-users fa-lg"></i> Client <span class="arrow"></span></a>
            </li>
            <ul class="sub-menu collapse" id="service">
                <li><a href="${pageContext.request.contextPath}/view/ajoutClient.jsp">Ajouter client</a></li>
                <li><a href="${pageContext.request.contextPath}/view/SupprClient.jsp">Supprimer client</a></li>
                <li><a href="${pageContext.request.contextPath}/view/ModifClient.jsp">Modifier client</a></li>
                <li><a href="${pageContext.request.contextPath}/view/listeClient.jsp">Chercher client</a></li>
            </ul>


            <li data-toggle="collapse" data-target="#new" class="collapsed">
                <a href="#"><i class="fa fa-car fa-lg"></i> Capegories <span class="arrow"></span></a>
            </li>
            <ul class="sub-menu collapse" id="new">
                <li>Ajouter catégorie</li>
                <li>Supprimer categorie</li>
                <li>Modifier categorie</li>
            </ul>


            <li>
                <a href="#">
                    <i class="fa fa-user fa-lg"></i> Profile
                </a>
            </li>

            <li class="active">
                <a href="#">
                    <i class="fa fa-globe fa-lg"></i> Facture
                </a>
            </li>
        </ul>
    </div>
</div>






 <div id="menu">
        <ul>
            <li><a class="current" href="home.html" title="fermer"></a></li>

        </ul>
    </div>
<div  class="partieDroite" style="width:700px;">
<div id="imprimer">

 <header class="clearfix">
      <div id="logo">
        <img src="${pageContext.request.contextPath}/view/image/logo.png">
      </div>
      <div id="company">
        <h2 class="name">nom societé</h2>
        <div>adresse du societé</div>
        <div>numero de telephone</div>
        <div><a href="mailto:company@example.com">email de la societé</a></div>
      </div>
      
    </header>
    <main>
      <div id="details" class="clearfix">
        <div id="client">
          <div class="to">FACTURE :</div>
          <%@ page import="produit.Produit, vente.Vente, commande.Commande, commande.LigneCommande, conception.AjoutCommande2, client.Client, java.util.Iterator, java.util.*" %>
          <% Long codeCommande = (Long)request.getAttribute("vente");
             Commande com = new Commande();
             Commande commande = com.getCommande(codeCommande);
             Client client = (Client)commande.getClient();
             Vente vente = new Vente();
          %>
          
          <h2 class="name"><%= client.getNom() %> <%= client.getPrenom() %></h2>
          <div class="address"><%= client.getAdresse() %></div>
          <div class="email"><a href="mailto:john@example.com"><%= client.getEmail() %></a></div>
        </div>
        <div id="invoice">
          <h1>INVOICE 3-2-1</h1>
          <div class="date">Date de Facture: <%= new Date() %></div>
          <div class="date">Date d'échéance: <%= new Date() %></div>
        </div>
      </div>
      <table border="0" cellspacing="0" cellpadding="0">
        <thead>
          <tr>
            <th class="no">#</th>
            <th class="desc">PRODUIT</th>
            <th class="unit">PRODUIT UNITAIRE</th>
            <th class="qty">QUANTITé</th>
            <th class="total">TOTAL</th>
          </tr>
        </thead>
        <tbody>
        
        <% Set<LigneCommande> liste = commande.getLignes();
        LigneCommande l = new LigneCommande();
        
        for(LigneCommande ligne: liste){
        	boolean etat = commande.verifCommande(ligne);
           if(etat){
        %>
        
          <tr>
            <td class="no"><%= ligne.getProduit().getCodeProduit() %></td>
            <td class="desc"><h3><%= ligne.getProduit().getNom() %></h3><%= ligne.getProduit().getDescription() %></td>
            <td class="unit"><%= ligne.getProduit().getPrix() %></td>
            <td class="qty"><%= ligne.getQte() %></td>
            <td class="total"><%= l.calculerPrixProduit(ligne) %> DT</td>
          </tr>
          
        <%}
           } %>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="2"></td>
            <td colspan="2">SOUS-TOTAL</td>
            <td><%= vente.calculerMontantTotal(commande) %> Dinars</td>
          </tr>
          <tr>
            <td colspan="2"></td>
            <td colspan="2">TAX 25%</td>
            <td><%= vente.calculerMontantTotal(commande)*(25/100) %></td>
          </tr>
          <tr>
            <td colspan="2"></td>
            <td colspan="2">SOMME FINALE</td>
            <td><%= vente.calculerMontantTotal(commande) + vente.calculerMontantTotal(commande)*(25/100) %></td>
          </tr>
        </tfoot>
      </table>
      <div id="thanks">Merci!</div>
      <div id="notices">
        <div>NOTICE:</div>
        <div class="notice">Une charge financière de 1,5% sera faite sur les soldes impayés après 30 jours.</div>
      </div>
    </main>
  </div>
    <br>
    <br>
   
    
    <button class="btn btn-danger" onclick="printDiv('imprimer');"><i class="fa fa-print"></i> Imprimer facture</button>
     <br>
    <br>
    </div>
   
</body>
</html>