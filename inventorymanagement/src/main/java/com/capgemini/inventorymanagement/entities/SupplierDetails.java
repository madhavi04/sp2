package com.capgemini.inventorymanagement.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="supplierdetails")
public class SupplierDetails {
	@Id
	private int s_id;
	private String supplier_name;
	private String material_name;
	private String address;
	private long phonenumber;
	private String email_id;
	
	@OneToOne(mappedBy ="supplierdetails")
	//private RawMaterialOrderDetails RMorderdetails;
	
	/*public RawMaterialOrderDetails getRMorderdetails() {
		return RMorderdetails;
	}
	public void setRMorderdetails(RawMaterialOrderDetails rMorderdetails) {
		RMorderdetails = rMorderdetails;
	}*/
	
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getMaterial_name() {
		return material_name;
	}
	public void setMaterial_name(String material_name) {
		this.material_name = material_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
}
