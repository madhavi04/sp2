package com.capgemini.inventorymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.inventorymanagement.entities.SupplierDetails;


@Repository
public class SupplierDetailsDaoImpl implements SupplierDetailsDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public SupplierDetails addSupplier(SupplierDetails s) {
		// TODO Auto-generated method stub
		SupplierDetails e=em.merge(s);
		return e;
	}

	@Override
	public List<SupplierDetails> getAllSuppliers() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select m from SupplierDetails m");
		List<SupplierDetails> supplierlist=q.getResultList();
		return supplierlist;
	}

	@Override
    public SupplierDetails deleteSupplier(int s_id) 
	{
		// TODO Auto-generated method stub
		SupplierDetails sd=em.find(SupplierDetails.class,s_id);
		if(sd!=null)
			{em.remove(sd);
			}
        return sd;
	}

	@Override
	public SupplierDetails updateSupplier(SupplierDetails s) {
		// TODO Auto-generated method stub
		SupplierDetails sd=em.find(SupplierDetails.class,s.getS_id());
		if(sd!=null)
		{

			sd.setSupplier_name(s.getSupplier_name());
			sd.setMaterial_name(s.getMaterial_name());
			sd.setAddress(s.getAddress());
			sd.setPhonenumber(s.getPhonenumber());
			sd.setEmail_id(s.getEmail_id());
		}
		return sd;
}

	@Override
	public SupplierDetails getSupplierById(int s_id) {
	// TODO Auto-generated method stub
		return em.find(SupplierDetails.class, s_id);
	}
	
}	