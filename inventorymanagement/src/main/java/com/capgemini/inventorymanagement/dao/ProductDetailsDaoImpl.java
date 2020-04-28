package com.capgemini.inventorymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.inventorymanagement.entities.ProductDetails;

@Repository

public class ProductDetailsDaoImpl implements ProductDetailsDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public ProductDetails addProduct(ProductDetails p) {
		ProductDetails e = em.merge(p);
		return e;
	}

	@Override
	public List<ProductDetails> getAllProducts() {
		Query q=em.createQuery("select m from ProductDetails m");
		List<ProductDetails> productlist=q.getResultList();
		return productlist;
	}

	@Override
	public ProductDetails getProductDetailsById(int p_id) {
		// TODO Auto-generated method stub
		return em.find(ProductDetails.class, p_id);
	}

	@Override
	public ProductDetails deleteProduct(int p_id) {
		ProductDetails pd=em.find(ProductDetails.class,p_id);
		if(pd!=null)
			{em.remove(pd);
			}
        return pd;
	}

	@Override
	public ProductDetails updateProduct(ProductDetails p) {
		// TODO Auto-generated method stub
				ProductDetails pd=em.find(ProductDetails.class,p.getP_id());
				if(pd!=null)
				{

					pd.setManufacturing_date(p.getManufacturing_date());
					pd.setExpiry_date(p.getExpiry_date());
					pd.setPrice_per_unit(p.getPrice_per_unit());
					pd.setQuantity_unit(p.getQuantity_unit());
				}
				return pd;
	}
	
	
	
}
