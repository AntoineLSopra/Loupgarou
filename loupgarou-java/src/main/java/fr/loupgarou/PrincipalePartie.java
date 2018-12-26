package fr.loupgarou;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import fr.loupgarou.dao.sql.DAOPartieSQL;
import fr.loupgarou.idao.sql.IDAOPartie;
import fr.loupgarou.model.*;



public class PrincipalePartie {

	public static void main(String[] args) {
			
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loupgarou");
		EntityManager em = emf.createEntityManager();
		
		
		//	findAll(): AFFICHER PARTIES	
	
			IDAOPartie daoPartie = new DAOPartieSQL(emf);
			
			for (Partie p: daoPartie.findAll()) {
				System.out.println(p.getId());
		
			}
				
				
				
				
				
			em.close();
			emf.close();
		
		
	
			
/////////////////   SQL  /////////////////////		
		
		
//			IDAOPartie daoPartie = new DAOPartieSQL();
//			
//			List<Partie> lesParties = daoPartie.findAll();
//			
//			System.out.println("----  DETAIL DES PARTIES  ----");
//			
//			for (Partie p : lesParties) {
//				System.out.println("ID: " + p.getId());
//				System.out.println("HISTOIRE: " + p.getHistoire());
//				System.out.println("CAPITAINE: " + p.getCapitaine());
//				System.out.println("--------------------------------");
//			}
		
		
		//	findById(): TROUVER PARTIE
			
//			IDAOPartie daoPartie = new DAOPartieSQL();
//			Partie laPartie = daoPartie.findById(1);
//			System.out.println("Histoire: " + laPartie.getHistoire());
//			System.out.println("Capitaine: " + laPartie.getCapitaine());
			
			
			
		//	save(): CREER UNE NOUVELLE PARTIE
			
//			IDAOPartie daoPartie = new DAOPartieSQL();
//	
//			
//			Partie maPartie= new Partie();
//			
//			
//			Histoire story = new Histoire();
//			Joueur capitaine = new Joueur();
//			story.setId(1);
//			capitaine.setId(25);
//			
//			maPartie.setHistoire(story);
//			maPartie.setCapitaine(capitaine);
//			
//			
//			daoPartie.save(maPartie);
			
			
			
		//	save(): MODIFIER UNE PARTIE  
		
//			IDAOPartie daoPartie = new DAOPartieSQL();
//					
//			
//			Joueur capitaine = new Joueur();
//			capitaine.setId(26);
//			
//			Partie xxx = daoPartie.findById(16);
//			
//			xxx.setCapitaine(capitaine);
//			
//			daoPartie.modify(xxx);
			
		
			
			
		//	deleteById(): SUPPRIMER PARTIE
			
//			IDAOPartie daoPartie = new DAOPartieSQL();
//			daoPartie.deleteById(5);
			
			
			
	
	}
	
}
