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

import com.demo.spring.entity.Leave;
import com.demo.spring.entity.Timesheet;

@RestController
@RequestMapping("/admint")
public class AdminTimesheetController {
	@Autowired
	private RestTemplate rt;
	
		/*@GetMapping(path = "/admin/get/timesheet/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity getTimesheetDetails(@PathVariable Long id) {
			ResponseEntity<String> resp = rt.getForEntity("http://employee-microservice/timesheet/" + id, String.class);
			return resp;
		}
*/

	// -------------------------------Admin view list of timesheets----------------------------------
		
	    @GetMapping(path = "/get/timesheetlist", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Timesheet>> listAllTimesheet() {
			ResponseEntity<List<Timesheet>> timesheetList = rt.exchange("http://employee-microservice/timeshe/emp/timesheet/list", HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Timesheet>>() {
					});
			return timesheetList;
		}

		// ----------------------Admin Add timesheet--------------------------

		//YES
		@PutMapping(value = "/{id}/addTimesheet", consumes =MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> addTimesheet(@PathVariable Long id,@RequestBody Timesheet t) {
			HttpEntity req = new HttpEntity(t);
			ResponseEntity<String> resp = rt.exchange("http://employee-microservice/empl/emp/" + id + "/addTimesheet", HttpMethod.PUT, req, String.class);
			return resp;
		}
		
		// ------------------------Admin update timesheet---------------------------
		@PutMapping(value = "/admin/{id}/update/timesheet", consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> updateTimesheet(@PathVariable Long id,@RequestBody Timesheet t) {
			HttpEntity req = new HttpEntity(t);
			ResponseEntity<String> resp = rt.exchange("http://employee-microservice/timeshe/emp/" + id + "/updateTimesheet", HttpMethod.PUT, req, String.class);
			return resp;
		}
		

		// --------------------------calculate salary from timesheets---------------------

	
	
}
