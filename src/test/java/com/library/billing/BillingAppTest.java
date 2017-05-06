package com.library.billing;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.library.billing.conf.BillingConfiguration;
import com.library.billing.conf.BillingServiceInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BillingConfiguration.class, BillingServiceInitializer.class })
@WebAppConfiguration
public class BillingAppTest {

	final String uri = "http://127.0.0.1:8080/";

	@Test
	public void testMe() {
		String url =uri+ "/LibraryBilling/api/v1/billing/?fromDate=12-01-2015&toDate=01-17-2016&price=350.00";
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(url, String.class, params);
	   System.out.println(result);

	}
}
