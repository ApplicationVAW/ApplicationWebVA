<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ligne commande</title>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/css/menu.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/css/add.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/css/acueil.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/css/custom1.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/css/green.css" rel="stylesheet">
    
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
     <script src="${pageContext.request.contextPath}/view/js/jquery.bootstrap-growl.min.js"></script>
     <script src="${pageContext.request.contextPath}/view/js/jquery.min.js"></script>
     <script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-growl/1.0.6/bootstrap-growl.min.js"></script>
</head>
<body>
 <%@ page import="conception.AjoutCommande1" %>  
  <%@ page import="produit.Produit, commande.Commande, commande.LigneCommande, conception.AjoutCommande1, client.Client, java.util.Iterator, java.util.*" %>

<div class="nav-side-menu">
    <div class="brand">Nom du societ�</div>
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>

    <div class="menu-list">

        <ul id="menu-content" class="menu-content collapse in">
            <li>
                <a href="#">
                    <i class="fa fa-dashboard fa-lg"></i> Parametre
                </a>
            </li>

            <li  data-toggle="collapse" data-target="#products" class="collapsed active">
                <a href="#"><i class="fa fa-gift fa-lg"></i> Commande <span class="arrow"></span></a>
            </li>
            <ul class="sub-menu" id="products">
                <li class="active"><a href="${pageContext.request.contextPath}/view/ajoutCommande1.jsp">Ajouter commande</a></li>
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
                <li><a href="${pageContext.request.contextPath}/view/ModifProduit.jsp">Modifier produit</a></li>
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
                <li><a href="${pageContext.request.contextPath}/view/listeClient.jsp">Afficher client</a></li>
            </ul>


            <li data-toggle="collapse" data-target="#new" class="collapsed">
                <a href="#"><i class="fa fa-car fa-lg"></i> Capegories <span class="arrow"></span></a>
            </li>
            <ul class="sub-menu collapse" id="new">
                <li><a href="#">Ajouter categorie</a></li>
                <li><a href="#">Supprimer categorie</a></li>
                <li><a href="#">Modifier categorie</a></li>
            </ul>


            <li>
                <a href="#">
                    <i class="fa fa-user fa-lg"></i> Profile
                </a>
            </li>

            <li>
                <a href="#">
                    <i class="fa fa-globe fa-lg"></i> Facture
                </a>
            </li>
        </ul>
    </div>
</div>


<!-- hedhi hia ell partie elli dima tetbaddel -->
<% 
		Commande com = (Commande) request.getAttribute("commande");
    // Commande commande = new Commande();
      //Commande com = commande.getCommande(1L);
    //Long code = (Long)request.getAttribute("codeCommande");
    //Commande com = commande.getCommande(code); %>


<div class="partieDroite">
    <div id="menu">
        <ul>
            <li><a class="current" href="home.html" title="fermer"></a></li>
        </ul>
    </div>

<div class="container">
    <div id="calc" class="row text-center">
    <div class="form-group">
           <h3>Code Commande : <%=com.getCodeCommande() %> </h3> <h3>Date :  <%=com.getDateCommande() %></h3>          
            </div>
            <div class="form-group">
           <h2>Client : <%=com.getClient().getNom() %> <%=com.getClient().getPrenom() %></h2>   
            </div>
            <br>
        <div class="entry form-inline">
          <form method="post"  action="/ApplicationVenteAchat/AjoutCommande2">
           
           <div class="input-group">
             <span class="input-group-addon" id="basic-addon1">Code du produit</span>
               <input type="number" class="form-control" name="codeProduit" placeholder="...">
               <span class="input-group-addon"></span>
             </div>
             <div class="input-group">
             <span class="input-group-addon" id="basic-addon1">Quantit� d�sir�e</span>
                    <input type="number" class="form-control" name="qte" placeholder="...">   
                    <span class="input-group-addon"></span>  
             </div>
             <button id="send" type="submit" class="btn btn-success" >Ajouter � la commande</button>
             <input type="hidden"  name="codeCommande" value= "<%=com.getCodeCommande() %>" > 
            
          </form>
         
        </div>
        
    </div>
</div>
        <script src="${pageContext.request.contextPath}/view/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/view/js/validator.js"></script>
        <script src="${pageContext.request.contextPath}/view/js/custom.js"></script>
        <script src="${pageContext.request.contextPath}/view/js/icheck.min.js"></script>
        <script src="${pageContext.request.contextPath}/view/js/pace.min.js"></script>
<script>
    // initialize the validator function
    validator.message['date'] = 'not a real date';

    // validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
    $('form')
            .on('blur', 'input[required], input.optional, select.required', validator.checkField)
            .on('change', 'select.required', validator.checkField)
            .on('keypress', 'input[required][pattern]', validator.keypress);

    $('.multi.required')
            .on('keyup blur', 'input', function() {
                validator.checkField.apply($(this).siblings().last()[0]);
            });

    // bind the validation to the form submit event
    //$('#send').click('submit');//.prop('disabled', true);

    $('form').submit(function(e) {
        e.preventDefault();
        var submit = true;
        // evaluate the form using generic validaing
        if (!validator.checkAll($(this))) {
            submit = false;
        }

        if (submit)
            this.submit();
        return false;
    });

    /* FOR DEMO ONLY */
    $('#vfields').change(function() {
        $('form').toggleClass('mode2');
    }).prop('checked', false);

    $('#alerts').change(function() {
        validator.defaults.alerts = (this.checked) ? false : true;
        if (this.checked)
            $('form .alert').remove();
    }).prop('checked', false);
</script>
</body>
</html>