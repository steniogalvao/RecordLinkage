package br.com.vsg.recordlinkage.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import br.com.vsg.recordlinkage.dao.AbstractDAO;
import br.com.vsg.recordlinkage.dao.ListingDAO;
import br.com.vsg.recordlinkage.entities.Listing;

@Repository("listingDAO")
public class ListingDAOImpl extends AbstractDAO<Integer, Listing> implements ListingDAO {

	@Override
	public void insert(Listing entity) {
		persist(entity);
	}

	@Override
	public Listing loadListing(Listing listing) {
		return load(listing.getId());
	}

	@Override
	public void deleteListing(Listing entity) {
		delete(entity);

	}

	@Override
	public List<Listing> findAllListing() {
		Criteria criteria = createEntityCriteria();
		return (List<Listing>) criteria.list();
	}

}
