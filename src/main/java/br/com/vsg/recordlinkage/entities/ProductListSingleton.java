package br.com.vsg.recordlinkage.entities;

import java.util.ArrayList;
import java.util.List;

public class ProductListSingleton {

	private static List<Product> list;

	private ProductListSingleton() {
	}

	public synchronized static List<Product> getInstance() {
		if (list == null)
			list = new ArrayList<Product>();
		return list;
	}

}
