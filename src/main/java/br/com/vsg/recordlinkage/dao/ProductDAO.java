package br.com.vsg.recordlinkage.dao;

import java.util.List;

import br.com.vsg.recordlinkage.entities.Product;

public interface ProductDAO {

	public void insert(Product entity);

	public Product load(Product product);
	
	public Product loadByName(Product product);

	public void delete(Product entity);

	public List<Product> findAllProduct();

	public List<Product> byBrand();

}
