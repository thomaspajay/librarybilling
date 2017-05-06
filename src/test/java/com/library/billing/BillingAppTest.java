package com.library.billing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.library.billing.conf.BillingConfiguration;
import com.library.billing.conf.BillingServiceInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BillingConfiguration.class, BillingServiceInitializer.class})
@WebAppConfiguration
public class BillingAppTest {

	@Test
	public void  testMe(){
		
	}
	
}
