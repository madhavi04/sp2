package com.capgemini.inventorymanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.inventorymanagement.dao.DistributorDetailsDaoImpl;
import com.capgemini.inventorymanagement.entities.DistributorDetails;

@Service
@Transactional
public class DistributorDetailsServiceImpl implements DistributorDetailsService {
	@Autowired
	DistributorDetailsDaoImpl dao;
	
	@Override
	public DistributorDetails addDistributor(DistributorDetails d) {
		// TODO Auto-generated method stub
		return dao.addDistributor(d);
	}

	@Override
	public List<DistributorDetails> getAllDistributors() {
		// TODO Auto-generated method stub
		return dao.getAllDistributors();
	}

	@Override
	public DistributorDetails deleteDistributor(int D_id) {
		// TODO Auto-generated method stub
		return dao.deleteDistributor(D_id);
	}

	@Override
	public DistributorDetails updateDistributor(DistributorDetails d) {
		// TODO Auto-generated method stub
		return dao.updateDistributor(d);
	}

	@Override
	public DistributorDetails getDistributorDetail(int D_id) {
		// TODO Auto-generated method stub
		return dao.getDistributorDetail(D_id);
	}
	
	

}
