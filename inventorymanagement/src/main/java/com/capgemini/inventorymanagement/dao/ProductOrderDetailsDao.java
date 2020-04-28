package com.capgemini.inventorymanagement.dao;

import java.util.List;

import com.capgemini.inventorymanagement.entities.ProductOrderDetails;

public interface ProductOrderDetailsDao {
    ProductOrderDetails addProductOrder(ProductOrderDetails p);
    
    List<ProductOrderDetails>getAllProductDetails();
    
    ProductOrderDetails getProductOrderDetailsById(int order_id);
    
    ProductOrderDetails deleteProductOrder(int order_id);
  
    ProductOrderDetails updateproductorder(ProductOrderDetails p);
}
