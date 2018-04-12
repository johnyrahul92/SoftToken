package com.softToken.SoftToken.service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base32;

import org.springframework.stereotype.Service;

import com.softToken.SoftToken.util.TimeBasedOneTimePasswordGenerator;

@Service
public class SoftTokenService {

	public int getOtp(String key) throws NoSuchAlgorithmException, InvalidKeyException {

		TimeBasedOneTimePasswordGenerator timeBasedOneTimePasswordGenerator = new TimeBasedOneTimePasswordGenerator(30,
				TimeUnit.SECONDS, 6);
		Base32 base32 = new Base32();
		SecretKeySpec macKey = new SecretKeySpec(base32.decode(key), "HmacSHA1");

		return timeBasedOneTimePasswordGenerator.generateOneTimePassword(macKey, new Date());

	}

}
