package ru.itis.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.twitter.model.User;
import ru.itis.twitter.repository.UserDao;

import javax.persistence.EntityManager;
import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	EntityManager entityManager;

	@Autowired
	private UserDao dao;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public User findById(long id) {
		return dao.findById(id);
	}

	public User findByLogin(String login) {
		User user = dao.findByLogin(login);
		return user;
	}

	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}

	public void deleteUserByLogin(String login) {
		dao.deleteByLogin(login);
	}

	public List<User> findAllUsers() {
		return dao.findAll();
	}

	public boolean isUserLoginUnique(String login) {
		User user = dao.findByLogin(login);
		return user == null;
	}

	public boolean isUserEmailUnique(String email) {
		User user = dao.findByEmail(email);
		return user == null;
	}

	@Override
	public void updateUser(String email, long id) {
		dao.updateUser(email, id);
	}

}
