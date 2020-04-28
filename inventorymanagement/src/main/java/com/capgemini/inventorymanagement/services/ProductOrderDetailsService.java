package com.capgemini.inventorymanagement.services;

import java.util.List;

import com.capgemini.inventorymanagement.entities.ProductOrderDetails;

public interface ProductOrderDetailsService {
	 ProductOrderDetails addProductOrder(ProductOrderDetails p);
	    
	    List<ProductOrderDetails>getAllProductDetails();
	    
	    ProductOrderDetails getProductOrderDetailsById(int order_id);
	    
	    ProductOrderDetails deleteProductOrder(int order_id);
	  
	    ProductOrderDetails updateproductorder(ProductOrderDetails p);
}
