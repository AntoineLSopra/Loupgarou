function createRowPersonnage(personnage) {
	//CREATION DES COLONNES	
	var myColId = $('<td />');
	var myColLibelle = $('<td>'+ personnage.libelle + '</td>');
	var myColPouvoir = $('<td />');
	
	//AFFECTER LES VALEURS AUX COLONNES
	myColId.html(personnage.id);
//	myColNom.html(monProduit.nom);
	myColPouvoir.html(personnage.pouvoir.libelle);

	//CREATION DE LA LIGNE
	var myLigne = $('<tr />');
	
	
	//ASSOCIER LES COLONNES A LA LIGNE
	myLigne.append(myColId);
	myLigne.append(myColLibelle);
	myLigne.append(myColPouvoir);
	
	
	//INSERER LA LIGNE AU TABLEAU
	$('table tbody').append(myLigne);
}

function createListeDeroulantePersonnage(personnage){
	//CREATION DES LIGNES
	var myId = $('<option value="'+ personnage.id + '">' + personnage.libelle + '</option>');
	
	//INSERER LA LIGNE AU TABLEAU
	$('select[class="form-control perso"]').append(myId);
}

function deleteRowPersonnage() {
	$('table tbody td').remove();
}

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
			createListeDeroulantePersonnage(personnage);
		}
		}
		});
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
			rafraichir;
		}
		});
}

function modifierPersonnage(){
	var monPersonnage = {
		id: $('select[name="nomPersonnage"]').val(),
		libelle : $('input[name="newNom"]').val(),
		pouvoir: {
			id: $('select[name="pouvoir"]').val()
		}
	};
	//REQUETE AJAX POUR AJOUTER LE PRODUIT
	$.ajax({
		method : 'POST',
		url : 'http://192.168.1.110/loupgarou-ajax/personnage',
		data : JSON.stringify(monPersonnage),	//CONVERTIR L'OBJET JS EN JSON
		contentType : 'application/json',	//DE QUOI EST FAIT LE FLUX
		success : function(personnage) {		//LA REPONSE DU SERVEUR
			rafraichir();
		}
	});
}

function supprimerPersonnage(){
	var monPersonnage = {
		id: $('select[name="nomPersonnageSupp"]').val()
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