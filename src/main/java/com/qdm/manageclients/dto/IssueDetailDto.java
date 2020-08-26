package com.qdm.manageclients.dto;

import java.util.List;

import com.qdm.manageclients.enumvalue.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueDetailDto {

	private String issue_title;
	private String issue_id;
	private String issue_type;
	private String issued_product;
	private String issued_client_name;
	private String issued_time;
	private String client_phone_no;
}
