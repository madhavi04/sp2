package com.capgemini.inventorymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.inventorymanagement.entities.DistributorDetails;

@Repository
public class DistributorDetailsDaoImpl implements DistributorDetailsDao {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public DistributorDetails addDistributor(DistributorDetails d) {
		// TODO Auto-generated method stub
		DistributorDetails e=em.merge(d);
		return e;
	}

	@Override
	public List<DistributorDetails> getAllDistributors() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select m from DistributorDetails m");
		List<DistributorDetails> distributorlist=q.getResultList();
		return distributorlist;
	}

	@Override
    public DistributorDetails deleteDistributor(int D_id) 
	{
		// TODO Auto-generated method stub
		DistributorDetails db=em.find(DistributorDetails.class,D_id);
		if(db!=null)
			{
			em.remove(db);
			}
        return db;
	}

	@Override
	public DistributorDetails updateDistributor(DistributorDetails d) {
		// TODO Auto-generated method stub
		DistributorDetails db=em.find(DistributorDetails.class,d.getD_id());
		if(db!=null)
		{

			db.setDistributor_name(d.getDistributor_name());
			db.setProduct_name(d.getProduct_name());
			db.setAddress(d.getAddress());
			db.setPhonenumber(d.getPhonenumber());
			db.setEmail_id(d.getEmail_id());
		}
		return db;
}

	@Override
	public DistributorDetails getDistributorDetail(int D_id) {
		// TODO Auto-generated method stub
		return em.find(DistributorDetails.class, D_id);
	}
	
}	
	
	
