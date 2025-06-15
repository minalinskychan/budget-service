package com.gin.util;


import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Ian Roughley
 * @version $Id: Utils.java,v 1.12 2011/10/05 03:42:11 omega Exp $
 */
public class PasswordEncryptor {

	protected static final Log log = LogFactory.getLog(PasswordEncryptor.class);
	public final static String PASSWORD_HASH = "P4ssw0rd^&%$1234"; 
	static byte[] salt = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03 };
	static String masterKey;
	static int iterationCount = 19;
	static Cipher ecipher;
	static Cipher dcipher;

	/**
	 * this encryption will generate some hash key with this pattern :
	 * Hash(SHA1(hashedPBID)+MD5(hashedTIN)):
	 * 
	 * @param plainText
	 * @return
	 */

	@SuppressWarnings("deprecation")
	public static String encryptGenerator(String password) {
		masterKey = "MULTIPOLAR";

		byte[] hexPBID = org.apache.commons.codec.digest.DigestUtils.sha(password.toString().trim());
		byte[] hashedTin = org.apache.commons.codec.digest.DigestUtils.md5(masterKey);

		byte[] concatHex = new byte[hashedTin.length + hexPBID.length];
		System.arraycopy(hexPBID, 0, concatHex, 0, hexPBID.length);
		System.arraycopy(hashedTin, 0, concatHex, hexPBID.length, hashedTin.length);

		return org.apache.commons.codec.digest.DigestUtils.shaHex(concatHex);
	}

	@SuppressWarnings("deprecation")
	public static String encryptGenerator(String password, String id) {
		masterKey = "MULTIPOLAR" + id;

		byte[] hexPBID = org.apache.commons.codec.digest.DigestUtils.sha(password.toString().trim());
		byte[] hashedTin = org.apache.commons.codec.digest.DigestUtils.md5(masterKey);

		byte[] concatHex = new byte[hashedTin.length + hexPBID.length];
		System.arraycopy(hexPBID, 0, concatHex, 0, hexPBID.length);
		System.arraycopy(hashedTin, 0, concatHex, hexPBID.length, hashedTin.length);

		return org.apache.commons.codec.digest.DigestUtils.shaHex(concatHex);
	}

	public static String decrypt(String str) {
		try {

			PBEKeySpec keySpec = new PBEKeySpec(PASSWORD_HASH.toCharArray(), salt, iterationCount);
			SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
			ecipher = Cipher.getInstance(key.getAlgorithm());
			dcipher = Cipher.getInstance(key.getAlgorithm());

			// Prepare the parameter to the ciphers
			PBEParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

			// Create the ciphers
			ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

			// Decode base64 to get bytes
			byte[] dec = Base64.decodeBase64(str);

			// Decrypt
			byte[] utf8 = dcipher.doFinal(dec);

			// Decode using utf-8
			return new String(utf8, "UTF8");
		} catch (javax.crypto.BadPaddingException e) {
			log.error("Exception Message", e);
		} catch (IllegalBlockSizeException e) {
			log.error("Exception Message", e);
		} catch (java.io.IOException e) {
			log.error("Exception Message", e);
		} catch (Exception ee) {
			log.error("Exception Message", ee);
		}
		return null;
	}

	public static String encrypt(String str) {
		try {

			PBEKeySpec keySpec = new PBEKeySpec(PASSWORD_HASH.toCharArray(), salt, iterationCount);
			SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
			ecipher = Cipher.getInstance(key.getAlgorithm());
			dcipher = Cipher.getInstance(key.getAlgorithm());

			// Prepare the parameter to the ciphers
			PBEParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

			// Create the ciphers
			ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

			// Encode the string into bytes using utf-8
			byte[] utf8 = str.getBytes("UTF8");

			// Encrypt
			byte[] enc = ecipher.doFinal(utf8);

			// Encode bytes to base64 to get a string
			return Base64.encodeBase64String(enc);
		} catch (javax.crypto.BadPaddingException e) {
			log.error("Exception Message", e);
		} catch (IllegalBlockSizeException e) {
			log.error("Exception Message", e);
		} catch (java.io.IOException e) {
			log.error("Exception Message", e);
		} catch (Exception ee) {
			log.error("Exception Message", ee);
		}
		return null;
	}


	public static void main(String args[]) {
	}

}

