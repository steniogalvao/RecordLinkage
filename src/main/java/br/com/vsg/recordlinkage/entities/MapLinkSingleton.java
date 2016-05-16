package br.com.vsg.recordlinkage.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapLinkSingleton {

	private static Map<Product, List<Listing>> map;

	private MapLinkSingleton() {
	}

	public synchronized static Map<Product, List<Listing>> getInstance() {
		if (map == null)
			map = new HashMap<>();
		return map;
	}

}
