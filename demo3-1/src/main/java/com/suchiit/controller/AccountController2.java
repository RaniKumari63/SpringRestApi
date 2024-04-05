
package com.suchiit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.suchiit.model.Account;

import com.suchiit.service.AccountService;

@RestController
//@RequestMapping("/restapi")
public class AccountController2 {
	@Autowired
	private AccountService accountservice;
@Value("${app.name}")
private String appName;
@Value("${app.version}")
private String appVersion;

@GetMapping("/version")
public String getAppDetails()
{
	return appName+appVersion;
	
}

	@GetMapping("/accounts/get")

	public ResponseEntity<List<Account>> getAccounts(@RequestParam("pagenumber") int pagenumber,@RequestParam("pagesize") int pagesize)
	{
		return new  ResponseEntity<List<Account>>(accountservice.getAccounts(pagenumber,pagesize),HttpStatus.OK);
	}
	@GetMapping("/accounts/get/{accno}")
	public ResponseEntity<Account> getAccount(@PathVariable("accno") long accno)
	{
		return new  ResponseEntity<Account>(accountservice.getSingleAccount(accno),HttpStatus.OK);
		
	}

	/*
	 * @PutMapping("/accounts/update/{id}") public Account
	 * updateAccount(@PathVariable long id,@RequestBody Account account) { Account
	 * acc=accountservice.updateAccount(id, account); return acc;
	 * 
	 * }
	 */
	@PutMapping("/accounts/update/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable long id,@RequestBody Account account)
	{
		account.setAccno(id);
		return new ResponseEntity<Account>(accountservice.updateAccount(account),HttpStatus.CREATED);
		
	}
	@DeleteMapping("/accounts/delete")
	public ResponseEntity<HttpStatus> deleteAccount(@RequestParam("accno") long accno)
	{accountservice.deleteAccount(accno);
		 return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	
	
	@PostMapping("/accounts/save")
	public ResponseEntity<Account> saveAccount(@Valid @RequestBody Account account)
	{
		
		return new ResponseEntity<Account>(accountservice.saveAccount(account),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/accounts/filterByName")
	public ResponseEntity<List<Account>> getAccountsByName(@RequestParam String accname)
	{
		
		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		
		return new ResponseEntity<List<Account>>(accountservice.getAccountsByName(accname),HttpStatus.OK);
		
	}
	@GetMapping("/accounts/filterByNameAndDepartment")
	public ResponseEntity<List<Account>> getAccountsByNameAndDepartment(@RequestParam String accname,@RequestParam String department)
	{
		
		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		
		return new ResponseEntity<List<Account>>(accountservice.getAccountsByAccnameAndDepartment(accname,department),HttpStatus.OK);
		
	}
	
	
	@GetMapping("/accounts/filterByKeyword")
	public ResponseEntity<List<Account>> getAccountsByNameContaining(@RequestParam String keyword)
	{
		
		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		
		return new ResponseEntity<List<Account>>(accountservice.getAccountsByAccnameContaining(keyword),HttpStatus.OK);
		
	}
}
