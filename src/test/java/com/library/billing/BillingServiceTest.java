package com.library.billing;

import java.util.Calendar;

import org.junit.Test;

import com.library.billing.service.BillingService;

import junit.framework.TestCase;
public class BillingServiceTest extends TestCase {

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
