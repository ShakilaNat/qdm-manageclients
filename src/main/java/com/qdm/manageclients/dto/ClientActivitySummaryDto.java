package com.qdm.manageclients.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientActivitySummaryDto {
	private String activity_id;
	private String activity_name;
	private String client_name;
	private String date_time;
	private String activity_type;
	private String activity_description;
	private ClientInfoDto client_info;
   
}
