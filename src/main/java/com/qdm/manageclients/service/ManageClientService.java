package com.qdm.manageclients.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qdm.manageclients.dto.ClientReportResponse;
import com.qdm.manageclients.dto.Equipment;
import com.qdm.manageclients.dto.IssueDto;
import com.qdm.manageclients.dto.IssueListResponse;
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

}
