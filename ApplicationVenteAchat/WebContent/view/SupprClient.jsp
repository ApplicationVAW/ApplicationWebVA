<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supprimer client</title>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/css/menu.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/css/acueil.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/css/supprime.css" rel="stylesheet">
    
        <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
     <script src="${pageContext.request.contextPath}/view/js/jquery.bootstrap-growl.min.js"></script>
     <script src="${pageContext.request.contextPath}/view/js/jquery.min.js"></script>
     <script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-growl/1.0.6/bootstrap-growl.min.js"></script>
  
</head>

<body>


<% int a = 0;
 try{
	 String var = (String)request.getAttribute("res");
	 int res = Integer.parseInt(var);
	 if(res==1){
		 %>
		 
		 <script type="text/javascript">

		 $(document).ready(function () {
			    $.growl({
			        message: 'la suppression du client est effectuée avec succée .',
			     
			    }, {
			    	type: 'success',
			        placement: {
			            from: "bottom",
			            align: "left"
			        },
			        delay: 3000
			    });
			});

        </script>
		 <% 
	 }
	 else {
		 %>
		 
		 	 <script type="text/javascript">

		 $(document).ready(function () {
			    $.growl({
			        message: 'Client non trouvé !! verifier le CIN ou le nom saisi',
			     
			    }, {
			    	type: 'danger',
			        placement: {
			            from: "bottom",
			            align: "left"
			        },
			        delay: 10000
			    });
			});

       </script>
		 
		 <% 
	 }
	 
	 
 }catch(Exception e){
	 
 }

%>




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
                <li class="active"><a href="${pageContext.request.contextPath}/view/SupprClient.jsp">Supprimer client</a></li>
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
    
    
     <div id="advanced" class="modal fade in" tabindex="-1" role="dialog" aria-labelledby="advancedSort" aria-hidden="false" style="display: block;">
        <div class="modal-header">

            <ul class="nav nav-pills pull-right">
                <li class="active">
                    <a href="#CIN" data-toggle="pill">CIN</a>
                </li>
                <li><a href="#nomprenom" data-toggle="pill">Nom & prenom</a></li>

            </ul>
            <h4>Rechercher Client par :</h4>
        </div>
        <div class="modal-body">
            <div class="row-fluid">
                <div class="tab-content">
                    <div class="tab-pane active" id="CIN">
                        <form method="post" action="/ApplicationVenteAchat/RechercheClient">

                                <div class="form-group has-feedback">

                                    <br>
                                    <input type="NUMBER" class="span5" placeholder="CN" name="cin"/>
                                    <input type="hidden"  name="page" value="/view/SupprClient.jsp">

                                </div>

                            <button type="submit" class="btn btn-success">Chercher</button>
                            <button type="reset" class="btn btn-info">Annuler</button>
                        </form>
                    </div>
                    <div class="tab-pane" id="nomprenom">
                        <form method="post" action="/ApplicationVenteAchat/RechercheClient" >
                            <fieldset>
                                <div class="form-group has-feedback">
                                    <br>
                                    <input type="text" class="span5" placeholder="nom" name="nom">
                                    <input type="text" class="span5" placeholder="prenom" name="prenom">
                                    <input type="hidden"  name="page" value="/view/SupprClient.jsp">


                                </div>
                                <button type="submit" class="btn btn-success">Chercher</button>
                                <button type="reset" class="btn btn-info">Annuler</button>
                            </fieldset>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>






        <div class="row1">
            <div class="col-md-12">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Client</h3>

                    </div>

                    <table class="table table-bordered" id="dev-table">
                        <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Prenom</th>
                            <th>CIN</th>
                            <th>Ville</th>
                            <th>Code postale</th>
                            <th>Action</th>

                        </tr>
                        </thead>
                        <tbody>
                        <%@ page import="client.Client, java.util.List;" %>
                        
                        <% Client client = new Client();
                        
                        try{
                        	
                        	
                        		%>
                        		
                        		
                        	     <tr>
                                 <td><%= (String)request.getAttribute("nom") %></td>
                                 <td><%= (String)request.getAttribute("prenom")  %></td>
                                 <td><%= (Long)request.getAttribute("cin")  %></td>
                                 <td><%= (String)request.getAttribute("ville")  %></td>
                                 <td><%= (Long)request.getAttribute("codepostale")  %></td>
                                 <td><form method="post" action="/ApplicationVenteAchat/SupprClient"><input type="hidden"  value="<%= (Long)request.getAttribute("id")  %>" name="code"><input type="submit" value="supprimer" class="btn btn-danger btn-xs"></form></td>
                             </tr>
                        		
                        <% 	
                        
                        } catch(Exception e){
                        	
                        }
                        %>
                    </tbody>
                        </table>
                    </div>
                </div>
            </div>
    
    
    
    
</div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/view/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/view/js/jquery.min.js"></script>
</body>
</html>