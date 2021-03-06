package com.qdm.manageclients.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientReportResponse {
	
	private int total_reports;
	private List<ReportsDto> reports;
}
