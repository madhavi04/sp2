package com.capgemini.inventorymanagement.dao;

import java.util.List;

import com.capgemini.inventorymanagement.entities.DistributorDetails;

public interface DistributorDetailsDao {
	
	DistributorDetails addDistributor(DistributorDetails d);

	List<DistributorDetails> getAllDistributors();
	
    DistributorDetails getDistributorDetail(int D_id);
	
	DistributorDetails deleteDistributor(int D_id);

	DistributorDetails updateDistributor(DistributorDetails d);

}
