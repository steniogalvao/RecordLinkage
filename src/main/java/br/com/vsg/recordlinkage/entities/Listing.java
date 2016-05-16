package br.com.vsg.recordlinkage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "listing")
public class Listing {

	@Id
	@GeneratedValue
	private int id;
	@Column(name = "title", length = 1000, nullable = false)
	private String title;
	@Column(name = "manufacturer", nullable = false)
	private String manufacturer;
	@Column(name = "currency", nullable = false)
	private String currency;
	@Column(name = "price", nullable = false)
	private Double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
