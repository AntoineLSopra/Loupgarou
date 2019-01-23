/**
 * 
 */

$('form[id="connexion-inscription"] a').bind('click', function() {
//	alert("A MALIBU");
//	this -> lien cliqué
//	alert($(this).attr('href'));
	
	let mySelecteurAAfficher = $(this).attr('href');
	$('section').hide();
	$(mySelecteurAAfficher).show(); // -> Pareil que $($(this).attr('href')).show();
	return false;
})
