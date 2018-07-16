package com.balaji.controller;

import java.security.Principal;

import javax.security.auth.message.callback.SecretKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.balaji.modal.User;
import com.balaji.modal.Transaction;
import com.balaji.services.UserService;
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
	
	@Autowired 
	private UserService userService; 
	@Autowired
	private TransactionService transactionService;
	/*@RequestMapping("/welcome") 	
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode","MODE_HOME");
		return "welcomepage";
	}*/

	//-----------------------------------------------
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public ModelAndView register()
	{
		
		return new ModelAndView("register","command",new Users());
		
	}

	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String addUser(@ModelAttribute("inp") Users inp , Model model)
	{
		User user = new User();
		user.setUsername(inp.username);
		user.setPassword(inp.password);
		System.out.println(inp.username);
		if(userRepository.findByUsername(inp.username).isEmpty())
		{
			if(userRepository.save(user)!=null);
			System.out.println("added to db!");
			return "login";
		}
		else
		{
			model.addAttribute("error",  "Invalid credentials or UserName is already taken! please choose another one.");
			return "register";
		}
		
	}
//----------------------------------------------------------
	@RequestMapping("/login")
	public String login(Principal principal)
	{	if(principal==null)
		{
		//order = new HashMap<String,ArrayList<OrderDetails>>();	
		//logger.info("entered login page");
		return "login";
		
		}
	else 
		return "redirect:/home"; 
	}
		
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
	
	@RequestMapping("/login-failure")
	public String loginFail()
	{
	return "login-failure"; 	
	}
//-----------------------------------------
	/*@RequestMapping("/register")
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
	
	
	@RequestMapping(value="/newtransaction",method = RequestMethod.GET)
	public String newtransaction(HttpServletRequest request,Model model,Principal principal) {
		String susername=principal.getName();
		model.addAttribute("name",susername);
		return "transaction";
	}	
	
	@RequestMapping(value="/newtransaction",method = RequestMethod.POST)
	public String registerTransaction(@ModelAttribute("transaction") Transaction transaction,BindingResult bindingResult,HttpServletRequest request) {
		//request.setAttribute("mode","MODE_AFTERTRANSACTION");
	 	//System.out.println(transaction.getRusername()+" "+transaction.getSendername()+" "+transaction.getAmount());
		//System.out.println(transactionService.showAllTransactions());
		if(userRepository.findByUsername(transaction.getRusername()).isEmpty())
		{
			return "transactionfailure";
		}
		else {
			
	 	transactionRepository.save(transaction);
		return "home";

		}
				
		//transactionService.saveMyTransaction(transaction);
	}
	
	
	
	
	
	/*@PostMapping("/login-user/save-transaction")
	public String registerTransaction(@ModelAttribute Transaction transaction,BindingResult bindingResult,HttpServletRequest request) {
		request.setAttribute("mode","MODE_AFTERTRANSACTION");
		transactionService.saveMyTransaction(transaction);
		return "homepage";
	}*/
	
	@GetMapping("/viewtransacttionhistory")
	public String showAllTransactions(HttpServletRequest request) {
		
		request.setAttribute("transactions",transactionService.showAllTransactions());
		return "homepage2";	
	}
	@GetMapping("/view-transactions")
	public String showAllidTransactions(HttpServletRequest request,Principal principal) {
		request.setAttribute("mode","MODE_A");
		//System.out.println("balaji");
		//for(Transaction t:transactionService.showAllidTransactions(principal))
		//	System.out.println(t.getRusername());
		request.setAttribute("idtransactions",transactionService.showAllidTransactions(principal));
	return "viewtransaction";	
	}
	
	
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
	
}
