package com.suchiit.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.suchiit.model.Account;
import com.suchiit.repo.AccountRepo;
import com.suchiit.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService{

	
	
	@Autowired
	private AccountRepo accountrepo;
	/*
	 * private static List<Account>list=new ArrayList<Account>(); static { Account
	 * a=new Account(); a.setAccname("rrrrrr"); a.setAcctype("saving"); list.add(a);
	 * Account a1=new Account(); a1.setAccname("rrrrrrffffffffff");
	 * a1.setAcctype("savinggggggggg"); list.add(a1); }
	 */
	/*
	 * @Override public List<Account> getAccounts() { // TODO Auto-generated method
	 * stub
	 * 
	 * return accountrepo.findAll(); }
	 */
	@Override
	public Account saveAccount(Account acc) {
		// TODO Auto-generated method stub
		 acc=accountrepo.save(acc);
		return acc;
	}
	@Override
	public Account getSingleAccount(long accno) {
		// TODO Auto-generated method stub
		Optional<Account> account=accountrepo.findById(accno);
		if(account.isPresent())
		
			return account.get();
		
			throw new RuntimeException("Record not found exception"+accno);
			
		
		
	
	}
	@Override
	public void deleteAccount(long accno) {
		// TODO Auto-generated method stub
		accountrepo.deleteById(accno);
	}

	/*
	 * @Override public Account updateAccount(long id, Account account) {
	 * Optional<Account> acc=accountrepo.findById(id); Account accupdated=new
	 * Account(); if(acc.isPresent()) { accupdated= accountrepo.save(account); }
	 * return accupdated; }
	 */
	@Override
	public Account updateAccount( Account account) {
		
		
		return accountrepo.save(account);
	}
	@Override
	public List<Account> getAccountsByName(String name) {
		
		
		return accountrepo.findByAccname(name);
		
	
	}
	@Override
	public List<Account> getAccountsByAccnameAndDepartment(String accname, String department) {
		
		
		
		// TODO Auto-generated method stub
		return accountrepo.findByAccnameAndDepartment(accname, department);
	}
	@Override
	public List<Account> getAccountsByAccnameContaining(String keyword) {
	Sort sort=Sort.by(Sort.Direction.DESC, "accno");
		
		// TODO Auto-generated method stub
		return accountrepo.findByAccnameContaining(keyword,sort);
	}
	@Override
	public List<Account> getAccounts(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		 
		org.springframework.data.domain.Pageable pages=PageRequest.of(pageNumber, pageSize,Direction.DESC,"accno");
		
		return accountrepo.findAll(pages).getContent();
	
	}

}
