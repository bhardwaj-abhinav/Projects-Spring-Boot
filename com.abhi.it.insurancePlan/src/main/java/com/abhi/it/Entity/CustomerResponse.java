package com.abhi.it.Entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CustomerResponse {
	private Integer customerId;
	private String planName;
	private String planStatus;
	private String gender;
	private String startDate;
	private String endDate;
}
