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
	}
	});
	

//function envoyerProduit() {
//	var monProduit = {
//			modele : $('input[name="nom"]').val(),
//			prix: $('input[name="prix"]').val(),
//			fournisseur: {
//				id: $('select[name="fournisseur"]').val()
//			}
//		}
//	
//	$.ajax({
//		method: 'POST',
//		url: 'http://192.168.1.110/formation-html-js/produit',
//		contentType : "application/json",
//		data: JSON.stringify(monProduit),
//		contentType: "application/json",
//
//		success: function(produit) {
//		/* data = les données reçues
//		Si type text/html, alors chaîne de caractères
//		Si type application/json, alors objet littéral
//		*/
//			createRowProduit(produit);
//		}
//		});
//}
//
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