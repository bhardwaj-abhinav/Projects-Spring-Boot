package com.abhi.it.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.abhi.it.Entity.CustomerResponse;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;

import com.abhi.it.Entity.CustomerInfo;

public interface ReportService {
	public List<String> getPlansName();
	
	public List<String> getPlansStatus();
	
	public List<CustomerInfo> getSearch(CustomerResponse cr);
	
	public boolean exportExcel(HttpServletResponse response) throws IOException, MessagingException;
	
	public boolean exportPdf(HttpServletResponse response) throws IOException, MessagingException;
}
