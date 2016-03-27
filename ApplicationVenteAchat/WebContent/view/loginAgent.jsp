<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/loginStyle.css" rel="stylesheet">

<title>Authentification</title>
</head>
<body>
<center>
<div class="container">
	<section id="content">
		<form name="formulaire"  method="post" action="/ApplicationVenteAchat/servletVeriflogin">
			<h1>application de vente</h1>
			<div>
				<input type="text" placeholder="identifiant" required="" name="identifiant" />
			</div>
			<div>
				<input type="password" placeholder="Password" required="" name="motDePasse" />
			</div>
			<div>
				<input type="submit" value="se connecter" />
				<a href="#">Mot de passe oublié?</a>
				
			</div>
		</form><!-- form -->
		<div class="button">
		</div><!-- button -->
	</section><!-- content -->
</div><!-- container -->
        

</center>
</body>
</html>