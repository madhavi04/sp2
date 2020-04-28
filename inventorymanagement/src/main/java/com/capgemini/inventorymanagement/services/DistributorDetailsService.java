package com.capgemini.inventorymanagement.services;

import java.util.List;

import com.capgemini.inventorymanagement.entities.DistributorDetails;

public interface DistributorDetailsService {
   DistributorDetails addDistributor(DistributorDetails d);

	List<DistributorDetails> getAllDistributors();
	
	DistributorDetails getDistributorDetail(int D_id);

	DistributorDetails deleteDistributor(int D_id);

	DistributorDetails updateDistributor(DistributorDetails d);

}