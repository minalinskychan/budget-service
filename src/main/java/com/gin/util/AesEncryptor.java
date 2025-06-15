package com.gin.util;


import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * 
 * @author Omega Palguno Purnomo
 * AES Encryption for client - server
 *
 */
public class AesEncryptor {
	private static final int KEY_SIZE = 128;
    private final Cipher cipher;
    private static AesEncryptor instance= null;
    
    public static synchronized AesEncryptor getInstance(){
		if (instance == null){
			instance= new AesEncryptor();
		}
		return instance;
	}
    
    public AesEncryptor() {
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        }catch (NoSuchAlgorithmException e) {
            throw fail(e);
        }catch(NoSuchPaddingException e){
        	throw fail(e);
        }
    }
    
    public String encrypt(String iv, String passphrase, String plaintext) {
        try {
            SecretKey key = generateKey(passphrase);
            byte[] encrypted = doFinal(Cipher.ENCRYPT_MODE, key, iv, plaintext.getBytes("UTF-8"));
            return base64(encrypted);
        }
        catch (UnsupportedEncodingException e) {
            throw fail(e);
        }
    }
    
    public String decrypt(String iv, String passphrase, String ciphertext) {
        try {
            SecretKey key = generateKey(passphrase);
            byte[] decrypted = doFinal(Cipher.DECRYPT_MODE, key, iv, base64(ciphertext));
            return new String(decrypted, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            throw fail(e);
        }
    }
    
    private byte[] doFinal(int encryptMode, SecretKey key, String iv, byte[] bytes) {
        try {
            cipher.init(encryptMode, key, new IvParameterSpec(iv.getBytes()));
            return cipher.doFinal(bytes);
        }
        catch (InvalidKeyException e){
        	throw fail(e);
        }catch(InvalidAlgorithmParameterException e){
        	throw fail(e);
        }catch(IllegalBlockSizeException e){
        	throw fail(e);
        }catch(BadPaddingException e){
        	throw fail(e);
        }
    }
    
    private SecretKey generateKey(String passphrase) {
        try {
        	SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(KEY_SIZE);
            KeySpec spec = new PBEKeySpec(passphrase.toCharArray());
            SecretKey key = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
            return key;
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException e){
        	throw fail(e);
        }
    }
    
    public static String random(int length) {
        byte[] salt = new byte[length];
        new SecureRandom().nextBytes(salt);
        return hex(salt);
    }
    
    public static String base64(byte[] bytes) {
        return new String(Base64.encodeBase64(bytes));
    }
    
    public static byte[] base64(String str) {
        return Base64.decodeBase64(str.getBytes());
    }
    
    public static String hex(byte[] bytes) {
        return new String(Hex.encodeHex(bytes));
    }
    
    public static byte[] hex(String str) {
        try {
            return Hex.decodeHex(str.toCharArray());
        }
        catch (DecoderException e) {
            throw new IllegalStateException(e);
        }
    }
    
    private IllegalStateException fail(Exception e) {
        return new IllegalStateException(e);
    }
    
    public static void main(String[]args){
//    	String IV = "1122334455667788";
    	String IV = "IB20220525094022";
//    	String IV = "3404f81e9f65a572";
        String PLAIN_TEXT = "123456";
        String PLAIN_TEXT2 = "Password1!";
        String PASSPHRASE = "Th1si50uRseCr3TK";
        
        AesEncryptor util = new AesEncryptor();
        String encrypt = util.encrypt(IV, PASSPHRASE, PLAIN_TEXT);
        System.out.println(encrypt);
        
        String encrypt2 = util.encrypt(IV, PASSPHRASE, PLAIN_TEXT2);
        System.out.println(encrypt2);
        
        String decrypt = util.decrypt(IV, PASSPHRASE, encrypt);
        System.out.println(decrypt);
    }
	
}
	


