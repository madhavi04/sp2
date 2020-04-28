package com.capgemini.inventorymanagement.services;

import java.util.List;

import com.capgemini.inventorymanagement.entities.SupplierDetails;

public interface SupplierDetailsService {

	SupplierDetails addSupplier(SupplierDetails s);

	SupplierDetails getSupplierById(int s_id);
	
	List<SupplierDetails> getAllSuppliers();

	SupplierDetails deleteSupplier(int s_id);

	SupplierDetails updateSupplier(SupplierDetails s);

}