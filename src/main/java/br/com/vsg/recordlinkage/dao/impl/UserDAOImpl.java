package br.com.vsg.recordlinkage.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.vsg.recordlinkage.dao.AbstractDAO;
import br.com.vsg.recordlinkage.dao.UserDAO;
import br.com.vsg.recordlinkage.entities.User;

@Repository("userDAO")
public class UserDAOImpl extends AbstractDAO<Integer, User> implements UserDAO {

	@Override
	public void insert(User entity) {
		persist(entity);

	}

	@Override
	public User load(User user) {
		return load(user.getId());
	}

	@Override
	public void deleteUser(User user) {
		delete(user);
	}

	public boolean checkEmail(User user) {
		Criteria criteria = createEntityCriteria();
		User u = (User) criteria.add(Restrictions.eq("email", user.getEmail())).uniqueResult();
		if (u == null) {
			return false;
		}
		return true;
	}

	public boolean login(User user) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("password", user.getPassword()));
		User u = (User) criteria.add(Restrictions.eq("email", user.getEmail())).uniqueResult();
		if (u == null) {
			return false;
		}
		return true;
	}

	public boolean haveUsers() {
		Criteria criteria = createEntityCriteria();
		List<User> users = criteria.list();
		if (users == null || users.isEmpty()) {
			return false;
		}
		return true;
	}

}
