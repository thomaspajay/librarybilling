package com.library.billing.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.billing.model.BillingInfo;
import com.library.billing.service.BillingService;

@RestController
public class BillingController {
	
	@Autowired
	BillingService  service ;
	
		@RequestMapping("/")
		public String home() {
			return "Library Billiing Service is up !!!";
		}

		@RequestMapping("/api/v1/billing/{book}")
		public BillingInfo message(@PathVariable String book, @RequestParam  ("fromDate") String fromDate,
				@RequestParam  ("toDate") String toDate,@RequestParam  ("price") Double price ) {
			Calendar cal1 = Calendar.getInstance();
			cal1.set(2017, 01, 15);
			Calendar cal2 = Calendar.getInstance();
			cal2.set(2017, 02, 15);
			BillingInfo msg = new BillingInfo(book, service.getBilling(cal1.getTime(), cal2.getTime() , null));
			return  msg;
		}
}

//"fromDate", "toDate", "price"
