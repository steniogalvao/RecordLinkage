package br.com.vsg.recordlinkage.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="link")
public class Link {

	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	private Product product;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Listing> listings;

	public Link() {

	}

	public Link(Product product, List<Listing> listings) {
		this.product = product;
		this.listings = listings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Listing> getListings() {
		return listings;
	}

	public void setListings(List<Listing> listings) {
		this.listings = listings;
	}

}
