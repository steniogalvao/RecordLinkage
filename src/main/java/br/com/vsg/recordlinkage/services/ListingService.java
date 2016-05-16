package br.com.vsg.recordlinkage.services;

import java.util.List;

import br.com.vsg.recordlinkage.entities.Listing;

public interface ListingService {
	
	public void insertListing(Listing entity);

	public Listing loadListing(Listing listing);

	public void deleteListing(Listing entity);

	public List<Listing> findAllListing();

}
