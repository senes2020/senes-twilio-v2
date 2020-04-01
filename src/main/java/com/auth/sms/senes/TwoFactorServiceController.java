package com.auth.sms.senes;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwoFactorServiceController {

	@Autowired
	SmsService smsService;
	
	@Autowired
	DAOService daoService;
	
	@RequestMapping(value="/users/{userid}/mobilenumbers/{mobilenumber}/2fa", method=RequestMethod.PUT)
		public ResponseEntity<Object> 
				send2faCodeinSMS(@PathVariable("id") 
				String id, @PathVariable("mobilenumber")
				String mobile){
		String twoFaCode = String.valueOf(new Random().nextInt(9999) + 1000);
			smsService.send2FaCode(mobile, twoFaCode);
			daoService.update2FaProperties(id, twoFaCode);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

