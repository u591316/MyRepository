

function validateForm(){

	let password = document.getElementById("pass").nodeValue;
	let pass_rep = document.getElementById("passrep").nodeValue; 
	let username = document.getElementById("username").nodeValue; 
	let lastname = document.getElementById("lastname").nodeValue; 
	let phone = document.getElementById("phone").nodeValue; 

	var x = 0; 
	

	if(password != pass_rep){

		password.setAttribute('title', "Passordene må være like");
		 
		pass_rep.setAttribute('title', "Passordene må være like");
		 
		document.getElementById("error").innerHTML = "Passordene matcher ikke"; 
		
		++x;
		
		 
	}if(phone.length < 8 || phone.length > 8){

		document.getElementById("error_phone").innerHTML = "MobNr må være 8-siffer";

		++x; 

	}if(username.length <2 || username.length > 22){

		document.getElementById("error_username").innerHTML="Navn må inneholde minst 2 og maks 22 bokstaver"; 

		++x; 
		 
	}if(lastame.length<2 || lastname.length > 22){

		document.getElementById("error_lastname").innerHTML="Navn må inneholde minst 2 og maks 22 bokstaver";
		++x;  
		
	}if(x>0){
		
		return false; 
	}
		
		return false; 
	
}
	


