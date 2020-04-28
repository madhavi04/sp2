package com.capgemini.inventorymanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.inventorymanagement.dao.RawMaterialOrderDetailsDaoImpl;
import com.capgemini.inventorymanagement.entities.RawMaterialOrderDetails;

@Service
@Transactional
public class RawMaterialOrderDetailsServiceImpl implements RawMaterialOrderDetailsService {

	@Autowired
	RawMaterialOrderDetailsDaoImpl dao;
	
	@Override
	public RawMaterialOrderDetails addRawMaterialOrder(RawMaterialOrderDetails r) {
		// TODO Auto-generated method stub
		return dao.addRawMaterialOrder(r);
	}

	@Override
	public List<RawMaterialOrderDetails> getAllRawMaterialOrders() {
		// TODO Auto-generated method stub
		return dao.getAllRawMaterialOrders();
	}

	@Override
	public RawMaterialOrderDetails getRawMaterialOrderDetailById(int order_id) {
		// TODO Auto-generated method stub
		return dao.getRawMaterialOrderDetailById(order_id);
	}

	@Override
	public RawMaterialOrderDetails deleteRawMaterialOrder(int order_id) {
		// TODO Auto-generated method stub
		return dao.deleteRawMaterialOrder(order_id);
	}

	@Override
	public RawMaterialOrderDetails updateRawMaterialOrder(RawMaterialOrderDetails r) {
		// TODO Auto-generated method stub
		return dao.updateRawMaterialOrder(r);
	}
}
	