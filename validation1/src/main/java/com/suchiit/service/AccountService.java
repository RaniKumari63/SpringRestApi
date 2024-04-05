package com.suchiit.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.suchiit.model.Account;



public interface AccountService {
	String saveAccount(Account account) throws Exception, IOException;
	List<Account> getAllAccount();
	Account getAccountById(int id);
	
	boolean deleteAccount(int id);
}
