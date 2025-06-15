package com.gin.util;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class EncryptorUtil {
	private static final String HMAC_SHA512 = "HmacSHA512";
	private static final String SHA256="SHA-256";
	
	public String hmacSha512(String clientSecret, String stringToSign) {
		try {
			String result = null;
			SecretKeySpec secretKeySpec = new SecretKeySpec(clientSecret.getBytes(), HMAC_SHA512);
			Mac mac = Mac.getInstance(HMAC_SHA512);
			mac.init(secretKeySpec);
			result = toHexString(mac.doFinal(stringToSign.getBytes()));
			return result;
		}catch(NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
			return null;
		}catch(InvalidKeyException ike) {
			ike.printStackTrace();
			return null;
		}
	}
	
	public String sha256(String data) {
		try {
			String result = null;
			MessageDigest digest = MessageDigest.getInstance(SHA256);
			byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
			result = toHexString(hash);
			return result;
		}catch(NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
			return null;
		}
	}
	
	public String minify(String data) {
		try {
			String result = null;
			Minify minify = new Minify();
			result = minify.minify(data);
			return result;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String hexEncode(String data) {
		String result = null;
		try (Formatter formatter = new Formatter()) {
			for (byte b : data.getBytes()) {
				formatter.format("%02x", b);
			}
			result = formatter.toString();
		}
		return result;
	}
	
	private static String toHexString(byte[] bytes) {
	    try (Formatter formatter = new Formatter()) {
			for (byte b : bytes) {
			    formatter.format("%02x", b);
			}
			return formatter.toString();
		}
	}
	
	public String generateSignatureTrx(
			String httpMethod,String relativeUrl,
			String accessToken,String requestBody,String xTimeStamp,
			String clientApiSecret, String signatureKey) {
		String result = null;
		String minifyRequestBody = minify(requestBody);
		System.out.println("MinifyRequestBody:"+minifyRequestBody);
		String sha256 = sha256(minifyRequestBody);
		System.out.println("sha256:"+sha256);
		String requestBodyResult = sha256.toLowerCase();
		String stringToSigned= httpMethod+":"+relativeUrl+":"+accessToken+":"+requestBodyResult+":"+xTimeStamp+clientApiSecret;
		System.out.println("StringToSigned:"+stringToSigned);
		System.out.println("SignatureKey:"+signatureKey);
		result = hmacSha512(signatureKey, stringToSigned);
		return result; 
	}
	
	public String generateSignatureToken(String clientSecret, String clientId, String xTimeStamp) {
		String result = null;
		String stringToSigned = clientId+"|"+xTimeStamp;
		result = hmacSha512(clientSecret, stringToSigned);
		return result;
	}
}
