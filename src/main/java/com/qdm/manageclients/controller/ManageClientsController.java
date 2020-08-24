package com.qdm.manageclients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.qdm.manageclients.dto.IssueStatus;
import com.qdm.manageclients.response.ResponseInfo;
import com.qdm.manageclients.service.ManageClientService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/careGiver/clients")
public class ManageClientsController {
	@Autowired
	ManageClientService manageClientService;

	@GetMapping("/reports/get")
	public ResponseEntity<?> getReports() {
		ResponseInfo responseinfo = manageClientService.getClientReport();
		return new ResponseEntity<Object>(responseinfo, HttpStatus.OK);
	}

	@GetMapping("/issues/list/get")
	public ResponseEntity<?> getIssuesList() {
		ResponseInfo responseinfo = manageClientService.getIssueList();
		return new ResponseEntity<Object>(responseinfo, HttpStatus.OK);
	}

	@PutMapping("/issues/details/get")
	public List<String> getDetailsList(@RequestBody IssueStatus issueStatus) {
		return null;
	}

	@GetMapping("/issues/recommendations/details/get")
	public ResponseEntity<?> getRecommendationsDetailsList() {
		ResponseInfo responseinfo = manageClientService.getRecommendations();
		return new ResponseEntity<Object>(responseinfo, HttpStatus.OK);
	}

	@GetMapping("/issues/recommendations/products/list/get")
	public ResponseEntity<?> getRecommendationsProductsList() {
		return null;
	}

	@GetMapping("/issues/ratings/get")
	public ResponseEntity<?> getRatingsList() {
		ResponseInfo responseinfo = manageClientService.getProductRatings();
		return new ResponseEntity<Object>(responseinfo, HttpStatus.OK);
	}
	@GetMapping("/issues/activities/summary/get")
	public ResponseEntity<?> getActivitySummary() {
		ResponseInfo responseinfo = manageClientService.getActivitySummary();
		return new ResponseEntity<Object>(responseinfo, HttpStatus.OK);
	}
	@GetMapping("/issues/activities/get")
	public ResponseEntity<?> getActivity() {
		ResponseInfo responseinfo = manageClientService.getClientActivity();
		return new ResponseEntity<Object>(responseinfo, HttpStatus.OK);
	}

}
