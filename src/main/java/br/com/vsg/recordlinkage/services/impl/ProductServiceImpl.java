package br.com.vsg.recordlinkage.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vsg.recordlinkage.dao.ProductDAO;
import br.com.vsg.recordlinkage.entities.Product;
import br.com.vsg.recordlinkage.services.ProductService;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO dao;

	public Product loadProduct(Product product) {
		return dao.load(product);
	}

	@Override
	public Product loadProductByName(Product product) {
		return dao.loadByName(product);
	}

	public void insertProduct(Product product) {
		dao.insert(product);
	}

	public List<Product> findAllProduct() {
		return dao.findAllProduct();
	}

	public void deleteProduct(Product product) {
		dao.delete(product);
	}

}