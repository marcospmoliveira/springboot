package br.com.springboot.javaclient;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.springboot.model.PageableResponse;
import br.com.springboot.model.Student;

public class JavaClientDAO {
	private RestTemplate restTemplate = new RestTemplateBuilder()
			.rootUri("http://localhost:8081/v1/students")
			.basicAuthorization("toyo","boot")
			.build();
	private RestTemplate restTemplateAdmin = new RestTemplateBuilder()
			.rootUri("http://localhost:8081/v1/admin/students")
			.basicAuthorization("toyo", "boot").build();
	
	public Student findById(long id) {
		return restTemplate.getForObject("/{id}", Student.class, id);
//		ResponseEntity<Student> forEntity = resTemplate.getForEntity("/{id}", Student.class, 4);
	}
	
	public List<Student> listAll(){
		ResponseEntity<PageableResponse<Student>> exchange = restTemplate.exchange("/", HttpMethod.GET, null, new ParameterizedTypeReference<PageableResponse<Student>>() {
		});
		return exchange.getBody().getContent();
	}
	
	public Student save(Student student) {
		ResponseEntity<Student> exchangePost = restTemplateAdmin.exchange("/", HttpMethod.POST, new HttpEntity<>(student, createJSONHeader()), Student.class );
		return exchangePost.getBody();
	}
	
	private static HttpHeaders createJSONHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
}
