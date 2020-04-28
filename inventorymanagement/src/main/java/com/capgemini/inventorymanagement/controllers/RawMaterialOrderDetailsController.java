package com.capgemini.inventorymanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.inventorymanagement.entities.RawMaterialOrderDetails;
import com.capgemini.inventorymanagement.exceptions.IdNotFoundException;
import com.capgemini.inventorymanagement.services.RawMaterialOrderDetailsService;

@RestController
@RequestMapping("/RawMaterialOrder")


public class RawMaterialOrderDetailsController {
	
	
	@Autowired
	RawMaterialOrderDetailsService serviceobj;
	
	//Add RawMaterialOrder
	@PostMapping("/addRawMaterialOrder")
	public ResponseEntity<String>addRawMaterialOrder(@RequestBody RawMaterialOrderDetails r )
	{
		RawMaterialOrderDetails e = serviceobj.addRawMaterialOrder(r);
		if(e == null)
		{
			throw new IdNotFoundException("Enter Valid Id");
		}
		else {
			return new ResponseEntity<String>("RawMaterialOrder placed successfully",new HttpHeaders(),HttpStatus.OK);		
		}
	}

	//Get all RawMaterialOrders
	@GetMapping("/GetAllRawMaterialOrders")
	private ResponseEntity<List<RawMaterialOrderDetails>> getAllRawMaterialOrders() 
	    {
		List<RawMaterialOrderDetails> RawMaterialOrderlist = serviceobj.getAllRawMaterialOrders();
		return new ResponseEntity<List<RawMaterialOrderDetails>>(RawMaterialOrderlist, new HttpHeaders(), HttpStatus.OK);
        }
	
	// Get Particular RawMaterialorderDetail
			@GetMapping("/GetRawmaterialOrderDetail/{order_id}")
			private ResponseEntity<RawMaterialOrderDetails> getRawMaterialOrderDetailsById(@PathVariable("order_id") int order_id) {
				RawMaterialOrderDetails d = serviceobj.getRawMaterialOrderDetailById(order_id);
				if (d == null) {
					throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
				} else {
					return new ResponseEntity<RawMaterialOrderDetails>(d, new HttpHeaders(), HttpStatus.OK);
				}
			}
	
    //Update RawMaterialOrder
    @PutMapping("/UpdateUser")
	public ResponseEntity<String> updateRawMaterialOrder(@RequestBody RawMaterialOrderDetails r)
		{
    	RawMaterialOrderDetails e = serviceobj.updateRawMaterialOrder(r);
			if (e == null) {
				throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("RawMaterialOrder updated successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
		
	// Delete RawMaterialOrder
	@DeleteMapping("/DeleteRawMaterialOrder/{order_id}")
	private ResponseEntity<String> deleteRawMaterialOrder(@PathVariable("order_id") int order_id)
		{
		RawMaterialOrderDetails e = serviceobj.deleteRawMaterialOrder(order_id);
			if (e == null) {
				throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("RawMaterialOrder deleted successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	

}
