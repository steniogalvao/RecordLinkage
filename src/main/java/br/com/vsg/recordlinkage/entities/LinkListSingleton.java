package br.com.vsg.recordlinkage.entities;

import java.util.ArrayList;
import java.util.List;

public class LinkListSingleton {

	private static List<Link> list;

	private LinkListSingleton() {
	}

	public static List<Link> getInstance() {
		if (list == null)
			list = new ArrayList<Link>();
		return list;
	}

}
