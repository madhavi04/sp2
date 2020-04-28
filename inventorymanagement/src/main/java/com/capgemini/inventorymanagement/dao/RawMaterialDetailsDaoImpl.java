package com.capgemini.inventorymanagement.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.inventorymanagement.entities.RawMaterialDetails;

@Repository
public class RawMaterialDetailsDaoImpl implements RawMaterialDetailsDao
{

@PersistenceContext
EntityManager em;

@Override
public RawMaterialDetails addDetails(RawMaterialDetails r) {
	RawMaterialDetails d = em.merge(r);
	return d;
}

@Override
public List<RawMaterialDetails> getAllDetails() {
	Query q = em.createQuery("select m from RawMaterialDetails m");
	List<RawMaterialDetails>detailslist = q.getResultList();
	return detailslist;
}

@Override
public RawMaterialDetails deleteRawMaterialDetail(int rm_id) {
	RawMaterialDetails rm = em.find(RawMaterialDetails.class, rm_id);
	if(rm!=null)
	{
		em.remove(rm);
	}
	return rm;
}

@Override
public RawMaterialDetails updateDetails(RawMaterialDetails r) {
	RawMaterialDetails rm = em.find(RawMaterialDetails.class, r.getRm_id());
	if(rm!=null)
	{
		rm.setManufacturing_date(r.getManufacturing_date());
		rm.setExpiry_date(r.getExpiry_date());
		rm.setPrice_per_unit(r.getPrice_per_unit());
		rm.setQuantity_unit(r.getQuantity_unit());
	}
	return rm;
}

@Override
public RawMaterialDetails getRawMaterialDetailById(int rm_id) {
        
	return em.find(RawMaterialDetails.class, rm_id);
}
}