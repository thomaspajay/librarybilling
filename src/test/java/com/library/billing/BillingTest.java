package com.library.billing;

import org.springframework.http.ResponseEntity;

import junit.framework.TestCase;

public class BillingTest  extends  TestCase {

	public void test(){
		
		BillingController  controll= new BillingController();
		ResponseEntity< String> response= controll.getBilling();
		
		
		
		assertEquals("100",response.getBody());
	}
	
}
