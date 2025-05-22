package com.abhi.it.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.abhi.it.Entity.CustomerInfo;
import com.abhi.it.Entity.CustomerResponse;
import com.abhi.it.Service.ReportService;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {

	@Autowired
	private ReportService repo;
	
	@GetMapping("/")
	public String getHomepage(Model model) {
		CustomerResponse res = new CustomerResponse();
		model.addAttribute("PlanInfo", res);
		init(model);
		return "index" ;
	}

	private void init(Model model) {
		model.addAttribute("names", repo.getPlansName());
		model.addAttribute("status", repo.getPlansStatus());
	}	
	
	@PostMapping("/search")
	public String getData(@ModelAttribute("PlanInfo") CustomerResponse data, Model model) {
		System.out.println(data);
		init(model);
		List<CustomerInfo> lists = repo.getSearch(data);
		model.addAttribute("lists", lists);
		return "index";
	}
	
	  @GetMapping("/excel")
	    public void exportToExcel(HttpServletResponse response) throws IOException, MessagingException {
	        response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);
	        
	        repo.exportExcel(response);
	         
	          
	    }
	  
	  @GetMapping("/pdf")
	  public void exportPdf(HttpServletResponse response) throws IOException, MessagingException {
		  response.setContentType("application/pdf");
	      String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=customer.pdf";
	        response.setHeader(headerKey, headerValue);
	        repo.exportPdf(response);
	  }
	
}
