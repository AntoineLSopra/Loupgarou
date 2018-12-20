package fr.loupgarou.idao.sql;

import java.util.List;

import fr.loupgarou.model.Partie;
import fr.loupgarou.model.Personnage;


public interface IDAO<T> {

	
	public List<T> findAll();
	public T findById(int id);
	public T save(T entity);
	public void delete(T entity);
	public void deleteById(int id);
	
}
