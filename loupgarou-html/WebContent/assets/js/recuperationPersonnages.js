function rafraichir() {
	deleteRowPersonnage();
	$.ajax({
		method: 'GET',
		url: 'http://192.168.1.110/loupgarou-ajax/personnage',
		success: function recupererPersonnages(personnages) {
		/* data = les données reçues
		Si type text/html, alors chaîne de caractères
		Si type application/json, alors objet littéral
		*/
		for (personnage of personnages) {
			createRowPersonnage(personnage);
		}
		$('tr td input[value="Modifier"]').bind('click', function(){
			//je pars du bouton(this) je remonte  la racine (tr) du bouton, je cherche dans la racine(tr) le champe de saisie (input[class="input-field"]) e et je l'affiche
//			$(this).closest('tr').find('input[value="Supprimer"]').hide();
			$(this).closest('tr').find('input[value="Supprimer"]').attr('disabled', false);
			$(this).closest('tr').find('td span').hide();
			$(this).closest('tr').find('input[class="input-field perso"]').show();
			$(this).closest('tr').find('select[class="form-control pouv"]').show();
			$(this).closest('tr').find('input[value="Valider"]').show();
			$(this).closest('tr').find('input[id="cancel"]').show();
			return false;
		});
		$('tr td input[value="Valider"]').bind('click', function(){
			//modifier le Personnage avec l'id de la ligne et le nouveau libellÃ©
			modifierPersonnage($(this).closest('tr').data('id'), $(this).closest('tr').find('input[class="input-field perso"]').val(),
					$(this).closest('tr').find('select[name="newPouv"]').val());
			//cacher des champs
			$(this).closest('tr').find('input[class="input-field perso"]').hide();
			$(this).closest('tr').find('select[class="form-control pouv"]').hide();
			$(this).closest('tr').find('input[value="Valider"]').hide();
			$(this).closest('tr').find('input[value="Supprimer"]').attr('disabled', false);
			$(this).closest('tr').find('td span').show();
			return false;
		});
		$('tr td input[value="Supprimer"]').bind('click', function(){
			supprimerPersonnage($(this).closest('tr').data('id'));
			return false;
		});
		$('tr td input[id="cancel"]').bind('click', function(){
			$(this).closest('tr').find('input[class="input-field perso"]').hide();
			$(this).closest('tr').find('select[class="form-control pouv"]').hide();
			$(this).closest('tr').find('input[value="Valider"]').hide();
//			$(this).closest('tr').find('input[value="Supprimer"]').hide();
			$(this).closest('tr').find('input[value="Supprimer"]').attr('disabled', false);
			$(this).closest('tr').find('td span').show();
			rafraichir();
			return false;
		});
	}
});
}


function createRowPersonnage(personnage) {
	//CREATION DES COLONNES	
	var myColId = $('<td>' + personnage.id + '</td>');
	var myColLibelle = $('<td> <span name="perso">' + personnage.libelle + '</span>'+
			  '<input type="text" class="input-field perso" id="saisieNewNom" name="newNom" value=""' + personnage.libelle + '" required/><br />  '+
			  '<input class="btn btn-sucess" type="submit" id="Valider" value="Valider"/> ' + 
			  '<input class="btn btn-sucess" type="submit" id="cancel" value="Annuler" /></td>');

	var myColPouvoir = ('<td>' +'<span name="pouv">' + personnage.pouvoir.libelle + '</span>' + '<select class="form-control pouv" name="newPouv"><option value="1" ' + ( (personnage.pouvoir.id == 1) ? "selected" : "" ) + '>Loup</option>' +
			'<option value="2" ' + ( (personnage.pouvoir.id == 2) ? "selected" : "" ) + '>Villageois</option></select> </td>');
	var myColButton = $('<td> <input class="btn btn-sucess" type="submit" value="Modifier"/>'+
						' <input class="btn btn-sucess" type="submit" value="Supprimer"/> </td>');

	//CREATION DE LA LIGNE
	var myLigne = $('<tr data-id = "' + personnage.id + '"/>');
	
	
	//ASSOCIER LES COLONNES A LA LIGNE
	myLigne.append(myColId);
	myLigne.append(myColLibelle);
	myLigne.append(myColPouvoir);
	myLigne.append(myColButton);
	
	//INSERER LA LIGNE AU TABLEAU
	$('table tbody').append(myLigne);
}


function deleteRowPersonnage() {
	$('table tbody td').remove();
}
	

function envoyerPersonnage() {
	var monPersonnage = {
			libelle : $('input[name="addPersonnage"]').val(),
			pouvoir: {
				id: $('select[name="addPouvoir"]').val()
			}
			}

	$.ajax({
		method: 'POST',
		url: 'http://192.168.1.110/loupgarou-ajax/personnage',
		contentType : "application/json",
		data: JSON.stringify(monPersonnage),

		success: function(personnage) {
		/* data = les données reçues
		Si type text/html, alors chaîne de caractères
		Si type application/json, alors objet littéral
		*/
			createRowPersonnage(personnage);
			rafraichir();
		}
		});
}

function modifierPersonnage(id, libelle, pouvId){
	var monPersonnage = {
		id: id,
		libelle : libelle,
		pouvoir: {
			id: pouvId
		}
		}
	//REQUETE AJAX POUR AJOUTER LE PRODUIT
	$.ajax({
		method : 'PUT',
		url : 'http://192.168.1.110/loupgarou-ajax/personnage/' + monPersonnage.id,
		data : JSON.stringify(monPersonnage),	//CONVERTIR L'OBJET JS EN JSON
		contentType : 'application/json',	//DE QUOI EST FAIT LE FLUX
		success : function(personnage) {		//LA REPONSE DU SERVEUR
			rafraichir();
		}
	});
}

function supprimerPersonnage(id){
	var monPersonnage = {
			id: id,
	}
	//REQUETE AJAX POUR AJOUTER LE PRODUIT
	$.ajax({
		method : 'DELETE',
		url : 'http://192.168.1.110/loupgarou-ajax/personnage/' + monPersonnage.id,
		success : function(personnage) {		//LA REPONSE DU SERVEUR
			rafraichir();
		}
	});
}

rafraichir();



//function createListeDeroulantePersonnage(personnage){
//	//CREATION DES LIGNES
//	var myId = $('<option value="'+ personnage.id + '">' + personnage.libelle + '</option>');
//	
//	//INSERER LA LIGNE AU TABLEAU
//	$('select[class="form-control perso"]').append(myId);
//}

//var eventSource = new EventSource("http://192.168.1.110/formation-html-js/produit/listen-new")
//
////2 fonctions utiles : 
//// onmessage -> qui se déclenche quand un message est reçu du serveur
////close -> fermer la connexion
//
//eventSource.onmessage = function(evt) {
////	evt.data -> la donnée reçue du serveur
//	var monProduitRecuDuServeur = JSON.parse(evt.data);
//	createRowProduit(monProduitRecuDuServeur);
//}