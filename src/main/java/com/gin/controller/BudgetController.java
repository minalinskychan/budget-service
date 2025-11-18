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
import com.gin.request.TotalRequest;
import com.gin.request.TransactionRequest;
import com.gin.response.TargetKeuangan;
import com.gin.response.TransaksiResponse;
import com.gin.service.TransactionBudgetService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(path="/api/transaction")
public class BudgetController {
	public static ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
	private static final Logger log = (Logger) LoggerFactory.getLogger(BudgetController.class);

	@Autowired
	@Qualifier("transactionBudgetService")
	private TransactionBudgetService transactionBudgetService;
	
	@ApiOperation(notes = "Tambah pengeluaran", value = "none")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TransaksiResponse> addRecord(@RequestBody TransactionRequest request
			) {
		logging("/add", "Request", request);
		
		TransaksiResponse response = transactionBudgetService.tambah(request);
		
		if(response !=null) {
			logging("/add", "Response", response);
			return new ResponseEntity<TransaksiResponse>(response, HttpStatus.OK);
		}else {
			return new ResponseEntity<TransaksiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(notes = "Ambil total pengeluaran", value = "none")
	@RequestMapping(value = "/gettotal", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TransaksiResponse> getTotal(
			) {
		logging("/gettotal", "Request", "");
		TransaksiResponse response = transactionBudgetService.getAllTransaction();
//		Double response = transactionBudgetService.total();
		
		if(response !=null) {
			logging("/gettotal", "Response", response);
			return new ResponseEntity<TransaksiResponse>(response, HttpStatus.OK);
		}else {
			return new ResponseEntity<TransaksiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(notes = "Ambil total tanggal spesifik", value = "none")
	@RequestMapping(value = "/gettotal", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TransaksiResponse> getTotalSpecificMonth(
			@RequestBody TotalRequest request
			) {
		logging("/gettotal", "Request", request);
//		String response = transactionBudgetService.totalSpecificMont(request);
		TransaksiResponse response = transactionBudgetService.getSpecifictRequestTransaction(request);
		
		if(response !=null) {
			logging("/gettotal", "Response", response);
			return new ResponseEntity<TransaksiResponse>(response, HttpStatus.OK);
		}else {
			return new ResponseEntity<TransaksiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(notes = "Ambil pengeluaran bulan ini", value = "none")
	@RequestMapping(value = "/getthistmont", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TransaksiResponse> getThisMonth(
//			@RequestBody TotalRequest request
			) {
		
		
		logging("/getthistmont", "Request", "");
		TransaksiResponse response = transactionBudgetService.getThisMonth();
		
		if(response !=null) {
			logging("/getthistmont", "Response", response);
			return new ResponseEntity<TransaksiResponse>(response, HttpStatus.OK);
		}else {
			return new ResponseEntity<TransaksiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@ApiOperation(notes = "Ambil pengeluaran Tahun ini", value = "none")
	@RequestMapping(value = "/getthisyear", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TransaksiResponse> getThisYear(
//			@RequestBody TotalRequest request
			) {
		

		logging("/getthisyear", "Request", "year ");
		TransaksiResponse response = transactionBudgetService.getSpecificYear();
		
		if(response !=null) {
			logging("/getthisyear", "Response", response);
			return new ResponseEntity<TransaksiResponse>(response, HttpStatus.OK);
		}else {
			return new ResponseEntity<TransaksiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@ApiOperation(notes = "Ambil Target Keuangan", value = "none")
	@RequestMapping(value = "/financialplan", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TargetKeuangan> getFinancialPlan(
//			@RequestBody TotalRequest request
			) {
		
		
		logging("/financialplan", "Ambil Target Keuangan", null);
		TargetKeuangan response = transactionBudgetService.totalFinancialPlan();
		
		if(response !=null) {
			logging("/financialplan", "Ambil Target Keuangan", response);
			return new ResponseEntity<TargetKeuangan>(response, HttpStatus.OK);
		}else {
			return new ResponseEntity<TargetKeuangan>(response, HttpStatus.INTERNAL_SERVER_ERROR);
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
