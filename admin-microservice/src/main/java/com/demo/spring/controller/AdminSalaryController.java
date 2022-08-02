package com.demo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Employee;
import com.demo.spring.entity.Salary;

@RestController
@RequestMapping("/admins")
public class AdminSalaryController {
	@Autowired
	private RestTemplate rt;
	
	// ---------------------View Salary---------------------
/*
		@GetMapping(path = "/admin/get/salary/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity getEmpSalary(@PathVariable Long id) {
			ResponseEntity<String> resp = rt.getForEntity("http://employee-microservice/salary/" + id, String.class);
			return resp;
		}

		@GetMapping(path = "/admin/get/salarylist", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Salary>> listAllSalary() {
			ResponseEntity<List<Salary>> SalaryList = rt.exchange("http://employee-microservice/salary", HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Salary>>() {
					});
			return SalaryList;
		}*/

		// ----------------------Add Salary--------------------------

		@PutMapping(path = "/{id}/addSalary", consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> addSalary(@PathVariable Long id,@RequestBody Salary s) {
			HttpEntity req = new HttpEntity(s);
			ResponseEntity<String> resp = rt.exchange("http://employee-microservice/empl/emp/"+ id+ "/addSalary", HttpMethod.PUT, req, String.class);
			return resp;
		}
		/*
		// ------------------------Update Salary---------------------------
		@PutMapping(value = "/update/salary", consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> updateSalary(@RequestBody Salary s) {
			HttpEntity req = new HttpEntity(s);
			ResponseEntity<String> resp = rt.exchange("http://employee-microservice/salary", HttpMethod.PUT, req, String.class);
			return resp;
		}
*/
}
