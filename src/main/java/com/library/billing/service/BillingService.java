package com.library.billing.service;

import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class BillingService {
	Long slab1days= 21l;
	Long slab2days=7l;
	Double slab2Fine=500.00;
	Double slab3FineperDay=50.00;
	
	public Double  getBilling(Date fromD,Date toD,Double price){
		double  totDue=0.00;
		long days = ChronoUnit.DAYS.between(fromD.toInstant(), toD.toInstant());
		days++;
		
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
}
