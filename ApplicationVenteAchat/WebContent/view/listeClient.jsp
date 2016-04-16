<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des clients</title>
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

            <li data-toggle="collapse" data-target="#produit" class="collapsed">
                    <a href="#"><i class="fa fa-globe fa-lg"></i> Produit <span class="arrow"></span></a>
            </li>
                <ul class="sub-menu collapse" id="produit">
                <li><a href="#">Ajouter produit</a></li>
                <li><a href="#">Modifier produit</a></li>
                <li><a href="#">Supprimer produit</a></li>
                <li><a href="#">chercher produits</a></li>
                <li><a href="#">Afficher Produits</a></li>
            </ul>


            <li data-toggle="collapse" data-target="#service" class="collapsed active">
                <a href="#"><i class="fa fa-users fa-lg"></i> Client <span class="arrow"></span></a>
            </li>
            <ul class="sub-menu" id="service">
                <li><a href="${pageContext.request.contextPath}/view/ajoutClient.jsp">Ajouter client</a></li>
                <li><a href="${pageContext.request.contextPath}/view/SupprClient.jsp">Supprimer client</a></li>
                <li ><a href="${pageContext.request.contextPath}/view/ModifClient.jsp">Modifier client</a></li>
                <li class="active" ><a href="${pageContext.request.contextPath}/view/listeClient.jsp">Chercher client</a></li>
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
    
    



<div class="right_col" role="main" style="min-height: 667px;">

        <div class="">
         
          <div class="clearfix"></div>

          <div class="row">
            <div class="col-md-12">
              <div class="x_panel">
                <div class="x_content">

                  <div class="row" style="height:1000px ; width:880px ;">

                  
                    <div class="clearfix"></div>
                    
                    
                     <%@ page import="client.Client, java.util.*" %>
                     <% Client c = new Client();
             		List<Client> liste = c.afficherTousClients();
            		for(Client client:liste){%>
            		
            			
            		
                    <div class="col-md-4 col-sm-4 col-xs-12 animated fadeInDown">
                      <div class="well profile_view">
                        <div class="col-sm-12">
                          <h4 class="brief"><i>VenteAch@t</i></h4>
                          <div class="left col-xs-7">
                            <h2><%= (String)client.getNom() + (String)client.getPrenom() %></h2>
                            <p><strong>Cin : </strong> <%= (Long)client.getCin() %> </p>
                            <ul class="list-unstyled">
                              <li><i class="fa fa-phone"></i> Address: <%= (String)client.getVille()%></li>
                              <li><i class="fa fa-phone"></i> Telephone: <%= (Long)client.getTel() %></li>

                            </ul>
                          </div>
                          <div class="right col-xs-5 text-center">
                            <img src="image/img.jpg" alt="" class="img-circle img-responsive">
                          </div>
                        </div>
                        <div class="col-xs-12 bottom text-center">
                         
                          <div class="col-xs-12 col-sm-6 emphasis">
                            <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                                            </i> <i class="fa fa-comments-o"></i> </button>
                            <button type="button" class="btn btn-primary btn-xs" style="position:fixed;"> <i class="fa fa-user">
                                                            </i> View Profile </button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <% } %>
                    
               </div>

                </div>
              </div>
            </div>
          </div>
        </div>

       

      </div>
    
    
    
    
</div>
   <script src="${pageContext.request.contextPath}/view/js/bootstrap.min.js"></script>
 
</body>
</html>