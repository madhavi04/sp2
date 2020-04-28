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

import com.capgemini.inventorymanagement.entities.ProductOrderDetails;
import com.capgemini.inventorymanagement.exceptions.IdNotFoundException;
import com.capgemini.inventorymanagement.services.ProductOrderDetailsService;

@RestController
@RequestMapping("/productorder")
public class ProductOrderDetailsController {
	
	@Autowired
	ProductOrderDetailsService serviceobj;
	
	//Add ProductOrder
	@PostMapping("/addProductOrder")
	public ResponseEntity<String>addProductOrder(@RequestBody ProductOrderDetails p )
	{
		ProductOrderDetails e = serviceobj.addProductOrder(p);
		if(e == null)
		{
			throw new IdNotFoundException("Enter Valid Id");
		}
		else {
			return new ResponseEntity<String>("Product Order placed successfully",new HttpHeaders(),HttpStatus.OK);		
		}
	}

	//Get all ProductOrders
	@GetMapping("/GetAllProductOrders")
	private ResponseEntity<List<ProductOrderDetails>> getAllProductOrders() 
	    {
		List<ProductOrderDetails> productorderlist = serviceobj.getAllProductDetails();
		return new ResponseEntity<List<ProductOrderDetails>>(productorderlist, new HttpHeaders(), HttpStatus.OK);
        }
	

	// Get Particular ProductorderDetail
		@GetMapping("/GetProductOrderDetail/{order_id}")
		private ResponseEntity<ProductOrderDetails> getProductOrderDetailsById(@PathVariable("order_id") int order_id) {
			ProductOrderDetails d = serviceobj.getProductOrderDetailsById(order_id);
			if (d == null) {
				throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
			} else {
				return new ResponseEntity<ProductOrderDetails>(d, new HttpHeaders(), HttpStatus.OK);
			}
		}
	
    //Update ProductOrder
    @PutMapping("/UpdateProductOrder")
	public ResponseEntity<String> updateProductOrder(@RequestBody ProductOrderDetails p)
		{
			ProductOrderDetails e = serviceobj.updateproductorder(p);
			if (e == null) {
				throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("Product Order updated successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
		
	// Delete ProductOrder
	@DeleteMapping("/DeleteProductOrder/{order_id}")
	private ResponseEntity<String> deleteProductOrder(@PathVariable("Order_id") int order_id)
		{
			ProductOrderDetails e = serviceobj.deleteProductOrder(order_id);
			if (e == null) {
				throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("Product Order deleted successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
	}


