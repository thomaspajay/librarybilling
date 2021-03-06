package com.library.billing.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.billing.model.BillingInfo;
import com.library.billing.service.BillingService;

@RestController
public class BillingController {
	
	@Autowired
	BillingService  service ;
	
	SimpleDateFormat  format = new SimpleDateFormat("MM-dd-yyyy");
	
		@RequestMapping("/")
		public String home() {
			return "Library Billiing Service is up !!!";
		}

		@RequestMapping(value="/api/v1/billing/{book}",method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ResponseEntity<BillingInfo> getDueforBook(@PathVariable String book, @RequestParam  ("fromDate") String fromDate,
				@RequestParam  ("toDate") String toDate) throws ParseException {
			return new ResponseEntity<BillingInfo>(service.getBillingForBook(format.parse(fromDate), format.parse(toDate), book),HttpStatus.OK);
		}
		
		@RequestMapping(value ="/api/v1/billing/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ResponseEntity<String> getDue( @RequestParam  ("fromDate") String fromDate,
				@RequestParam  ("toDate") String toDate,@RequestParam  ("price") Double price ) throws ParseException {
			return new ResponseEntity<String>("{totalDue:"+service.getBilling(format.parse(fromDate), format.parse(toDate) , price)+"}",HttpStatus.OK);
		}
}
