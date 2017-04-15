package ru.itis.twitter.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itis.twitter.model.UserProfile;

import java.util.List;


public interface UserProfileDao extends CrudRepository<UserProfile, Long> {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(long id);
}
