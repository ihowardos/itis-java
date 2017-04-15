package ru.itis.twitter.service;


import ru.itis.twitter.model.User;

import java.util.List;

public interface UserService {
	
	User findById(long id);
	
	User findByLogin(String login);
	
	void saveUser(User user);

	void deleteUserByLogin(String login);

	List<User> findAllUsers(); 
	
	boolean isUserLoginUnique(String login);

	boolean isUserEmailUnique(String email);

	void updateUser(String email, long id);

}