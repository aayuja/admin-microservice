package com.demo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Employee;

@RestController
@RequestMapping("/admine")
public class AdminEmpController {

	@Autowired
	private RestTemplate rt;
  
	//@Autowired
   //DiscoveryClient  dc;
	
   /*
	@GetMapping(path = "/admin/get/emp/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getEmpDetails(@PathVariable Long id) {
		ResponseEntity<String> resp = rt.getForEntity("http://employee-microservice/emp/" + id, String.class);
		return resp;
	}*/

	// ---------------------Admin View employee---------------------
	//yes
	@GetMapping(path = "/get/emplist", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> listAllEmployee() {
		//dc.getInstances("employee-microservice").stream().forEach(s->System.out.println(s.getHost()));
		ResponseEntity<List<Employee>> empList = rt.exchange("http://employee-microservice/empl/emp", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		return empList;
	}
	

	// ----------------------Admin Add employee--------------------------
  //yes
	@PostMapping(path = "/add/emp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addEmp(@RequestBody Employee e) {
		HttpEntity req = new HttpEntity(e);
		ResponseEntity<String> resp = rt.exchange("http://employee-microservice/empl/emp", HttpMethod.POST, req, String.class);
		return resp;
	}

	// ------------------------update employee---------------------------
	/*@PutMapping(value = "/admin/update/emp", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateEmp(@RequestBody Employee e) {
		HttpEntity req = new HttpEntity(e);
		ResponseEntity<String> resp = rt.exchange("http://employee-microservice/emp", HttpMethod.PUT, req, String.class);
		return resp;
	}*/

}
