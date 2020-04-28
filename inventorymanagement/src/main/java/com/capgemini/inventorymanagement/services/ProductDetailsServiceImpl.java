package com.capgemini.inventorymanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.inventorymanagement.dao.ProductDetailsDaoImpl;
import com.capgemini.inventorymanagement.entities.ProductDetails;
@Service
@Transactional
public class ProductDetailsServiceImpl implements ProductDetailsService {

	@Autowired
	ProductDetailsDaoImpl dao;
	
	
	@Override
	public ProductDetails addProduct(ProductDetails p) {
		// TODO Auto-generated method stub
		return dao.addProduct(p);
	}

	@Override
	public List<ProductDetails> getAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAllProducts();
	}

	@Override
	public ProductDetails getProductDetailsById(int p_id) {
		// TODO Auto-generated method stub
		return dao.getProductDetailsById(p_id);
	}

	@Override
	public ProductDetails deleteProduct(int p_id) {
		// TODO Auto-generated method stub
		return dao.deleteProduct(p_id);
	}

	@Override
	public ProductDetails updateProduct(ProductDetails p) {
		// TODO Auto-generated method stub
		return dao.updateProduct(p);
	}

}
