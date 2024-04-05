package com.suchiit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController2 {

	@GetMapping("/accounts")

	public String getAccount()
	{
		return "display the list of accounts";
	}
}
