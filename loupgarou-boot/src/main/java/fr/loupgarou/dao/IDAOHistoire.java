package fr.loupgarou.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.loupgarou.model.Histoire;

public interface IDAOHistoire extends JpaRepository<Histoire, Integer> {

}
