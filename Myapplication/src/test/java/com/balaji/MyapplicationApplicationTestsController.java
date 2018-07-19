package com.balaji;
//import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.balaji.controller.Applicationcontroller;


public class MyapplicationApplicationTestsController extends MyapplicationApplicationTests{

	
	protected MockMvc mvc;

    @Autowired
    protected WebApplicationContext webApplicationContext;

   
    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

  
    protected void setUp(Applicationcontroller controller) {
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
	
	
}
