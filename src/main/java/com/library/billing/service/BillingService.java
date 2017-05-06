package com.library.billing.service;

import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.library.billing.model.BillingInfo;

@Service
public class BillingService {
	Long slab1days= 21l;
	Long slab2days=7l;
	Double slab2Fine=500.00;
	Double slab3FineperDay=50.00;
	
	public Double  getBilling(Date fromDate,Date toDate,Double price){
		double  totDue=0.00;
		long days = ChronoUnit.DAYS.between(fromDate.toInstant(), toDate.toInstant());
		days++;
		if(days<1) 
			return -1.00;
		if(days <=slab1days)
			totDue= price*0.05*days;
		else if(days > slab1days){
			totDue= price*0.05*slab1days;
			totDue+=slab2Fine;
		}
		if(days > slab1days+ slab2days ){
			days -= (slab1days+ slab2days);
			totDue+= days*slab3FineperDay;
		}
		return totDue;	
	}
	public BillingInfo  getBillingForBook(Date fromDate,Date toDate,String bookId){
		
		// TODO 
		// API call to get the price for book 	
		double price = 10.0;
		
		return new BillingInfo( bookId,getBilling(fromDate,toDate,price));	
	}
}
