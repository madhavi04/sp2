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

import com.capgemini.inventorymanagement.entities.DistributorDetails;
import com.capgemini.inventorymanagement.exceptions.IdNotFoundException;
import com.capgemini.inventorymanagement.services.DistributorDetailsService;

@RestController
@RequestMapping("/distributor")
public class DistributorDetailsController {
	@Autowired
	DistributorDetailsService serviceobj;
	
	//Add distributor
	@PostMapping("/addDistributor")
	public ResponseEntity<String>addDistributor(@RequestBody DistributorDetails d )
	{
		DistributorDetails e = serviceobj.addDistributor(d);
		if(e == null)
		{
			throw new IdNotFoundException("Enter Valid Id");
		}
		else {
			return new ResponseEntity<String>("Distributor Details added successfully",new HttpHeaders(),HttpStatus.OK);		
		}
	}
	
	// Get Particular DistributorDetail
			@GetMapping("/GetDistributorDetail/{D_id}")
			private ResponseEntity<DistributorDetails> getDistributorDetail(@PathVariable("D_id") int D_id) {
				DistributorDetails d = serviceobj.getDistributorDetail(D_id);
				if (d == null) {
					throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
				} else {
					return new ResponseEntity<DistributorDetails>(d, new HttpHeaders(), HttpStatus.OK);
				}
			}
	//Get all distributors
	@GetMapping("/GetAllDistributors")
	private ResponseEntity<List<DistributorDetails>> getAllDistributors() 
	    {
		List<DistributorDetails> distributorlist = serviceobj.getAllDistributors();
		return new ResponseEntity<List<DistributorDetails>>(distributorlist, new HttpHeaders(), HttpStatus.OK);
        }
	
    //Update distributor data
    @PutMapping("/UpdateDistributor")
	public ResponseEntity<String> updateSupplier(@RequestBody DistributorDetails d)
		{
			DistributorDetails e = serviceobj.updateDistributor(d);
			if (e == null) {
				throw new IdNotFoundException("Update details Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("Distributor data updated successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
		
	// Delete Distributor
	@DeleteMapping("/DeleteDistributor/{D_id}")
	private ResponseEntity<String> deleteDistributor(@PathVariable("D_id") int D_id)
		{
			DistributorDetails e = serviceobj.deleteDistributor(D_id);
			if (e == null) {
				throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("Distributor deleted successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
	}