package com.balaji;
//import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.balaji.controller.Applicationcontroller;
//import com.balaji.modal.User;
import com.balaji.repository.UserRepository;


public class ImplementationTest extends MyapplicationApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
    private FilterChainProxy springSecurityFilterChain;
	
	private MockMvc mockMvc;

	@Autowired
	UserRepository usersrepository;
	
	Applicationcontroller app;
	
	@Before
	public void setup() {
	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilter(springSecurityFilterChain)
	            .build();
	app = new Applicationcontroller();
	}
	@Test
	public void unauthorizedAccess() throws Exception {
	    
		mockMvc.perform(get("http://localhost:8080/viewtransaction")).andExpect(status().isUnauthorized());
		
	}
	@Test
	public void loginPageLoading() throws Exception 
	{
		mockMvc.perform(get("/login")).andExpect(status().isOk());
	}

}
