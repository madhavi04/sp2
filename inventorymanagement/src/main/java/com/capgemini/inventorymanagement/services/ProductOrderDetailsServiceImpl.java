package com.capgemini.inventorymanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.inventorymanagement.dao.ProductOrderDetailsDaoImpl;
import com.capgemini.inventorymanagement.entities.ProductOrderDetails;

@Service
@Transactional
public class ProductOrderDetailsServiceImpl implements ProductOrderDetailsService {

	@Autowired
	ProductOrderDetailsDaoImpl dao;
	
	@Override
	public ProductOrderDetails addProductOrder(ProductOrderDetails p) {
		// TODO Auto-generated method stub
		return dao.addProductOrder(p);
	}

	@Override
	public List<ProductOrderDetails> getAllProductDetails() {
		// TODO Auto-generated method stub
		return dao.getAllProductDetails();
	}

	@Override
	public ProductOrderDetails getProductOrderDetailsById(int order_id) {
		// TODO Auto-generated method stub
		return dao.getProductOrderDetailsById(order_id);
	}

	@Override
	public ProductOrderDetails deleteProductOrder(int order_id) {
		// TODO Auto-generated method stub
		return dao.deleteProductOrder(order_id);
	}

	@Override
	public ProductOrderDetails updateproductorder(ProductOrderDetails p) {
		// TODO Auto-generated method stub
		return dao.updateproductorder(p);
	}

}
