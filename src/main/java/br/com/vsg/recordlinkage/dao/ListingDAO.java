package br.com.vsg.recordlinkage.dao;

import java.util.List;

import br.com.vsg.recordlinkage.entities.Listing;

public interface ListingDAO {

	public void insert(Listing entity);

	public Listing loadListing(Listing listing);

	public void deleteListing(Listing entity);

	public List<Listing> findAllListing();
}
