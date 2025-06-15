package com.gin.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
	public static Map<String,Object> GLOBAL_CACHE = new HashMap<String,Object>();
	public static final String ACCESS_TOKEN="ACCESS_TOKEN";
	public static final String REFRESH_TOKEN="REFRESH_TOKEN";
	public static final String EXPIRED_DATE="EXPIRED_DATE";
	public static Date expiredDate;
	
	public static String getToken() {
		return (String)GLOBAL_CACHE.get(ACCESS_TOKEN);
	}
	
	public static void setToken(String token) {
		GLOBAL_CACHE.put(ACCESS_TOKEN, token);
	}
	
	public static String getRefreshToken() {
		return (String)GLOBAL_CACHE.get(REFRESH_TOKEN);
	}
	
	public static void setRefreshToken(String token) {
		GLOBAL_CACHE.put(REFRESH_TOKEN, token);
	}
	
	public static void setExpiredDate(int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, minutes);
		expiredDate = cal.getTime();
		GLOBAL_CACHE.put(EXPIRED_DATE, expiredDate);
	}
	
	public static Date getExpiredDate() {
		return (Date)GLOBAL_CACHE.get(EXPIRED_DATE);
	}
}
