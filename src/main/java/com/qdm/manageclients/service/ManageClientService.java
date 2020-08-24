package com.qdm.manageclients.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qdm.manageclients.dto.ClientActivityDto;
import com.qdm.manageclients.dto.ClientActivityResponse;
import com.qdm.manageclients.dto.ClientActivitySummaryDto;
import com.qdm.manageclients.dto.ClientInfoDto;
import com.qdm.manageclients.dto.ClientReportResponse;
import com.qdm.manageclients.dto.Equipment;
import com.qdm.manageclients.dto.IssueDto;
import com.qdm.manageclients.dto.IssueListResponse;
import com.qdm.manageclients.dto.ProductRatingDto;
import com.qdm.manageclients.dto.ProductRatingResponse;
import com.qdm.manageclients.dto.Products;
import com.qdm.manageclients.dto.RecommendationsDto;
import com.qdm.manageclients.dto.ReportsDto;
import com.qdm.manageclients.enumvalue.ManageClientsConstants;
import com.qdm.manageclients.enumvalue.StatusEnum;
import com.qdm.manageclients.response.ResponseInfo;

@Service
public class ManageClientService {

	public ResponseInfo getClientReport() {

		List<ReportsDto> reportsList = new ArrayList<ReportsDto>();
		reportsList.add(new ReportsDto("PreAssessment Reports", 1, 2));
		reportsList.add(new ReportsDto("Health Reports", 2, 2));
		return ResponseInfo.builder().status("Success").status_code("200").message("")
				.data(ClientReportResponse.builder().reports(reportsList).total_reports(reportsList.size()).build())
				.build();
	}

	public ResponseInfo getIssueList() {
		int openCount = 0, resolvedCount = 0, pendingCount = 0;
		List<IssueDto> issueList = new ArrayList<IssueDto>();
		issueList
		.add(new IssueDto("#ICG1245", "Having trouble with access service", "Physio -Ultra (Monthly)", "Open"));
		issueList.add(
				new IssueDto("#ICG1246", "Having trouble with access service", "Physio -Ultra (Monthly)", "Resolved"));
		for (IssueDto dto : issueList) {

			if (dto.getIssue_status().equalsIgnoreCase(ManageClientsConstants.open_status)) {
				openCount++;
			} else if (dto.getIssue_status().equalsIgnoreCase(ManageClientsConstants.resolved_status)) {
				resolvedCount++;
			} else if (dto.getIssue_status().equalsIgnoreCase(ManageClientsConstants.resolved_status)) {
				pendingCount++;
			}
		}
		return ResponseInfo.builder().status("Success").status_code("200").message("")
				.data(IssueListResponse.builder().open_count(openCount).pending_count(pendingCount)
						.resolved_count(resolvedCount).issues_enum(StatusEnum.values()).issue_list(issueList).build())
				.build();

	}

	public ResponseInfo getRecommendations() {
		List<Equipment> equipmentList = new ArrayList<Equipment>();
		equipmentList.add(new Equipment("Zerostat spacer", "MYR 432", null));
		equipmentList.add(new Equipment("Test machine", "MYR 432", null));
		List<Products> productList = new ArrayList<Products>();
		productList.add(new Products("Physio -Ultra (Monthly)", "Get Everything just cost of Physio ", "123"));
		return ResponseInfo.builder().status("Success").status_code("200").message("")
				.data(RecommendationsDto.builder().equipments(equipmentList).products(productList).build()).build();

	}
	
	public ResponseInfo getProductRatings() {
		List<ProductRatingDto> productRatings = new ArrayList<ProductRatingDto>();
		productRatings.add(new ProductRatingDto("Product review","","","","2","08-24-2020"));
		return ResponseInfo.builder().status("Success").status_code("200").message("")
				.data(ProductRatingResponse.builder().ratings_list(productRatings).build()).build();

	}
	
	public ResponseInfo getActivitySummary() {
		ClientInfoDto clientInfo=new ClientInfoDto("Zero ", "male", "21", "9876543210", "87.09", "78.90");
		ClientActivitySummaryDto clientSummary=new ClientActivitySummaryDto("1", "test", "test", "08-24-2020", "", "This assessment is to help", clientInfo);
		return ResponseInfo.builder().status("Success").status_code("200").message("")
				.data(clientSummary).build();

	}
	
	public ResponseInfo getClientActivity() {
		ClientActivityDto clientInfo=new ClientActivityDto("Zero ", "male", "21","");
		List<ClientActivityDto> activityList=new ArrayList<ClientActivityDto>();
		activityList.add(clientInfo);
		return ResponseInfo.builder().status("Success").status_code("200").message("")
				.data(ClientActivityResponse.builder().activities(activityList)).build();

	}

}
