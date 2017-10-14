package com.pwi.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeaderDTO {
	
	private String userId;
	private String sessionId;
	private int errorCode;
	private String errorMessage;
	private long responseTime;
	private int recordCount;
	
}
