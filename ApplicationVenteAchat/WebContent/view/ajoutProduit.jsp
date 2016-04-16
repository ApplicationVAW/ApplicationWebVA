<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ajouter Produit</title>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/view/css/menu.css" rel="stylesheet">




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
           
             

<% int t = 0 ;
 
 try{
	 int res = (int)request.getAttribute("res");
	// int rest = Integer.parseInt(res);
	 if(res==1){
		 //client ajouté
		 %>
		 
		 <script type="text/javascript">

		 $(document).ready(function () {
			    $.growl({
			        message: 'le nouveau produit a été ajouté avec succée',
			     
			    }, {
			    	type: 'success',
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
	 else{
		 // client non ajouté
		 %>
		 <script type="text/javascript">

		 $(document).ready(function () {
			    $.growl({
			    	icon: 'glyphicon glyphicon-warning-sign',
			        message: 'le client existe deja !! verifier les données saisies',
			      
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
 } catch(Exception e){
	 %>
	 
	 
	 <% 
 }
%>


<div class="nav-side-menu">
    <div class="brand">Nom du societé</div>
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
                <li class="#"><a href="#">Ajouter commande</a></li>
                <li><a href="#">Modifier commande</a></li>
                <li><a href="#">Supprimer commande</a></li>
                <li><a href="#">Chercher commande</a></li>
                <li><a href="#">Afficher tous commande</a></li>
            </ul>

            <li data-toggle="collapse" data-target="#produit" class="collapsed active">
                <a href="#"><i class="fa fa-globe fa-lg"></i> Produit <span class="arrow"></span></a>
            </li>
            <ul class="sub-menu" id="produit">
                <li class="active"><a href="${pageContext.request.contextPath}/view/ajoutProduit.jsp">Ajouter produit</a></li>
                <li><a href="${pageContext.request.contextPath}/view/ModifProduit.jsp">Modifier produit</a></li>
                <li><a href="${pageContext.request.contextPath}/view/SupprProduit.jsp">Supprimer produit</a></li>
                <li><a href="#">chercher produits</a></li>
                <li><a href="${pageContext.request.contextPath}/view/listeProduit.jsp">Afficher Produits</a></li>
            </ul>


            <li data-toggle="collapse" data-target="#service" class="collapsed">
                <a href="#"><i class="fa fa-users fa-lg"></i> Client <span class="arrow"></span></a>
            </li>
            <ul class="sub-menu collapse" id="service">
                <li ><a href="#">Ajouter client</a></li>
                <li><a href="${pageContext.request.contextPath}/view/SupprClient.jsp">Supprimer client</a></li>
                <li><a href="${pageContext.request.contextPath}/view/ModifClient.jsp">Modifier client</a></li>
                <li><a href="#">Chercher client</a></li>
            </ul>


            <li data-toggle="collapse" data-target="#new" class="collapsed">
                <a href="#"><i class="fa fa-car fa-lg"></i> Capegories <span class="arrow"></span></a>
            </li>
            <ul class="sub-menu collapse" id="new">
                <li><a href="#">Ajouter catégorie</a></li>
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
                    <i class="fa fa-globe fa-lg"></i> Users
                </a>
            </li>
        </ul>
    </div>
</div>


<!-- hedhi hia ell partie elli dima tetbaddel -->



<div class="partieDroite">
    <div id="menu">
        <ul>
            <li><a class="current" href="home.html" title="fermer"></a></li>
        </ul>
    </div>






        <div class="x_panel">
            <div class="x_title">
                <h2>Information du nouveau produit </h2>
                <ul class="nav navbar-right panel_toolbox">
                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                    </li>

                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
            
            <!-- formulaire -->
            
            <div class="x_content">

                <form class="form-horizontal form-label-left" novalidate="" method="post"  action="/ApplicationVenteAchat/AjouterProduit">


                    <span class="section"><br></span>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="ville">Nom <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="name" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="1" name="nom"  required="required" type="text">
                        </div>
                    </div>
                   
                   
                   
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">Quantité en stoque <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="number" id="number" name="qte" required="required" data-validate-minmax="1,99999999" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>



                    
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">Description : <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="textarea" required="required" name="description" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    
                     <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">Categorie : <span class="required">*</span>
                        </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <select class="form-control" name="categorie">
                    
                    <%@ page import="categorie.Categorie, java.util.*" %>
                    <% Categorie cat = new Categorie(); 
                       List<Categorie> liste = cat.getAllCategorie();
                       for(Categorie cc:liste){
                    	   %>
                     <option value="<%= (Long)cc.getCodeCategorie() %>"><%= (String)cc.getNom() %></option>
                       <% } %>
                    </select>
                    </div>
                    </div>
                  

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">Prix:  <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="number" id="codePostale" name="prix" required="required" data-validate-minmax="1,9999" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                            <button type="reset" class="btn btn-primary">Annuler</button>
                            <button id="send" type="submit" class="btn btn-success">enregistrer</button>
                        </div>
                    </div>
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