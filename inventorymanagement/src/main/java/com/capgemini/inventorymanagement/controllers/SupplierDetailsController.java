package com.capgemini.inventorymanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.inventorymanagement.entities.SupplierDetails;
import com.capgemini.inventorymanagement.exceptions.IdNotFoundException;
import com.capgemini.inventorymanagement.services.SupplierDetailsService;

@RestController
@RequestMapping("/supplier")


public class SupplierDetailsController {
	
	@Autowired
	SupplierDetailsService serviceobj;
	
	//Add supplier
	@PostMapping("/addSupplier")
	public ResponseEntity<String>addSupplier(@RequestBody SupplierDetails s )
	{
		SupplierDetails e = serviceobj.addSupplier(s);
		if(e == null)
		{
			throw new IdNotFoundException("Enter Valid Id");
		}
		else {
			return new ResponseEntity<String>("Supplier created successfully",new HttpHeaders(),HttpStatus.OK);		
		}
	}
	
	// Get Particular SupplierDetail
		@GetMapping("/GetSupplierDetail/{s_id}")
		private ResponseEntity<SupplierDetails> getSupplierDetailById(@PathVariable("s_id") int s_id) {
			SupplierDetails d = serviceobj.getSupplierById(s_id);
			if (d == null) {
				throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
			} else {
				return new ResponseEntity<SupplierDetails>(d, new HttpHeaders(), HttpStatus.OK);
			}
		}
	
	//Get all suppliers
	@GetMapping("/GetAllSuppliers")
	private ResponseEntity<List<SupplierDetails>> getAllSuppliers() 
	    {
		List<SupplierDetails> supplierlist = serviceobj.getAllSuppliers();
		return new ResponseEntity<List<SupplierDetails>>(supplierlist, new HttpHeaders(), HttpStatus.OK);
        }
	
    //Update Supplier
    @PutMapping("/UpdateSupplier")
	public ResponseEntity<String> updateSupplier(@RequestBody SupplierDetails s)
		{
			SupplierDetails e = serviceobj.updateSupplier(s);
			if (e == null) {
				throw new IdNotFoundException("Update details Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("Supplier updated successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
		
	// Delete Supplier
	@DeleteMapping("/DeleteSupplier/{s_id}")
	private ResponseEntity<String> deleteSupplier(@PathVariable("s_id") int s_id)
		{
			SupplierDetails e = serviceobj.deleteSupplier(s_id);
			if (e == null) {
				throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("Supplier details deleted successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
}