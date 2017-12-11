package fr.cesi.BasicWebServiceSpring.service.impl;

import fr.cesi.BasicWebServiceSpring.entity.User;
import fr.cesi.BasicWebServiceSpring.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl{

	@Autowired
	private UserDAO userDao;

	public User save(User user) {
		return userDao.save(user);
	}

	public User findByFirstName(String firstname) {
		return userDao.findByFirstName(firstname);
	}
}
