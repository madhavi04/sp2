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

import com.capgemini.inventorymanagement.entities.RawMaterialDetails;
import com.capgemini.inventorymanagement.exceptions.IdNotFoundException;
import com.capgemini.inventorymanagement.services.RawMaterialDetailsService;

@RestController
@RequestMapping("/rawmaterial")
//@CrossOrigin("http://localhost:4200")
public class RawMaterialDetailsController {

	@Autowired
	RawMaterialDetailsService serviceobj;
	
	//addDetails
	@PostMapping("/addDetails")
	public ResponseEntity<String> addDetails(@RequestBody RawMaterialDetails r)
	{
		RawMaterialDetails d = serviceobj.addDetails(r);
		if(d == null) {
			throw new IdNotFoundException("Enter valid id");
		}else {
			return new ResponseEntity<String>("Details added successfully", new HttpHeaders(), HttpStatus.OK);
		}
   	}
	
	// Get Particular RawMaterialDetail
	@GetMapping("/GetRawMaterialDetail/{rm_id}")
	private ResponseEntity<RawMaterialDetails> getRawMaterialDetailById(@PathVariable("rm_id") int rm_id) {
		RawMaterialDetails d = serviceobj.getRawMaterialDetailById(rm_id);
		if (d == null) {
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		} else {
			return new ResponseEntity<RawMaterialDetails>(d, new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	// Get all details
		@GetMapping("/GetAllDetails")
		private ResponseEntity<List<RawMaterialDetails>> getAllDetails() {
			List<RawMaterialDetails> detailslist = serviceobj.getAllDetails();
			return new ResponseEntity<List<RawMaterialDetails>>(detailslist, new HttpHeaders(), HttpStatus.OK);

		}
		
		
		// Delete details
		@DeleteMapping("/DeleteDetails/{rm_id}")
		private ResponseEntity<String> deleteRawMaterialDetail(@PathVariable("rm_id") int rm_id) {
			RawMaterialDetails d = serviceobj.deleteRawMaterialDetail(rm_id);
			if (d == null) {
				throw new IdNotFoundException("Delete details Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("Details deleted successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
		
		//Update User
		@PutMapping("/UpdateDetails")
		public ResponseEntity<String> updateDetails(@RequestBody RawMaterialDetails r) {
			RawMaterialDetails d = serviceobj.updateDetails(r);
			if (d == null) {
				throw new IdNotFoundException("Update details Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("Details updated successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
}
