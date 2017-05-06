package com.library.billing;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.library.billing.conf.BillingConfiguration;
import com.library.billing.conf.BillingServiceInitializer;
import com.library.billing.service.BillingService;

import junit.framework.TestCase;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BillingConfiguration.class, BillingServiceInitializer.class })
public class BillingServiceTest extends TestCase {

	//@Autowired
	BillingService  service = new BillingService();
	
	@Test
	public void testbillingSameDay() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.set(2017, 01, 15);
		cal2.set(2017, 01, 15);
		Double bill = service.getBilling(cal1.getTime(),cal2.getTime(), 100.00);
		assertEquals(5.00,bill);
	}
	
	@Test
	public void testbillingSlab2() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.set(2017, 01, 15);
		cal2.set(2017, 02, 13);
		Double bill = service.getBilling(cal1.getTime(),cal2.getTime(), 100.00);
		assertEquals(605.00,bill);
	}
	
	@Test
	public void testbillingSlab3() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.set(2017, 01, 15);
		cal2.set(2017, 03, 14);
		Double bill = service.getBilling(cal1.getTime(),cal2.getTime(), 100.00);
		assertEquals(2155.00,bill);
	}
}
