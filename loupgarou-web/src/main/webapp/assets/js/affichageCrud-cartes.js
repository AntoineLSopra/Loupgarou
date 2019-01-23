/**
 * 
 */

$('div a').bind('click', function() {
//	alert("A MALIBU");
//	this -> lien cliqué
//	alert($(this).attr('href'));
	
	let mySelecteurAAfficher = $(this).attr('href');
	$('section').hide();
	$('section[id = "menu"]').show();
	$(mySelecteurAAfficher).show(); // -> Pareil que $($(this).attr('href')).show();
	return false;
})
