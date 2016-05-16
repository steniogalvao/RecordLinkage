package br.com.vsg.recordlinkage.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.vsg.recordlinkage.dao.AbstractDAO;
import br.com.vsg.recordlinkage.dao.ProductDAO;
import br.com.vsg.recordlinkage.entities.Product;

@Repository("productDAO")
public class ProductDAOImpl extends AbstractDAO<Integer, Product> implements ProductDAO {

	@Override
	public void insert(Product entity) {
		persist(entity);
	}

	@Override
	public Product load(Product product) {
		return load(product.getId());
	}
	
	@Override
	public Product loadByName(Product product) {
		Criteria criteria = createEntityCriteria();
		return (Product) criteria.add(Restrictions.eq("product_name", product.getProduct_name())).uniqueResult();
	}

	@Override
	public List<Product> findAllProduct() {
		Criteria criteria = createEntityCriteria();
		return (List<Product>) criteria.list();
	}

	public List<Product> byBrand() {
		Criteria criteria = createEntityCriteria();
//		criteria.
		return null;

	}

}
