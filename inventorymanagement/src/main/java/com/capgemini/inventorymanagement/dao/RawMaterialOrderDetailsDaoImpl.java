package com.capgemini.inventorymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.inventorymanagement.entities.RawMaterialOrderDetails;
@Repository
public class RawMaterialOrderDetailsDaoImpl implements RawMaterialOrderDetailsDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public RawMaterialOrderDetails addRawMaterialOrder(RawMaterialOrderDetails r) {
		RawMaterialOrderDetails e = em.merge(r);
		return e;
	}

	@Override
	public List<RawMaterialOrderDetails> getAllRawMaterialOrders() {
		Query q=em.createQuery("select m from RawMaterialOrderDetails m");
		List<RawMaterialOrderDetails> RawMaterialOrderlist=q.getResultList();
		return RawMaterialOrderlist;
	}

	@Override
	public RawMaterialOrderDetails getRawMaterialOrderDetailById(int order_id) {
		// TODO Auto-generated method stub
		return em.find(RawMaterialOrderDetails.class, order_id);
	}

	@Override
	public RawMaterialOrderDetails deleteRawMaterialOrder(int order_id) {
		RawMaterialOrderDetails rd=em.find(RawMaterialOrderDetails.class,order_id);
		if(rd!=null)
			{em.remove(rd);
			}
        return rd;
	}

	@Override
	public RawMaterialOrderDetails updateRawMaterialOrder(RawMaterialOrderDetails r) {
		// TODO Auto-generated method stub
				RawMaterialOrderDetails rd=em.find(RawMaterialOrderDetails.class,r.getOrder_id());
				if(rd!=null)
				{

					rd.setItem_name(r.getItem_name());
					rd.setQuantity_unit(r.getQuantity_unit());
					rd.setPrice_per_unit(r.getPrice_per_unit());
					rd.setTotal_price(r.getTotal_price());
					rd.setOrder_date(r.getOrder_date());
					rd.setDelivery_date(r.getDelivery_date());
					rd.setDelivery_status(r.getDelivery_status());



				}
				return rd;
	}
}
	
	