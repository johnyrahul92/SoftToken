package com.softToken.service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base32;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softToken.Dao.SoftTokenDao;
import com.softToken.dto.CategoriesDo;
import com.softToken.util.TimeBasedOneTimePasswordGenerator;

@Service
public class SoftTokenService {
	
	private static final Logger LOG = LogManager.getLogger(SoftTokenService.class);
	
	@Autowired
	SoftTokenDao softTokenDao;

	public int getOtp(String key) throws NoSuchAlgorithmException, InvalidKeyException {

		TimeBasedOneTimePasswordGenerator timeBasedOneTimePasswordGenerator = new TimeBasedOneTimePasswordGenerator(30,
				TimeUnit.SECONDS, 6);
		Base32 base32 = new Base32();
		SecretKeySpec macKey = new SecretKeySpec(base32.decode(key), "HmacSHA1");

		return timeBasedOneTimePasswordGenerator.generateOneTimePassword(macKey, new Date());

	}
	
	
	public CategoriesDo getCategoryName(int id) {
		LOG.debug("Inside the service method");
		
		
		return softTokenDao.getById(id);
	}

}
