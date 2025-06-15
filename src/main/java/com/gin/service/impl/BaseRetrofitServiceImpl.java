package com.gin.service.impl;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.InetSocketAddress;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gin.util.EncryptorUtil;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public abstract class BaseRetrofitServiceImpl {
	protected ObjectMapper objectMapper = new ObjectMapper();
	protected abstract String getUsername();
	protected abstract String getPassword();
	protected abstract int getTimeout();
	protected abstract String getUrl();
	protected abstract boolean isUseProxy();
	protected abstract String getProxyIp();
	protected abstract int getProxyPort();
	protected Gson gson = new Gson();
	protected EncryptorUtil encUtil = new EncryptorUtil();
	
	protected ObjectMapper getObjectMapper() {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}

	protected Retrofit getRetrofit() {
		OkHttpClient httpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient(getTimeout(),getProxyAddress());
		Retrofit retrofit = new Retrofit.Builder().
				baseUrl(getUrl())
				.addConverterFactory(ScalarsConverterFactory.create())
				.client(httpClient)
				.build();
		return retrofit;
	}
	
	protected Retrofit getRetrofitJson() {
		OkHttpClient httpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient(getTimeout(),getProxyAddress());
		Retrofit retrofit = new Retrofit.Builder().
				baseUrl(getUrl())
				.addConverterFactory(GsonConverterFactory.create())
				.client(httpClient)
				.build();
		return retrofit;
	}
	
	protected InetSocketAddress getProxyAddress() {
		if(isUseProxy()) {
			InetSocketAddress proxy = new InetSocketAddress(getProxyIp(), getProxyPort());
			return proxy;
		}else {
			return null;
		}
	}

	protected String getAuthorization() {
		String credentials = getUsername() + ":" + getPassword();
		return "Basic " + Base64.encodeBase64String((credentials).getBytes());
	}
	
	protected String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null) {
            	copy.writeTo(buffer);
            	 return buffer.readUtf8();
            }else {
            	buffer.close();
            	return "";
            }
        } catch (final IOException e) {
            return "did not work";
        }
    }
	
	protected String convertToXml(Class<?> c,Object object) {
		try {
			// Create JAXB Context
			JAXBContext jaxbContext = JAXBContext.newInstance(c);

			// Create Marshaller
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// Required formatting??
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// Print XML String to Console
			StringWriter sw = new StringWriter();

			// Write XML to StringWriter
			jaxbMarshaller.marshal(object, sw);

			// Verify XML Content
			String xmlContent = sw.toString();
			return xmlContent;
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected <T> T convertToObject(String xmlString, Class<T> c){
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(c);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			Object object = jaxbUnmarshaller.unmarshal(new StringReader(xmlString));

			return c.cast(object);
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected void logHttp(Log log, Call<String> callSync, Map<String,String> map) {
		log.info(callSync.request().url().toString());
		log.info("***HEADER***");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			log.info(entry.getKey()+":"+callSync.request().headers(entry.getKey()));
		}
		log.info("***BODY***");
		log.info(bodyToString(callSync.request().body()));
	}
	
}
