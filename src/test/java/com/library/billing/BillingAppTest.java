package com.library.billing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.library.billing.conf.BillingConfiguration;
import com.library.billing.conf.BillingServiceInitializer;
import com.library.billing.model.BillingInfo;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BillingConfiguration.class, BillingServiceInitializer.class })
@WebAppConfiguration
public class BillingAppTest extends  TestCase{

	final String uri = "http://127.0.0.1:8080/";
	RestTemplate restTemplate;
	
	@Before
	public void setup(){
		restTemplate= new RestTemplate();
	}
	
	@Test
	public void testDue() {
		String url =uri+ "/LibraryBilling/api/v1/billing/?fromDate=12-01-2015&toDate=01-17-2016&price=350.00";
	    String result = restTemplate.getForObject(url, String.class);
	    assertEquals("{totalDue:1867.5}", result);
	}
	
	@Test
	public void testDueForBook() {
		String url =uri+ "/LibraryBilling/api/v1/billing/ISBN00103885?fromDate=12-01-2015&toDate=01-17-2016";
	    BillingInfo bill = restTemplate.getForObject(url, BillingInfo.class);    
	    assertEquals(1510.5,bill.getTotalDue());
	}
	
}
