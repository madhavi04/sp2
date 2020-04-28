package com.capgemini.inventorymanagement.entities;

import java.sql.Date;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trackrawmaterialorder")
public class TrackRawMaterialOrder {
	
	@Id
	private int Tracking_id;
	private Date process_date;
    
	
	@OneToOne
	@JoinColumn(name = "RawMaterial_id", referencedColumnName = "rm_id")
	private RawMaterialDetails Rawmaterialdetails;
	
	@OneToOne
	@JoinColumn(name = "rawmaterialorder_id", referencedColumnName = "order_id")
	private RawMaterialOrderDetails Rawmaterialorderdetails;

	public int getTracking_id() {
		return Tracking_id;
	}

	public void setTracking_id(int tracking_id) {
		Tracking_id = tracking_id;
	}

	public Date getProcess_date() {
		return process_date;
	}

	public void setProcess_date(Date process_date) {
		this.process_date = process_date;
	}
}
