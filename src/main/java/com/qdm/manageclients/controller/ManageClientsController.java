package com.qdm.manageclients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qdm.manageclients.dto.ClientReportResponse;
import com.qdm.manageclients.dto.IssueDto;
import com.qdm.manageclients.dto.IssueListResponse;
import com.qdm.manageclients.dto.IssueStatus;
import com.qdm.manageclients.dto.RecommendationsDto;
import com.qdm.manageclients.dto.ReportsDto;
import com.qdm.manageclients.response.ResponseInfo;
import com.qdm.manageclients.service.ManageClientService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/careGiver/clients")
public class ManageClientsController {
	@Autowired
	ManageClientService manageClientService;

	@GetMapping("/reports/get")
	public ResponseInfo getReports() {
		return manageClientService.getClientReport();
	}

	@GetMapping("/issues/list/get")
	public ResponseInfo getIssuesList() {
		return manageClientService.getIssueList();
	}

	@PutMapping("/issues/details/get")
	public List<String> getDetailsList(@RequestBody IssueStatus issueStatus){
		return null;
	}

	@GetMapping("/issues/recommendations/details/get")
	public ResponseInfo getRecommendationsDetailsList() {
		return manageClientService.getRecommendations();
	}

}
