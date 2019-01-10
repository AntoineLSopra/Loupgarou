package fr.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.loupgarou.datajpa.IDAOUtilisateur;
import fr.loupgarou.datajpa.JPAConfig;
import fr.loupgarou.model.Joueur;
import fr.loupgarou.model.Utilisateur;



	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(classes={JPAConfig.class })
	public class IDAOUtilisateurTest {

		@Autowired(required = false)
		private IDAOUtilisateur dao;
		
		@Test
		public void doesExist() 
		{
			assertNotNull("Le bean existe", dao);
		}
		
		
		@Test
		public void getUtilisateur() 
		{
			Utilisateur myOptionalUtilisateur = dao.connexionAdministrateur("Jerem","0000");
				
			assertNotNull("Utilisateur trouvé mais résultat nul", myOptionalUtilisateur);
			assertNotNull("Utilisateur trouvé mais infos non remontées", myOptionalUtilisateur.getNom());
		}
	
		
		

}


