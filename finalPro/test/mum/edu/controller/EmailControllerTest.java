package mum.edu.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:/config/springmvc-testconfig.xml" })
public class EmailControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	 private MockMvc mockMvc;
	 
	 @Before
     public void setup() {
  
         // Setup Spring test in Context mode VS standalone
          this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

      }
	 @Test
	 public void getEmailTest() throws Exception {
		 this.mockMvc.perform(get("/sendmailForm")).andExpect(model().attributeExists("restaurants"));
	 }
	 
}
