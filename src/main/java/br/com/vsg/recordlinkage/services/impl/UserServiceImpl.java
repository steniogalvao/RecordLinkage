package br.com.vsg.recordlinkage.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vsg.recordlinkage.dao.UserDAO;
import br.com.vsg.recordlinkage.entities.User;
import br.com.vsg.recordlinkage.services.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	public User loadUser(User user) {
		return dao.load(user);
	}

	public void insertUser(User user) {
		dao.insert(user);
	}

	public void deleteUser(User user) {
		dao.deleteUser(user);
	}
	
	public boolean checkEmail(User user) {
		return dao.checkEmail(user);
	}
	
	public boolean login(User user) {
		return dao.login(user);
	}
	
	public boolean haveUsers() {
		return dao.haveUsers();
	}

}