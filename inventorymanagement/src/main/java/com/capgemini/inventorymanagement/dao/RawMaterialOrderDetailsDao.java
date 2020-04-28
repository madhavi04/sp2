package com.capgemini.inventorymanagement.dao;

import java.util.List;

import com.capgemini.inventorymanagement.entities.RawMaterialOrderDetails;

public interface RawMaterialOrderDetailsDao {

	RawMaterialOrderDetails addRawMaterialOrder(RawMaterialOrderDetails r);

	List<RawMaterialOrderDetails> getAllRawMaterialOrders();

	RawMaterialOrderDetails getRawMaterialOrderDetailById(int order_id);
	
	RawMaterialOrderDetails deleteRawMaterialOrder(int order_id);

	RawMaterialOrderDetails updateRawMaterialOrder(RawMaterialOrderDetails r);


}