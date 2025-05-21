package com.abhi.it.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abhi.it.Entity.CustomerInfo;

public interface Servicerepo extends JpaRepository<CustomerInfo, Integer>{

	@Query("select distinct(planName) from CustomerInfo")
	public List<String> getPlansNames();
	
	@Query("select distinct(planStatus) from CustomerInfo")
    public List<String> getPlansStatus();
}
