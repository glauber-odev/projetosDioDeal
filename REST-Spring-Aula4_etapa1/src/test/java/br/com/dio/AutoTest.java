package br.com.dio;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AutoTest {

	@Autowired
	private MockMvc mockmvc;
	
	@Test
	public void deveRetornarSucessoComCredenciaisValidas() throws Exception {
		
		URI uri = new URI("/auth/signin");
		
		String content = "{ \"username\" : \"karantes\", \"senha\" : \"123456\" }";
		
		mockmvc.perform(MockMvcRequestBuilders
					.post(uri)
					.content(content)
					.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(MockMvcResultMatchers
					.status()
					.is(200));
		
	}
	
	@Test
	public void deveRetornarErroComCredenciaisInvalidas() throws Exception {
		
		URI uri = new URI("/auth/signin");
		
		String content = "{ \"username\" : \"karantes\", \"senha\" : \"1234564823\" }";
		
		mockmvc.perform(MockMvcRequestBuilders
					.post(uri)
					.content(content)
					.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(MockMvcResultMatchers
					.status()
					.is(401)
					);
		
	}
}
