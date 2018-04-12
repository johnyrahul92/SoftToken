package com.softToken.SoftToken.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.softToken.SoftToken.service.SoftTokenService;

@RestController
public class SoftTokenController {
	
	@Autowired
	SoftTokenService softTokenService;
	
	@GetMapping("/{key}")
    public int index(@PathVariable String key) throws InvalidKeyException, NoSuchAlgorithmException {
		
		
		
        return softTokenService.getOtp(key);
        
    }

}
