package com.capgemini.inventorymanagement.services;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.inventorymanagement.dao.RawMaterialDetailsDaoImpl;
import com.capgemini.inventorymanagement.entities.RawMaterialDetails;
@Service
@Transactional
public class RawMaterialDetailsServiceImpl implements RawMaterialDetailsService
{

	@Autowired
	RawMaterialDetailsDaoImpl dao;
	
	@Override
	public RawMaterialDetails addDetails(RawMaterialDetails r) {
		// TODO Auto-generated method stub
		return dao.addDetails(r);
	}

	@Override
	public List<RawMaterialDetails> getAllDetails() {
		// TODO Auto-generated method stub
		return dao.getAllDetails();
	}

	@Override
	public RawMaterialDetails deleteRawMaterialDetail(int rm_id) {
		// TODO Auto-generated method stub
		return dao.deleteRawMaterialDetail(rm_id);
	}

	@Override
	public RawMaterialDetails updateDetails(RawMaterialDetails r) {
		// TODO Auto-generated method stub
		return dao.updateDetails(r);
	}

	@Override
	public RawMaterialDetails getRawMaterialDetailById(int rm_id) {
		// TODO Auto-generated method stub
		return dao.getRawMaterialDetailById(rm_id);
	}

}

