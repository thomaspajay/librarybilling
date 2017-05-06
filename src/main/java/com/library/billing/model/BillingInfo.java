package com.library.billing.model;

public class BillingInfo {

	String bookId;
	Double totalDue;

	public BillingInfo(){
		
	}

	public BillingInfo(String bookId, Double totalDue) {
		super();
		this.bookId = bookId;
		this.totalDue = totalDue;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Double getTotalDue() {
		return totalDue;
	}

	public void setTotalDue(Double totalDue) {
		this.totalDue = totalDue;
	}
	

	

}
