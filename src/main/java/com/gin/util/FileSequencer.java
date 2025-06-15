package com.gin.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileSequencer{
	protected static final Log log = LogFactory.getLog(FileSequencer.class);
	private Properties prop = new Properties();
	private int trace;
	@Value("${sequence.file}")
	private String seqFile;
	@Value("${sequence.max}")
	private int seqMax;
	@Value("${sequence.length}")
	private int seqLength;
	
	public void setTrace(int trace){
		prop.setProperty("trace", String.valueOf(trace));
		try {
			prop.store(new FileOutputStream(seqFile), null);
		} catch (IOException e) {
			log.error("Exception Message",e);
		}
	}
	public int load(){
		try {
			prop.load(new FileInputStream(seqFile));
		} catch (FileNotFoundException e) {
			log.error("Exception Message",e);
		} catch (IOException e) {
			log.error("Exception Message",e);
		}
		return Integer.parseInt(prop.getProperty("trace"));
	}

	public String getTrace() {
		trace = load();
		
		trace++;
		if (trace > seqMax) {
			trace = 1;
		}
		setTrace(trace);
		return GeneratorUtil.filledLengthZeros(seqLength, String.valueOf(trace));
	}

}
