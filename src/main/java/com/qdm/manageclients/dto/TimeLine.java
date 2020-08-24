package com.qdm.manageclients.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeLine {
	private String status;
	private String date_time;
	private boolean is_completed;
}
