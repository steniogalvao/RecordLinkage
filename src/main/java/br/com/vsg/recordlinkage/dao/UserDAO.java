package br.com.vsg.recordlinkage.dao;

import br.com.vsg.recordlinkage.entities.User;

public interface UserDAO {

	public void insert(User entity);

	public User load(User user);

	public void deleteUser(User entity);
	
	public boolean checkEmail(User user);

	public boolean login(User user);
	
	public boolean haveUsers();

}
