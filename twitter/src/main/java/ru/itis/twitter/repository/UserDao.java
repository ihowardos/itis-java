package ru.itis.twitter.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.twitter.model.User;

import java.util.Date;
import java.util.List;


public interface UserDao extends CrudRepository<User, Long> {

	User findById(long id);
	
	User findByLogin(String login);

	User findByEmail(String email);
	
	void deleteByLogin(String login);

	List<User> findAll();

	@Modifying
	@Transactional(readOnly = false)
	@Query("UPDATE User u SET u.email = ?1 where u.id = ?2")
	void updateUser(String email, long id);
}

