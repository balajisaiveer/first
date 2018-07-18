package com.balaji.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

//import javax.security.auth.message.callback.SecretKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.balaji.modal.User;
import com.balaji.modal.Transaction;
import com.balaji.controller.Users;
//import com.balaji.services.UserService;
import com.balaji.config.CustomAuth;
import com.balaji.repository.UserRepository;
import com.balaji.services.TransactionService;
import com.balaji.repository.*;

@Controller  
public class Applicationcontroller {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	TransactionRepository transactionRepository;

	//@Autowired 
	//private UserService userService; 
	@Autowired
	private TransactionService transactionService;

//------------------------------------------------	
	//Below is for including a Welcomepage
	/*@RequestMapping("/welcome") 	
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode","MODE_HOME");
		return "welcomepage";
	}*/


//-----------------------------------------------
//Below is for a new user to get registered
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public ModelAndView register()
	{
		
		return new ModelAndView("register","command",new Users());
		
	}

	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String addUser(@ModelAttribute("abc") Users abc , Model model)
	{
		User user = new User();
		user.setUsername(abc.username);
		user.setPassword(abc.password);
		user.setBalance(10000);
		System.out.println(abc.username);
		if(userRepository.findByUsername(abc.username).isEmpty())
		{
			if(userRepository.save(user)!=null);
			System.out.println("added to db!");
			return "login";
		}
		else
		{
			model.addAttribute("error",  "Invalid credentials.");
			return "register";    
		}
		
	}
//----------------------------------------------------------
//Below is for a user to get loged in	
	@RequestMapping("/login")
	public String login(Principal principal)
	{	if(principal==null)
		{
		//logger.info("entered login page");
		return "login";
		
		}
	else 
		return "redirect:/home"; 
	}
	
	@RequestMapping("/login-failure")
	public String loginFail()
	{
	return "login-failure"; 	
	}
//---------------------------------------------------------	
/*Below is to make sure user get his name in logged in home page and goes back to his home page while using back button*/ 		
	@RequestMapping(value= {"/","/home"})
	public String home()
	{
		return "redirect:/users/"+CustomAuth.username;
	}

	@RequestMapping(value= {"/users/{uname}"})
	public String home(@PathVariable String uname ,Model model)
	{
	String username=uname.toUpperCase();
	//logger.info("User"+username+" logged in");
	model.addAttribute("name",username);
	return "home";
	}
//----------------------------------------------------------
//Below is for getting the users balance
	@RequestMapping(value="/view-balance")
	public String showbalance(Model model,Principal principal)
	{
		List<User> usersa = new ArrayList<User>(); 
		usersa = userRepository.findByUsername(principal.getName());
		int a=0;
		for ( User u : usersa) {
			a=u.getBalance();
		}
		model.addAttribute("balance",a);
		return "balance";
	}	
//--------------------------------------------------------------
//Below is for getting previously done transactions by the user
	@GetMapping("/view-transactions")
	public String showAllidTransactions(HttpServletRequest request,Principal principal) {
		request.setAttribute("mode","MODE_A");
		//System.out.println("balaji");
		//for(Transaction t:transactionService.showAllidTransactions(principal))
		//	System.out.println(t.getRusername());
		request.setAttribute("idtransactions",transactionService.showAllidTransactions(principal));
	return "viewtransaction";	
	}
//--------------------------------------------------------------
	
//Below is for making a new transaction
	@RequestMapping(value="/newtransaction",method = RequestMethod.GET)
	public String newtransaction(HttpServletRequest request,Model model,Principal principal) {
		String susername=principal.getName();
		model.addAttribute("name",susername);
		return "transaction";
	}	
	
	@RequestMapping(value="/newtransaction",method = RequestMethod.POST)
	public String registerTransaction(@ModelAttribute("transaction") Transaction transaction,BindingResult bindingResult,HttpServletRequest request,Principal principal) {
		//request.setAttribute("mode","MODE_AFTERTRANSACTION");
	 	//System.out.println(transaction.getRusername()+" "+transaction.getSendername()+" "+transaction.getAmount());
		//System.out.println(transactionService.showAllTransactions());
		User senderuser1 = new User();
		User reciveruser1 = new User();
		List<User> users = new ArrayList<User>(); 
		List<User> reciverusers = new ArrayList<User>(); 
		users = userRepository.findByUsername(principal.getName());
		int b=0;
		for ( User u : users) {
			senderuser1 = u;
			b=u.getBalance();
		}
		reciverusers = userRepository.findByUsername(transaction.getRusername());
		int c=0;
		for ( User u : reciverusers) {
			reciveruser1 = u;
			c = u.getBalance();
		}
		if(userRepository.findByUsername(transaction.getRusername()).isEmpty())
		{
			return "transactionfailure";
		}
		else if (b>=transaction.getAmount())
		{
		b = b-transaction.getAmount();
		c = c+transaction.getAmount();
		senderuser1.setBalance(b);
		reciveruser1.setBalance(c);
	 	transactionRepository.save(transaction);
		return "home";
		}
		else {
			return "transactionbalancefailure";
		}
		//transactionService.saveMyTransaction(transaction);
	}
//-----------------------------------------------------------
	@RequestMapping("/forgot-password")
	public String forgotPassword()
	{
	return "forgot";
	}

	@RequestMapping(value="/forgot-password",method = RequestMethod.POST)
	public String forgotReply(@ModelAttribute("abc") Users abc, Model model)
	{
		if(userRepository.findByUsername(abc.username).isEmpty())
			{
			model.addAttribute("reply", "No user is registered with this username");
			return "afterforgot";
			}
		else
			{
			model.addAttribute("reply",  "Hi "+abc.username.toUpperCase()+"! This method has not been implemented yet check again later.");
			return "afterforgot";
			}	
	}
	
//-----------------------------------------------------------	
	
//Below Methods are done for login,registration and others before using spring security
//------------------------------------------------------------------------------
		/*Initial register method before spring security Included
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
		}*/
		
//--------------------------------------------------------------------------------	
		
	/*@PostMapping("/login-user/save-transaction")
	public String registerTransaction(@ModelAttribute Transaction transaction,BindingResult bindingResult,HttpServletRequest request) {
		request.setAttribute("mode","MODE_AFTERTRANSACTION");
		transactionService.saveMyTransaction(transaction);
		return "homepage";
	}*/
	
	/*@GetMapping("/viewtransacttionhistory")
	public String showAllTransactions(HttpServletRequest request) {
		
		request.setAttribute("transactions",transactionService.showAllTransactions());
		return "homepage2";	
	}*/
	
	/*@GetMapping("/show-users")
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
	}*/
	/*@RequestMapping("/login")
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
	}*/
//----------------------------------------------------------------------
	
	
}
