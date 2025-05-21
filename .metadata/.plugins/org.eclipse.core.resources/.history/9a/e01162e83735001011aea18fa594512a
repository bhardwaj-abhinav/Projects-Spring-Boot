package com.abhi.it.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CustomerInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String customerName;
	private String planName;
	private String planStatus;
	private String gender;
	private LocalDate startDate;
	private LocalDate endDate;
	private String deniedReason;
	private String terminateReason;
	private LocalDate teminatedDate;
	private Double benefitAmt;
	
}
