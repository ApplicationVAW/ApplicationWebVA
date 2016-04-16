<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des produits</title>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/css/menu.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/css/acueil.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/css/supprime.css" rel="stylesheet">
     <link href="${pageContext.request.contextPath}/view/css/green.css" rel="stylesheet">
      <link href="${pageContext.request.contextPath}/view/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/css/custom1.css" rel="stylesheet">
    

    
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
     <script src="${pageContext.request.contextPath}/view/js/jquery.bootstrap-growl.min.js"></script>
     <script src="${pageContext.request.contextPath}/view/js/jquery.min.js"></script>
     <script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-growl/1.0.6/bootstrap-growl.min.js"></script>
  <title>Insert title here</title>
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
                <li class="active"><a href="#">Ajouter commande</a></li>
                <li><a href="#">Modifier commande</a></li>
                <li><a href="#">Supprimer commande</a></li>
                <li><a href="#">Chercher commande</a></li>
                <li><a href="#">Afficher tous commande</a></li>
             </ul>

            <li data-toggle="collapse" data-target="#produit" class="collapsed active">
                    <a href="#"><i class="fa fa-globe fa-lg"></i> Produit <span class="arrow"></span></a>
            </li>
                <ul class="sub-menu" id="produit">
                <li><a href="${pageContext.request.contextPath}/view/ajoutProduit.jsp">Ajouter produit</a></li>
                <li ><a href="${pageContext.request.contextPath}/view/ModifProduit.jsp">Modifier produit</a></li>
                <li><a href="${pageContext.request.contextPath}/view/SupprProduit.jsp">Supprimer produit</a></li>
                <li><a href="#">chercher produits</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/view/listeProduit.jsp">Afficher Produits</a></li>
            </ul>


            <li data-toggle="collapse" data-target="#service" class="collapsed">
                <a href="#"><i class="fa fa-users fa-lg"></i> Client <span class="arrow"></span></a>
            </li>
            <ul class="sub-menu collapse" id="service">
                <li><a href="${pageContext.request.contextPath}/view/ajoutClient.jsp">Ajouter client</a></li>
                <li><a href="${pageContext.request.contextPath}/view/SupprClient.jsp">Supprimer client</a></li>
                <li class="active"><a href="#">Modifier client</a></li>
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

            <li>
                <a href="#">
                    <i class="fa fa-globe fa-lg"></i> Users
                </a>
            </li>
        </ul>
    </div>
</div>



<div class="partieDroite">
    <div id="menu">
        <ul>
            <li><a class="current" href="home.html" title="fermer"></a></li>

        </ul>
    </div>
    
    



 <br/><br/><br/>
    
    <!-- Plans -->
    
    <%@ page import="produit.Produit, java.util.*" %>
    <% Produit produit = new Produit();
    List<Produit> liste = produit.getAllProduit();
    %>
    <section id="plans">
        <div class="container">
            <div class="row">
          <% for(Produit p:liste){ %>
                <!-- item -->
                <div class="col-md-4 text-center">
                    <div class="panel panel-danger panel-pricing">
                        <div class="panel-heading">
                            <i class="fa fa-desktop"></i>
                            <h3><%= p.getNom() %></h3>
                        </div>
                        <div class="panel-body text-center">
                            <p><strong></strong></p>
                        </div>
                        <ul class="list-group text-center">
                            <li class="list-group-item"><i class="fa fa-check"></i> <%= p.getCategorie().getNom() %></li>
                            <li class="list-group-item"><i class="fa fa-check"></i> <%= p.getDescription() %></li>
                            <li class="list-group-item"><i class="fa fa-check"></i> <%= p.getQuantiteStock() %> piéces</li>
                        </ul>
                        <div class="panel-footer">
                            <a class="btn btn-lg btn-block btn-success" href="#"><%= p.getPrix() %> dinars</a>
                        </div>
                    </div>
                </div>
                <!-- /item -->
   <% } %>
            </div>
        </div>
    </section>
    <!-- /Plans -->
    
    
    
</div>
   <script src="${pageContext.request.contextPath}/view/js/bootstrap.min.js"></script>
 






</body>
</html>