package br.com.vsg.recordlinkage.controllers;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.vsg.recordlinkage.entities.Link;
import br.com.vsg.recordlinkage.entities.Listing;
import br.com.vsg.recordlinkage.entities.Product;
import br.com.vsg.recordlinkage.services.LinkService;
import br.com.vsg.recordlinkage.services.ListingService;
import br.com.vsg.recordlinkage.services.ProductService;
import br.com.vsg.recordlinkage.utils.ThreadPool;
import br.com.vsg.recordlinkage.utils.utils;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	LinkService linkService;

	@Autowired
	ProductService productService;

	@Autowired
	ListingService listingService;

	@Autowired
	MessageSource messageSource;

	private List<Object> objectList;
	private File productFile = new File("/home/steniogalvao/products.txt");
	private File listingFile = new File("/home/steniogalvao/listings.txt");
	private Map<Product, List<Listing>> linkMap;
	private List<Link> links = new ArrayList<>();

	@RequestMapping(value = { "/", "/process" }, method = RequestMethod.GET)
	public String init(ModelMap model) {
		return "main";
	}

	/** Method responsable to show the items related to some product **/
	@RequestMapping(value = { "/show-{productName}-prices" }, method = RequestMethod.GET)
	public String showPrices(@PathVariable String productName, ModelMap model) {
		Link l = new Link();
		for (Entry<Product, List<Listing>> map : linkMap.entrySet()) {
			if (map.getKey().getProduct_name().equals(productName)) {
				l = new Link(map.getKey(), map.getValue());
				break;
			}

		}
		model.addAttribute("link", l);
		return "productPrices";
	}

	/** Method responsable to start the process of record linkage **/
	@RequestMapping(value = { "/startProcess" }, method = RequestMethod.GET)
	public String startProcess(ModelMap model) {
		Long start = System.currentTimeMillis();
		int productSize = 0, listingSize = 0;
		try {

			objectList = utils.readFile(productFile, Product.class);
			productSize = objectList.size();
			ProductListSingleton.getInstance().clear();
			ProductListSingleton.getInstance().addAll((List<Product>) (Object) objectList);
			Map<String, List<Object>> resultMap = utils.makeBlocks(objectList, "manufacturer");

			/** Converting generic map into a product map **/
			Map<String, List<Product>> mapProduct = new HashMap<String, List<Product>>();
			for (Entry<String, List<Object>> map : resultMap.entrySet()) {
				List<Object> objects = map.getValue();
				List<Product> products = new ArrayList<>();
				for (Object object : objects) {
					Product p = (Product) object;
					DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
					String string1 = p.getAnnounced_date();
					Date result1 = df1.parse(string1);

					p.setAnnounced_date(df1.format(result1));
					products.add(p);
				}
				mapProduct.put(map.getKey(), products);
			}

			objectList = utils.readFile(listingFile, Listing.class);
			listingSize = objectList.size();
			ListingListSingleton.getInstance().clear();
			ListingListSingleton.getInstance().addAll((List<Listing>) (Object) objectList);

			/** Converting generic map into a listing map **/
			resultMap = utils.makeBlocks(objectList, "manufacturer");
			Map<String, List<Listing>> mapListing = new HashMap<String, List<Listing>>();
			for (Entry<String, List<Object>> map : resultMap.entrySet()) {
				List<Object> objects = map.getValue();
				List<Listing> listings = new ArrayList<>();
				for (Object object : objects) {
					Listing l = (Listing) object;
					listings.add(l);
				}
				mapListing.put(map.getKey(), listings);
			}

			linkMap = makeRecordLinkage(mapProduct, mapListing);
			linkMap.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Entry<Product, List<Listing>> map : linkMap.entrySet()) {
			Link l = new Link(map.getKey(), map.getValue());
			links.add(l);
		}
		LinkListSingleton.getInstance().addAll(links);
		int productsOut = productSize - links.size();
		float executionTime = (System.currentTimeMillis() - start) / 1000;

		/** Informations to the page **/
		model.addAttribute("links", links);
		model.addAttribute("executionTime", executionTime);
		model.addAttribute("productsSize", productSize);
		model.addAttribute("listingSize", listingSize);
		model.addAttribute("productsOut", productsOut);
		return "main";
	}

	@RequestMapping(value = {}, method = RequestMethod.GET)
	public String refresh(ModelMap model) {
		model.addAttribute("links", links);
		return "main";
	}

	/**
	 * @author steniogalvao This method is responsable to create the link
	 *         between the products and their information in the list
	 * @param productMap
	 *            A map using the brand name as key and a list of products of
	 *            the brand as value
	 * @param listingMap
	 *            A map using the brand name as key and a list of 'listings' of
	 *            the brand as value
	 * @return Returns a map using the Product(object) as key and the list of
	 *         'listing' linked to the product as value
	 **/
	public Map<Product, List<Listing>> makeRecordLinkage(Map<String, List<Product>> productMap,
			Map<String, List<Listing>> listingMap) {

		Map<Product, List<Listing>> link = new HashMap<>();
		List<Map<String, List<Listing>>> listOfListingsMap = new ArrayList<>();
		List<Entry<String, List<Product>>> listOfBrandsMap = new ArrayList<>();
		for (Entry<String, List<Product>> brandGroup : productMap.entrySet()) {
			listOfListingsMap.add(listingMap);
			listOfBrandsMap.add(brandGroup);
		}
		ThreadPool.main(listOfListingsMap, listOfBrandsMap);
		/**
		 * I use this to wait the thread(s) finish their jobs to avoid show
		 * incomplet linkage to user
		 **/
		while (!ThreadPool.getFinish()) {
		}
		link = MapLinkSingleton.getInstance();
		return link;
	}

	@RequestMapping(value = { "/saveProducts" }, method = RequestMethod.GET)
	public String saveProducts(ModelMap model) {
		for (Product p : ProductListSingleton.getInstance()) {
			productService.insertProduct(p);
		}
		return "main";
	}

	@RequestMapping(value = { "/saveListing" }, method = RequestMethod.GET)
	public String saveListing(ModelMap model) {
		for (Listing l : ListingListSingleton.getInstance()) {
			listingService.insertListing(l);
		}
		return "main";
	}
	@RequestMapping(value = { "/saveLinks" }, method = RequestMethod.GET)
	public String saveLinks(ModelMap model) {
		for (Link l : LinkListSingleton.getInstance()) {
			linkService.saveLink(l);
		}
		return "main";
	}

}