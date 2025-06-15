package com.gin.util;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Constants {
	public static final String STATUS_ACTC="ACTC";
	public static final String STATUS_RJCT="RJCT";
	public static final String RC_SUCCESS = "00";
	public static final String RC_NOT_FOUND = "01";
	public static final String RC_INVALID_CHANNEL = "03";
	public static final String RC_TIMEOUT = "08";
	public static final String RC_SUSPECT = "68";
	public static final String RC_GENERAL_ERROR = "99";
	public static final String RC_PG_SUCCESS = "2000000";
	public static final String RC_PG_SUSPECT = "5007068";
	public static final String MESSAGE_SUCCESS="SUCCESS";
	public static final String MESSAGE_TIMEOUT="TIMEOUT";
	public static final String MESSAGE_NOT_FOUND="DATA NOT FOUND";
	public static final String MESSAGE_INVALID_CHANNEL="INVALID CHANNEL";
	public static final String MESSAGE_GENERAL_ERROR="GENERAL ERROR";
	public static final String MESSAGE_UNDEFINED="UNDEFINED";
	public static final String SYSTEM="SYSTEM";
	public static final String CONTENT_TYPE_APPLICATION_JSON="application/json";
	public static final String CONTENT_TYPE_APPLICATION_FORMURLENCODED="application/x-www-formurlencoded";
	public static final SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
	public static final SimpleDateFormat sdf4 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	public static final SimpleDateFormat sdf5 = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat sdf6 = new SimpleDateFormat("HHmmss");
	public static final SimpleDateFormat sdf7 = new SimpleDateFormat("yyyyMMddHHmmss");
	public static ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
	
	public static final int FLAG_TRUE=0;
	public static final int FLAG_FALSE=1;
	public static final String SEX_MALE="M";
	public static final String SEX_FEMALE="F";
	

	public final static int RELEASE = 103;
	public final static int PROCESSING = 12;
	public final static int FAILED = 5;  //udah di execute tapi gagal
}
