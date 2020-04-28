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

import com.capgemini.inventorymanagement.entities.ProductDetails;
import com.capgemini.inventorymanagement.exceptions.IdNotFoundException;
import com.capgemini.inventorymanagement.services.ProductDetailsService;

@RestController
	@RequestMapping("/ProductDetails")
	//@CrossOrigin("http://localhost:4200")
	public class ProductDetailsController {
		@Autowired
		ProductDetailsService serviceobj;
		//Add user
			@PostMapping("/addProduct")
			public ResponseEntity<String>addProduct(@RequestBody ProductDetails p )
			{
				ProductDetails e = serviceobj.addProduct(p);
				if(e == null)
				{
					throw new IdNotFoundException("Enter Valid Id");
				}
				else {
					return new ResponseEntity<String>("Product created successfully",new HttpHeaders(),HttpStatus.OK);		
				}
			}

			//Get all users
			@GetMapping("/GetAllProducts")
			private ResponseEntity<List<ProductDetails>> getAllProducts() 
			    {
				List<ProductDetails> productlist = serviceobj.getAllProducts();
				return new ResponseEntity<List<ProductDetails>>(productlist, new HttpHeaders(), HttpStatus.OK);
		        }
			
			// Get Particular ProductDetail
			@GetMapping("/GetProductDetail/{p_id}")
			private ResponseEntity<ProductDetails> getProductDetailsById(@PathVariable("p_id") int p_id) {
				ProductDetails d = serviceobj.getProductDetailsById(p_id);
				if (d == null) {
					throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
				} else {
					return new ResponseEntity<ProductDetails>(d, new HttpHeaders(), HttpStatus.OK);
				}
			}
			
		    //Update User
		    @PutMapping("/UpdateProduct")
			public ResponseEntity<String> updateProduct(@RequestBody ProductDetails p)
				{
		    	ProductDetails e = serviceobj.updateProduct(p);
					if (e == null) {
						throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
					} else {
						return new ResponseEntity<String>("Product updated successfully", new HttpHeaders(), HttpStatus.OK);
					}
				}
				
			// Delete User
			@DeleteMapping("/DeleteProduct/{Product_Id}")
			private ResponseEntity<String> deleteProduct(@PathVariable("Product_Id") int Product_Id)
				{
				ProductDetails e = serviceobj.deleteProduct(Product_Id);
					if (e == null) {
						throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
					} else {
						return new ResponseEntity<String>("Product deleted successfully", new HttpHeaders(), HttpStatus.OK);
					}
				}
			
			
			@ExceptionHandler(IdNotFoundException.class)
			public ResponseEntity<String> IdNotFound(IdNotFoundException p) {
				return new ResponseEntity<String>(p.getMessage(), HttpStatus.NOT_FOUND);
			}
			
			
}


