package br.com.vsg.recordlinkage.entities;

import java.util.ArrayList;
import java.util.List;

public class ListingListSingleton {

	private static List<Listing> list;

	private ListingListSingleton() {
	}

	public synchronized static List<Listing> getInstance() {
		if (list == null)
			list = new ArrayList<Listing>();
		return list;
	}

}
