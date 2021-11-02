<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Påmelding</title>
<script src="Validation.js"></script>
</head>

<body>
	<h2>Påmelding</h2>
	


	<form method="post" class="pure-form pure-form-aligned" onsubmit="return validateForm()">
	
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input type="text"
				required pattern="\s*\p{Lu}\p{Ll}+\s*"
					name="fornavn"  id="username" /><span id="error_username"></span> 
				
					
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input type="text"
				required pattern="\s*\p{Lu}\p{Ll}+\s*"
					name="etternavn"  id="lastname" /><span id="error_lastname"></span> 
					
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input type="text"
				required pattern="\d{8,10}"
					name="mobil"  id="phone" /><span id="error_phone"></span> 
					
				
			</div>
			
			<div class="pure-control-group">
				<label for="password">Passord:</label> <input type="password"
					name="passord"  id="pass" title=""/><span id="error"></span>
			
				
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input
					type="password" name="passordRepetert"
					 id="passrep" title=""/> 
				
				
				
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn"
					value="mann"
					 />mann
				<input type="radio" name="kjonn" value="kvinne"
					 />kvinne
				
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
		</fieldset>
	</form>
</body>

</html>