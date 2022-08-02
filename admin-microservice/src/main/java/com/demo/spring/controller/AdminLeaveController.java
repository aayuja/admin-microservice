package com.demo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Leave;

@RestController
@RequestMapping("/adminl")
public class AdminLeaveController {
	@Autowired
	private RestTemplate rt;
	
	
	// -------------------------------Admin view list of leaves----------------------------------
	@GetMapping(path = "/get/leavelist", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Leave>> listAllLeave() {
		ResponseEntity<List<Leave>> LeaveList = rt.exchange("http://employee-microservice/leav/emp/leave/list", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Leave>>() {
				});
		return LeaveList;
	}

	/*// ----------------------Add leave--------------------------

	@PostMapping(path = "/admin/add/leave", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addLeave(@RequestBody Leave l) {
		HttpEntity req = new HttpEntity(l);
		ResponseEntity<String> resp = rt.exchange("http://employee-microservice/leave", HttpMethod.POST, req, String.class);
		return resp;
	}*/

	// ------------------------admin approve  leave---------------------------
  
	@PutMapping(value = "/{id}/approveLeave",consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> leaveApprove(@PathVariable Long id,@RequestBody Leave l) {
		HttpEntity req = new HttpEntity(l);
		ResponseEntity<String> resp = rt.exchange("http://employee-microservice/leav/emp/" + id + "/updateLeave/approve", HttpMethod.PUT, req, String.class);
		return resp;
	}
	
	
	
	//------------------------admin delete rejected leave-----------------------------
	
	//no
	@DeleteMapping(value = "/{id}/deleteLeave", consumes =MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> leaveDelete(@PathVariable Long id,@RequestBody Leave l) {
		HttpEntity req = new HttpEntity(l);
		ResponseEntity<String> resp = rt.exchange("http://employee-microservice/empl/emp/" + id + "/leave", HttpMethod.DELETE, req, String.class);
		return resp;
	}


}
