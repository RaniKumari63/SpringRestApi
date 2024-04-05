package com.suchiit.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suchiit.exception.AccountNotFoundException;
import com.suchiit.model.Account;

import com.suchiit.repo.AccountRepo;
import com.suchiit.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService{
@Autowired
AccountRepo accrepo;
	@Override
	public String saveAccount(Account account) throws Exception, IOException {
		// TODO Auto-generated method stub
		
		Account savedEnt = accrepo.save(account);
		String msg=null;
		if(savedEnt!=null)
			msg="Data Inserted Success Fully";
		else
			msg="Data Not Inserted SuccessFully";
		
		return msg;
	}

	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return accrepo.findAll();
	}

	@Override
	public Account getAccountById(int id) {
		Optional<Account> findById = accrepo.findById(id);
		
			if(findById.isPresent())
			{
				return findById.get();
			}
			else
			{
				throw new AccountNotFoundException("Record Not Found with given id"+id);
			}
	
		
	

	}

	@Override
	public boolean deleteAccount(int id) {
		// TODO Auto-generated method stub
		Account account = accrepo.findById(id).get();
		boolean flag=false;
		if(account!=null)
		{
			accrepo.deleteById(id);
			flag=true;
		}
		return flag;
	}

}
