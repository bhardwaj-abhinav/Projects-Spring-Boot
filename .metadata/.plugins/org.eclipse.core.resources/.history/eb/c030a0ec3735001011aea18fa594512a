package com.abhi.it.runner;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.abhi.it.Entity.CustomerInfo;
import com.abhi.it.Service.Servicerepo;

@Component
public class DataInsert implements ApplicationRunner{

	@Autowired
	private Servicerepo repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		repo.deleteAll();
		
		CustomerInfo c = new CustomerInfo();
		c.setCustomerName("Abhinav");
		c.setGender("Male");
		c.setPlanName("Cash");
		c.setPlanStatus("Approved");
		c.setBenefitAmt(5000.00);
		c.setStartDate(LocalDate.now());
		c.setEndDate(LocalDate.now().plusMonths(6));
		
		CustomerInfo c1 = new CustomerInfo();
		c1.setCustomerName("Abhi");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Denied");
		c1.setDeniedReason("Rental income");
		c1.setGender("Male");
		
		CustomerInfo c2 = new CustomerInfo();
		c2.setCustomerName("Prachi");
		c2.setGender("Fe-Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("terminated");
		c2.setBenefitAmt(5000.00);
		c2.setStartDate(LocalDate.now().minusMonths(3));
		c2.setTeminatedDate(LocalDate.now());
		c2.setTerminateReason("Govt job");
		
		CustomerInfo c3 = new CustomerInfo();
		c3.setCustomerName("Abhinav");
		c3.setGender("Male");
		c3.setPlanName("Food");
		c3.setPlanStatus("Approved");
		c3.setBenefitAmt(5000.00);
		c3.setStartDate(LocalDate.now());
		c3.setEndDate(LocalDate.now().plusMonths(6));
		
		
		CustomerInfo c4 = new CustomerInfo();
		c4.setCustomerName("Shubham");
		c4.setGender("Male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setBenefitAmt(10000.00);
		c4.setStartDate(LocalDate.now());
		c4.setEndDate(LocalDate.now().plusMonths(6));
		
		CustomerInfo c5 = new CustomerInfo();
		c5.setCustomerName("Abhishek");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setDeniedReason("Diabetics Person");
		c5.setGender("Male");
		
		CustomerInfo c6 = new CustomerInfo();
		c6.setCustomerName("Chhavi");
		c6.setGender("Fe-Male");
		c6.setPlanName("Food");
		c6.setPlanStatus("terminated");
		c6.setBenefitAmt(5000.00);
		c6.setStartDate(LocalDate.now().minusMonths(3));
		c6.setTeminatedDate(LocalDate.now());
		c6.setTerminateReason("Less income");
		
		
		CustomerInfo c7 = new CustomerInfo();
		c7.setCustomerName("Gaurish");
		c7.setGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setBenefitAmt(300000.00);
		c7.setStartDate(LocalDate.now());
		c7.setEndDate(LocalDate.now().plusMonths(6));
		
		CustomerInfo c8 = new CustomerInfo();
		c8.setCustomerName("Abhishek");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denied");
		c8.setDeniedReason("Diabetics Person");
		c8.setGender("Male");
		
		CustomerInfo c9 = new CustomerInfo();
		c9.setCustomerName("Shweta");
		c9.setGender("Fe-Male");
		c9.setPlanName("Medical");
		c9.setPlanStatus("terminated");
		c9.setBenefitAmt(5000.00);
		c9.setStartDate(LocalDate.now().minusMonths(3));
		c9.setTeminatedDate(LocalDate.now());
		c9.setTerminateReason("Move to USA");
		
		CustomerInfo c10 = new CustomerInfo();
		c10.setCustomerName("Vijay");
		c10.setGender("Male");
		c10.setPlanName("Employment");
		c10.setPlanStatus("Approved");
		c10.setBenefitAmt(10000.00);
		c10.setStartDate(LocalDate.now());
		c10.setEndDate(LocalDate.now().plusMonths(6));
		
		CustomerInfo c11 = new CustomerInfo();
		c11.setCustomerName("Nitin");
		c11.setPlanName("Employment");
		c11.setPlanStatus("Denied");
		c11.setDeniedReason("IT Person");
		c11.setGender("Male");
		
		CustomerInfo c12 = new CustomerInfo();
		c12.setCustomerName("Nancy");
		c12.setGender("Fe-Male");
		c12.setPlanName("Employment");
		c12.setPlanStatus("terminated");
		c12.setBenefitAmt(15000.00);
		c12.setStartDate(LocalDate.now().minusMonths(3));
		c12.setTeminatedDate(LocalDate.now());
		c12.setTerminateReason("High income");
		
		repo.saveAll(Arrays.asList(c,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12));
	}

}
