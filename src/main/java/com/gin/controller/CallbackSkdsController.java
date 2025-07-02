package com.gin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.gin.request.PostingSkdsCallbackRequest;
import com.gin.response.CallbackResponse;
import com.gin.service.SiskeudesService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(path="/api/bifast2")
public class CallbackSkdsController {
	public static ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
	private static final Logger log = (Logger) LoggerFactory.getLogger(CallbackSkdsController.class);

	@Autowired
	@Qualifier("siskeudesService")
	private SiskeudesService siskeudesService;
	
	@ApiOperation(notes = "Registration User via Channel", value = "none")
	@RequestMapping(value = "/callback", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<CallbackResponse> registerUser(@RequestBody PostingSkdsCallbackRequest request
//			,@RequestHeader("timestamp") String timestamp
			) {
//		request.setTimestamp(timestamp);
		logging("/register", "Request", request);
		
		CallbackResponse response = siskeudesService.callback(request);
		
		if(response !=null) {
			logging("/register", "Response", response);
			return new ResponseEntity<CallbackResponse>(response, HttpStatus.OK);
		}else {
			return new ResponseEntity<CallbackResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

		
	private void logging(String path,String type,Object request) {
		log.info("PATH : "+path);
		try {
			log.info(type+" Body : \n" + objectWriter.writeValueAsString(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
}
