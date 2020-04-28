package com.capgemini.inventorymanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.inventorymanagement.dao.SupplierDetailsDaoImpl;
import com.capgemini.inventorymanagement.entities.SupplierDetails;


@Service
@Transactional

public class SupplierDetailsServiceImpl implements SupplierDetailsService{
	
	@Autowired
	SupplierDetailsDaoImpl dao;
	
	@Override
	public SupplierDetails addSupplier(SupplierDetails s) {
		// TODO Auto-generated method stub
		return dao.addSupplier(s);
	}

	@Override
	public List<SupplierDetails> getAllSuppliers() {
		// TODO Auto-generated method stub
		return dao.getAllSuppliers();
	}

	@Override
	public SupplierDetails deleteSupplier(int s_id) {
		// TODO Auto-generated method stub
		return dao.deleteSupplier(s_id);
	}

	@Override
	public SupplierDetails updateSupplier(SupplierDetails s) {
		// TODO Auto-generated method stub
		return dao.updateSupplier(s);
	}

	@Override
	public SupplierDetails getSupplierById(int s_id) {
		// TODO Auto-generated method stub
		return dao.getSupplierById(s_id);
	}
}
