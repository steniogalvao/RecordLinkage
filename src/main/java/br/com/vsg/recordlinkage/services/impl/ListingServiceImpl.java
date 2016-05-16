package br.com.vsg.recordlinkage.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vsg.recordlinkage.dao.ListingDAO;
import br.com.vsg.recordlinkage.entities.Listing;
import br.com.vsg.recordlinkage.services.ListingService;

@Service("listingService")
@Transactional
public class ListingServiceImpl implements ListingService {

	@Autowired
	private ListingDAO dao;

	public Listing loadListing(Listing listing) {
		return dao.loadListing(listing);
	}

	public void insertListing(Listing listing) {
		dao.insert(listing);
	}

	public List<Listing> findAllListing() {
		return dao.findAllListing();
	}

	public void deleteListing(Listing listing) {
		dao.deleteListing(listing);
	}

}