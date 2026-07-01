package com.jbm.spring_boot_crud_mysql.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	
	@RequestMapping
	public String getUser() {
		return "BOSS THIS WAS SECOUND USER";
	}
}
