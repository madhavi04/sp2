package com.capgemini.inventorymanagement.services;

import java.util.List;

import com.capgemini.inventorymanagement.entities.RawMaterialOrderDetails;

public interface RawMaterialOrderDetailsService 
{
	RawMaterialOrderDetails addRawMaterialOrder(RawMaterialOrderDetails r);

	List<RawMaterialOrderDetails> getAllRawMaterialOrders();

	RawMaterialOrderDetails getRawMaterialOrderDetailById(int order_id);
	
	RawMaterialOrderDetails deleteRawMaterialOrder(int order_id);

	RawMaterialOrderDetails updateRawMaterialOrder(RawMaterialOrderDetails r);

}
