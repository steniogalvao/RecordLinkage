package br.com.vsg.recordlinkage.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import br.com.vsg.recordlinkage.entities.Listing;
import br.com.vsg.recordlinkage.entities.Product;

/**
 * @author steniogalvao
 * 
 *         Thread created to process the record linkage, for each product it
 *         search in a listing if the model of the product is present using
 *         Ngram distance
 * 
 */
public class ThreadWord implements Runnable {

	private Map<String, List<Listing>> listingMap;
	private Entry<String, List<Product>> brandGroup;
	Map<Product, List<Listing>> result = new HashMap<>();;

	/**
	 * Constructor
	 * 
	 * @param listingMap
	 *            Map of listing using the brand as key
	 * @param brandGroup
	 *            Map of products using the brand as key
	 */
	public ThreadWord(Map<String, List<Listing>> listingMap, Entry<String, List<Product>> brandGroup) {
		this.listingMap = listingMap;
		this.brandGroup = brandGroup;
	}

	@Override
	public void run() {
		for (Entry<String, List<Listing>> listingGroup : listingMap.entrySet()) {
			if (utils.searchWord(brandGroup.getKey(), listingGroup.getKey(), 1)) {
				for (Product p : brandGroup.getValue()) {
					List<Listing> linkedListing = new ArrayList<>();
					for (Listing l : listingGroup.getValue()) {
						if (utils.searchWord(p.getModel(), l.getTitle(), 2)) {
							linkedListing.add(l);
						}
					}
					if (linkedListing.size() != 0) {
						MapLinkSingleton.getInstance().put(p, linkedListing);
					}
				}
			}
		}
	}

	public Map<Product, List<Listing>> getResult() {
		return result;
	}
}
