package br.com.vsg.recordlinkage.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import br.com.vsg.recordlinkage.dao.AbstractDAO;
import br.com.vsg.recordlinkage.dao.LinkDAO;
import br.com.vsg.recordlinkage.entities.Link;

@Repository("linkDAO")
public class linkDAOImpl extends AbstractDAO<Integer, Link> implements LinkDAO {

	@Override
	public Link load(Link link) {
		return load(link.getId());
	}

	@Override
	public void save(Link link) {
		persist(link);

	}

	@Override
	public void deleteLink(Link link) {
		delete(link);
	}

	@Override
	public List<Link> findAllLink() {
		Criteria criteria = createEntityCriteria();
		return (List<Link>) criteria.list();
	}

}
