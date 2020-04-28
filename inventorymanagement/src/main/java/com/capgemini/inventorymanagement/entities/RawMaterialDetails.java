package com.capgemini.inventorymanagement.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Rawmaterialdetails")
public class RawMaterialDetails 
{
	    @Id
		private int rm_id;
		private String item_name;
		private int quantity_unit;
		private double price_per_unit;
		private Date manufacturing_date;
	    private Date expiry_date;

	    @OneToOne(mappedBy = "Rawmaterialdetails")
	   // private TrackRawMaterialOrder trackrawmaterialorder;
	    
	    
		/*public TrackRawMaterialOrder getTrackrawmaterialorder() {
			return trackrawmaterialorder;
		}

		public void setTrackrawmaterialorder(TrackRawMaterialOrder trackrawmaterialorder) {
			this.trackrawmaterialorder = trackrawmaterialorder;
		}*/

		
		public int getRm_id() {
			return rm_id;
		}

		public void setRm_id(int rm_id) {
			this.rm_id = rm_id;
		}

		public String getItem_name() {
			return item_name;
		}

		public void setItem_name(String item_name) {
			this.item_name = item_name;
		}

		public int getQuantity_unit() {
			return quantity_unit;
		}

		public void setQuantity_unit(int quantity_unit) {
			this.quantity_unit = quantity_unit;
		}

		public double getPrice_per_unit() {
			return price_per_unit;
		}

		public void setPrice_per_unit(double price_per_unit) {
			this.price_per_unit = price_per_unit;
		}

		public Date getManufacturing_date() {
			return manufacturing_date;
		}

		public void setManufacturing_date(Date manufacturing_date) {
			this.manufacturing_date = manufacturing_date;
		}

		public Date getExpiry_date() {
			return expiry_date;
		}

		public void setExpiry_date(Date expiry_date) {
			this.expiry_date = expiry_date;
		}

}
