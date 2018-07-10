package com.balaji.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.balaji.modal.User;
import com.balaji.modal.Transaction;
import com.balaji.services.UserService;
import com.balaji.services.TransactionService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private TransactionService transactionService;
	@GetMapping("/")	
	public String hello() {
		return "This is home page";
	}
	
	@GetMapping("/saveuser")
	public String saveUser(@RequestParam String username,@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,@RequestParam String password) {
		User user = new User(username,firstname,lastname,age,password);
		userService.saveMyUser(user); 
		return "User saved";
	}
	@GetMapping("/transaction1")
	public String saveTransaction(@RequestParam int tamount,@RequestParam int idrecv,@RequestParam int tstaus,@RequestParam int id) {
		Transaction transaction = new Transaction(tamount,idrecv,tstaus,id);
		transactionService.saveMyTransaction(transaction);
		return "Transaction saved";
	}
	
}