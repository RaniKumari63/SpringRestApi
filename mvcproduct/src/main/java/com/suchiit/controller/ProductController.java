package com.suchiit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.suchiit.exception.RecordNotFoundException;
import com.suchiit.model.Product;
import com.suchiit.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("/restapi/products")
public class ProductController {
@Autowired
private ProductServiceImpl serviceimpl;

@PostMapping("/addPro")
  
public ResponseEntity<String> saveProduct(@RequestBody Product product)
	{
	String msg="";
	Product saveProduct=serviceimpl.saveProduct(product);
		if(saveProduct!=null)
		{  msg="Data Inserted Successfully";
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		else
		{
			 msg="Data not  Inserted Successfully";
				return new ResponseEntity<String>(HttpStatus.CREATED);
		}
	    
	}

@GetMapping("/fetchPro")
public List<Product> getAllProducts()
{
	return serviceimpl.getAllProducts();
	
}

@PutMapping("/update/{id}")
public ResponseEntity<String> updateProduct(@RequestBody Product p,@PathVariable("id") long id) throws RecordNotFoundException
{
	String msg="";
	
	Product updateProduct=serviceimpl.updateProduct(p, id);
	
	if(updateProduct!=null)
	{  msg="Data updated Successfully";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	else
	{
		 msg="Data not  Inserted Successfully";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
}







/*
 * @DeleteMapping("/delete/{id}") public ResponseEntity<String>
 * deleteProduct(@PathVariable("id") long id) throws RecordNotFoundException {
 * String msg=""; boolean flag=false; flag=serviceimpl.deleteProuct(id);
 * System.out.println("jjjjjjjjjjjjjjjjjj"+flag); if(flag) {
 * msg="Data deleted Successfully"; return new
 * ResponseEntity<String>(msg,HttpStatus.OK); } else {
 * msg="Data not  deleted Successfully"; return new
 * ResponseEntity<String>(msg,HttpStatus.OK); }
 * 
 * }
 */
@PutMapping("/delete/{id}")
public ResponseEntity<String> deleteProduct1(@PathVariable("id") long id) throws RecordNotFoundException
{
String msg="";
	boolean flag=false;
	flag=serviceimpl.deleteProduct(id);
	System.out.println("jjjjjjjjjjjjjjjjjj"+id);
	if(flag)
	{  msg="Data deleted Successfully";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	else
	{
		 msg="Data not  deleted Successfully";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}	
	
}


}
