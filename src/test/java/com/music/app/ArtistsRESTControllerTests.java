package com.music.app;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MusicSpringBootAppApplication.class)
@WebAppConfiguration
public class ArtistsRESTControllerTests {
	 @Autowired
	    private WebApplicationContext webApplicationContext;
	    private MockMvc mockMvc;

	    @Before
	    public void getContext() {
	        mockMvc = webAppContextSetup(webApplicationContext).build();
	        assertNotNull(mockMvc);
	    }
 
  
  @Test
  public void getAllArtistsAPI() throws Exception 
  {
	     ResultActions resultActions = mockMvc.perform(get("/artists"));
	     resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
         MockHttpServletResponse mockResponse = resultActions.andReturn()
                 .getResponse();         
         assertEquals(200, mockResponse.getStatus());
  }
  
  @Test
  public void postArtistsAPI() throws Exception 
  {
	  String body = "{\"name\":\"john\"}";

	  ResultActions resultActions = mockMvc.perform(post("/artists")
              .content(body)
              .contentType("application/json"));
      MockHttpServletResponse mockResponse = resultActions.andReturn()
              .getResponse();
      assertEquals(200, mockResponse.getStatus());
  }
}