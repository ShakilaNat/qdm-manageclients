package com.qdm.manageclients.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInfo {

	private String status;
	private String  status_code;
	private String message;
	private Object data;
	
}
