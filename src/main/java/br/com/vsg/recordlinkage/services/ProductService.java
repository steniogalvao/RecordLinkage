package br.com.vsg.recordlinkage.services;

import java.util.List;

import br.com.vsg.recordlinkage.entities.Product;

public interface ProductService {

	public void insertProduct(Product entity);

	public Product loadProduct(Product product);

	public Product loadProductByName(Product product);

	public void deleteProduct(Product entity);

	public List<Product> findAllProduct();

}
