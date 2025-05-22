package com.abhi.it.Service;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.abhi.it.Entity.CustomerResponse;
import com.abhi.it.util.EmailsUtil;
import com.abhi.it.util.Excelgenerator;
import com.abhi.it.util.pdfGenerator;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;

import com.abhi.it.Entity.CustomerInfo;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	private Servicerepo repo;
	
	@Autowired
	private pdfGenerator pdfGenerator;
	
	@Autowired
	private EmailsUtil utils;
	
	@Override
	public List<String> getPlansName() {
		// TODO Auto-generated method stub
		List<String> planNames = repo.getPlansNames();
		
		return planNames;
	}

	@Override
	public List<String> getPlansStatus() {
		// TODO Auto-generated method stub
		
		List<String> planStatus = repo.getPlansStatus();
		
		return planStatus;
	}

	@Override
	public List<CustomerInfo> getSearch(CustomerResponse response) {
		// TODO Auto-generated method stub
		CustomerInfo c = new CustomerInfo();
		
		if(null!= response.getPlanName() && !"".equals(response.getPlanName())) {
			c.setPlanName(response.getPlanName());
		}
		
		if(null!= response.getPlanStatus() && !"".equals(response.getPlanStatus())) {
			c.setPlanStatus(response.getPlanStatus());
		}
		
		if(null!= response.getGender() && !"".equals(response.getGender())) {
			c.setGender(response.getGender());
		}
		
		if(null!= response.getStartDate() && !"".equals(response.getStartDate())) {
		     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        LocalDate localDate = LocalDate.parse(response.getStartDate(), formatter);
			
			c.setStartDate(localDate);
		}
		
		if(null!= response.getEndDate() && !"".equals(response.getEndDate())) {
		     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        LocalDate localDate = LocalDate.parse(response.getEndDate(), formatter);
			
			c.setStartDate(localDate);
		}
		
		List<CustomerInfo> customers = repo.findAll(Example.of(c));
		return customers;
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws IOException, MessagingException{
		// TODO Auto-generated method stub
		 List<CustomerInfo> customers = repo.findAll();
         File f = new File("Customers.xls");
	     Excelgenerator excel = new Excelgenerator(customers);
	     excel.export(response, f);
	     
	     String subject = "Customer Data";
	     String body = "<h1>Customer plan is attached</h1>";
	     String to = "abhinavbhardwaj898@gmail.com";
	     utils.sendMail(subject, body, to, f);
	     f.delete();
		
		return true;
	}

	public boolean exportPdf(HttpServletResponse response) throws IOException, MessagingException {
		// TODO Auto-generated method stub
		
		List<CustomerInfo> customers = repo.findAll();
		File f = new File("Customers.pdf");
		pdfGenerator.pgfGen(customers, response, f);
		 String subject = "Customer Data";
	     String body = "<h1>Customer plan is attached</h1>";
	     String to = "abhinavbhardwaj898@gmail.com";
	     utils.sendMail(subject, body, to, f);
		f.delete();	
		return true;
	}

}
