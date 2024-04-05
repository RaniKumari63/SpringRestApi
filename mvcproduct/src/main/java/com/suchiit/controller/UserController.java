package com.suchiit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suchiit.entity.UserEntity;
import com.suchiit.exception.RecordNotFoundException;
import com.suchiit.model.Product;
import com.suchiit.model.User;
import com.suchiit.service.UserService;

@RestController
@RequestMapping("/restapi/users")
public class UserController {
@Autowired
UserService userservice;
@Autowired
ProductController productcontroller;

@PostMapping("/reguser")
public ResponseEntity<String> addUsers(@RequestBody User user)
{
	
	String msg="";
	User reguser=userservice.RegisterUser(user);
	if(reguser!=null)
	{
		msg="UserRegistered Successfully";
		return new  ResponseEntity<String>(msg,HttpStatus.OK);
	}
	else
	{
		msg="UserNot Registered Successfully";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	
}

@GetMapping("/login/allproducts")
public ResponseEntity<List<Product>> loginallproducts(@RequestParam("email") String email,@RequestParam("password") String password)
{
	List<Product> allProducts=productcontroller.getAllProducts();
	
	UserEntity userEn=userservice.getUserByEmailandPassword(email, password);
	if(userEn!=null)
	{
		if(userEn.getRolename().equalsIgnoreCase("admin"))
		 {return new  ResponseEntity<List<Product>>(allProducts,HttpStatus.OK);
		 }
		
		else 
		{return new  ResponseEntity<List<Product>>(allProducts,HttpStatus.OK);
			
		}
		
	}
	else
	{
	
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

	@GetMapping("/login/userinfo")
	public ResponseEntity<List<User>> loginuserinfo(@RequestParam("email") String email,@RequestParam("password") String password)
	{
		List<User> allUsers=userservice.getAllUser();
		
		UserEntity userEn=userservice.getUserByEmailandPassword(email, password);
		if(userEn!=null)
		{
			if(userEn.getRolename().equalsIgnoreCase("admin"))
			 {return new  ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
			 }
			else
			{
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
		}
		else
		{
		
			return new ResponseEntity<>(HttpStatus.OK);
		}
	
}
	
	@PutMapping("/login/deleteuser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long  id,@RequestParam("email") String email,@RequestParam("password") String password) throws RecordNotFoundException
	{
		String msg="";
	
		UserEntity userEn=userservice.getUserByEmailandPassword(email, password);
		
		
		if(userEn!=null)
		{
			if(userEn.getRolename().equalsIgnoreCase("admin"))
			 {  
				
				userservice.deleteUser(id);
				msg="Data deleted Successfully";
				return new ResponseEntity<String>(msg,HttpStatus.OK);
				
			 }
			else
			{ msg="Data not  deleted Successfully";
			    return new ResponseEntity<String>(msg,HttpStatus.OK);
				
				
			}
			
		}
		else
		{
		
			return new ResponseEntity<>(HttpStatus.OK);
		}
	
}
	
	
	@GetMapping("/login/changepassword/{cpassword}")
	public ResponseEntity<String> changepassword(@RequestParam("email") String email,@RequestParam("password") String password,@PathVariable("cpassword")String cpassword) throws RecordNotFoundException
	{
		String msg="";
	
		UserEntity userEn=userservice.getUserByEmailandPassword(email, password);
		if(userEn!=null)
		{
			
				userservice.changepassword(userEn.getUserid(),cpassword);
				msg="Password Changed Successfully";
				return new ResponseEntity<String>(msg,HttpStatus.OK);
		}	
			
			else
			{ msg="Unable to change the password";
			    return new ResponseEntity<String>(msg,HttpStatus.OK);
				
				
			}
			
		}
		
	
	
	@GetMapping("/login/buyproducts/{id}")
	public ResponseEntity<String> loginbuyproducts(@PathVariable("id") long id,@RequestParam("email") String email,@RequestParam("password") String password)
	{
		String msg="";
		
		UserEntity userEn=userservice.getUserByEmailandPassword(email, password);
		if(userEn!=null)
		{
			if(userEn.getRolename().equalsIgnoreCase("customer"))
			 {
				msg="You can buy products";
				return new  ResponseEntity<String>(msg,HttpStatus.OK);
			 }
			
			else 
			{
				msg="Please Enter valid user";
				return new  ResponseEntity<String>(msg,HttpStatus.OK);
				
			}
			
		}
		else
		{
		
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
	
	
	
	
