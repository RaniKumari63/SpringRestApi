package com.suchiit.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.suchiit.model.Account;

public interface AccountService {

	//List<Account> getAccounts();
	List<Account> getAccounts(int pageNumber,int pageSize);
	Account saveAccount(Account acc);
	Account getSingleAccount(long accno);
	void deleteAccount(long accno);
	//Account updateAccount(long id,Account account);
	Account updateAccount(Account account);
	List<Account> getAccountsByName(String name);
	List<Account>getAccountsByAccnameAndDepartment(String accname,String department);
	
	
	List<Account>getAccountsByAccnameContaining(String keyword);
	
}
