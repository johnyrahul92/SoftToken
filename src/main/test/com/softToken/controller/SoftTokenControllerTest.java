package com.softToken.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SoftTokenController.class)
public class SoftTokenControllerTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	SoftTokenController softTokenController;

	@Test
	public void getToken() throws Exception {
		
		given(softTokenController.getToken("1213")).willReturn(2);
		
		mvc.perform(get("http://localhost:8080/soft/"+1)
				.contentType(APPLICATION_JSON))
		.andExpect(status(). isOk());
	}

}
