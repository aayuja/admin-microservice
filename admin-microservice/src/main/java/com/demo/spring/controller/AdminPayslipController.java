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

import com.demo.spring.entity.Payslip;
import com.demo.spring.entity.Timesheet;

@RestController
@RequestMapping("/adminp")
public class AdminPayslipController {
	@Autowired
	private RestTemplate rt;
	/*
	// ---------------------View Payslip---------------------

		@GetMapping(path = "/admin/get/payslip/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity getPaysliptDetails(@PathVariable Long id) {
			ResponseEntity<String> resp = rt.getForEntity("http://employee-microservice/payslip/" + id, String.class);
			return resp;
		}

		
		@GetMapping(path = "/admin/get/payslipList", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Payslip>> listAllPayslip() {
			ResponseEntity<List<Payslip>> payslipList = rt.exchange("http://employee-microservice/payslip", HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Payslip>>() {
					});
			return payslipList;
		}
*/
		 //----------------------Addmin Add Payslip--------------------------
 
	    
		@PutMapping(path = "/{id}/add/payslip", consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> addPayslip(@PathVariable Long id,@RequestBody Payslip p) {
			HttpEntity req = new HttpEntity(p);
			ResponseEntity<String> resp = rt.exchange("http://employee-microservice/empl/emp/" + id+ "/addPayslip", HttpMethod.PUT, req, String.class);
			return resp;
		}
   
		/*
		// ------------------------update Payslip--------------------------
		@PutMapping(value = "/admin/update/payslip", consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> updatePayslip(@RequestBody Payslip p) {
			HttpEntity req = new HttpEntity(p);
			ResponseEntity<String> resp = rt.exchange("http://employee-microservice/payslip", HttpMethod.PUT, req, String.class);
			return resp;
		}
*/

}
