package ru.itis.twitter.service;


import ru.itis.twitter.model.UserProfile;

import java.util.List;

public interface UserProfileService {

	UserProfile findById(long id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
