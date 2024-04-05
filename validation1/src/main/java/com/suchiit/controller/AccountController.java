package com.suchiit.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.suchiit.model.Account;
import com.suchiit.service.impl.AccountServiceImpl;
;
@RestController
public class AccountController {

	@Autowired
	private AccountServiceImpl accService;
	
	@PostMapping("/addAccounts")
	public ResponseEntity<String> createAccount( @Valid  @RequestBody Account account ) throws IOException, Exception
	{System.out.println("gggggggggggggggggggggggggggg"+account);;

		String saveAccount = accService.saveAccount(account);
	
		return ResponseEntity.ok().body(saveAccount);
	}
	
	
	
	
	
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAllAccounts()
	{    
		return ResponseEntity.ok().body(accService.getAllAccount());
 
	}
	
	@GetMapping("/accounts/{id}")
	public ResponseEntity<Account> getAccountId(@PathVariable   int id)
	{
		
		return ResponseEntity.ok().body(accService.getAccountById(id));

	}
	
	
	@GetMapping("/deleteaccount")
	public ResponseEntity<String> deleteAccount(@RequestParam   int id)
	{
		boolean deleteAccount = accService.deleteAccount(id);
		String msg=null;
		if(deleteAccount)
		{
			msg="Deleted Successfully";
		}
		else
			msg="Record is not Exist";
		
		
		
		return ResponseEntity.ok().body(msg);
	}
	
	
	
	
}
