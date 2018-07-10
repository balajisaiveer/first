package com.balaji.controller;

import javax.security.auth.message.callback.SecretKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.balaji.modal.User;
import com.balaji.modal.Transaction;
import com.balaji.services.UserService;
import com.balaji.services.TransactionService;

@Controller  
public class Applicationcontroller {
	
	@Autowired 
	private UserService userService; 
	@Autowired
	private TransactionService transactionService;
	@RequestMapping("/welcome") 	
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode","MODE_HOME");
		return "welcomepage";
	}
	
	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode","MODE_REGISTER");
		return "welcomepage";
		
	}
	
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user,BindingResult bindingResult,HttpServletRequest request) {
		userService.saveMyUser(user);
		request.setAttribute("mode", "MODE_AFTERREGISTRATION");
	return "welcomepage";	
	}
	
	
	@RequestMapping("/login-user/newtransaction")
	public String newtransaction(HttpServletRequest request) {
		request.setAttribute("mode","MODE_NEWTRANSACTION");
		return "homepage";
	}	
	@PostMapping("/login-user/save-transaction")
	public String registerTransaction(@ModelAttribute Transaction transaction,BindingResult bindingResult,HttpServletRequest request) {
		request.setAttribute("mode","MODE_AFTERTRANSACTION");
		transactionService.saveMyTransaction(transaction);
		return "homepage1";
	}
	
	
	
	
	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request) {
		request.setAttribute("users",userService.showAllUsers());
		request.setAttribute("mode","MODE_ALL_USERS");
	return "welcomepage";	
	}
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id,HttpServletRequest request) {
		userService.deleteMyUser(id);
		request.setAttribute("users",userService.showAllUsers());
		request.setAttribute("mode","MODE_ALL_USERS");
		return "welcomepage";
	}
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("user",userService.editUser(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "welcomepage";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode","MODE_LOGIN" );
		return "welcomepage";
	}
	@RequestMapping("/login-user")
	public String login(@ModelAttribute User user,HttpServletRequest request) {
		if(userService.findByUsernameAndPassword(user.getUsername(),user.getPassword())!=null)
		{
			return "homepage";
		}
		else {
			request.setAttribute("error","Invalid Username Or Password");
			request.setAttribute("mode","MODE_LOGIN");
			return "welcomepage";
		}
	}
	
}