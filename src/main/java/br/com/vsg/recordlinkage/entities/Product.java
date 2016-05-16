package br.com.vsg.recordlinkage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "product")
public class Product {

	// ID
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	@Column(name = "product_name", nullable = false, unique = true)
	private String product_name;

	@Column(name = "manufacturer", nullable = false)
	private String manufacturer;

	// optional
	@Column(name = "family")
	private String family;

	@Column(name = "model", nullable = false)
	private String model;

	@SerializedName("announced-date")
	@Column(name = "announced_date", nullable = false)
	private String announced_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String productName) {
		this.product_name = productName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAnnounced_date() {
		return announced_date;
	}

	public void setAnnounced_date(String announced_date) {
		this.announced_date = announced_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product_name == null) ? 0 : product_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		return true;
	}

}
