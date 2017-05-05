package com.library.billing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

public class BillingController {
	
	@RequestMapping("billing")
	public ResponseEntity<String> getBilling(){
		
		
		return new ResponseEntity<String>("100",HttpStatus.OK);
	}

}
