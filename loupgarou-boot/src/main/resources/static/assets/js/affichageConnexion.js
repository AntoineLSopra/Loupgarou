/**
 * 
 */

$('form[id="connexion-inscription"] a').bind('click', function() {
	
	let mySelecteurAAfficher = $(this).attr('href');
	$('form[id="connexion"]s').hide();
	$(mySelecteurAAfficher).show(); 
	return false;
})*/


$('div[id="affichageliste"] button').bind('click', function() {

	let mySelecteurAAfficher = $(this).attr('href');
	$(mySelecteurAAfficher).show(); // -> Pareil que $($(this).attr('href')).show();
	return false;
})
