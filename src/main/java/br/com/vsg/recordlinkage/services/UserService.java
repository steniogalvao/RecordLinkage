package br.com.vsg.recordlinkage.services;

import br.com.vsg.recordlinkage.entities.User;

public interface UserService {

	public void insertUser(User entity);

	public User loadUser(User user);

	public void deleteUser(User entity);

	public boolean checkEmail(User user);

	public boolean login(User user);
	
	public boolean haveUsers();

}