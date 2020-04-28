package com.capgemini.inventorymanagement.entities;

import java.sql.Date;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trackproductdetails")
public class TrackProductOrder {

	@Id
	private int tracking_id;
	private Date exit_date;
	
	@OneToOne
	@JoinColumn(name = "product_id", referencedColumnName = "p_id")
	private ProductDetails productdetails;
	
	@OneToOne
	@JoinColumn(name = "productorder_id", referencedColumnName = "order_id")
	private ProductOrderDetails productorderdetails;

	public int getTracking_id()
	{
		return tracking_id;
	}

	public void setTracking_id(int tracking_id) {
		this.tracking_id = tracking_id;
	}

	public Date getExit_date() {
		return exit_date;
	}

	public void setExit_date(Date exit_date) {
		this.exit_date = exit_date;
	}

	public ProductDetails getProductdetails() {
		return productdetails;
	}

	public void setProductdetails(ProductDetails productdetails) {
		this.productdetails = productdetails;
	}

	public ProductOrderDetails getProductorderdetails() {
		return productorderdetails;
	}

	public void setProductorderdetails(ProductOrderDetails productorderdetails) {
		this.productorderdetails = productorderdetails;
	}

	
}
