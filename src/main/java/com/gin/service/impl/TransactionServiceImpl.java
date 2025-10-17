package com.gin.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.gin.controller.BudgetController;
import com.gin.model.Transaksi;
import com.gin.repository.TransaksiRepository;
import com.gin.request.TotalRequest;
import com.gin.request.TransactionRequest;
import com.gin.response.DanaDarurat;
import com.gin.response.DanaPensiun;
import com.gin.response.TargetKeuangan;
import com.gin.response.TransaksiResponse;
import com.gin.service.TransactionBudgetService;

@Service("transactionBudgetService")
public class TransactionServiceImpl implements TransactionBudgetService {


	public static ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
	
	
	@Autowired
	private TransaksiRepository transaksiRepository;
	
	private final String TIMEOUT = "TIMEOUT";

	private static final Logger log = (Logger) LoggerFactory.getLogger(BudgetController.class);

	public boolean timeoutMpn(String timeout){
		return timeout.toUpperCase().contains(TIMEOUT);
		
	}

	@Override
	public TransaksiResponse tambah(TransactionRequest request) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		Transaksi transaksi = new Transaksi();
		Date date; 
		try {
			String dateInString = request.getTanggal();
			date = formatter.parse(dateInString);
			transaksi.setSpendAmount(BigDecimal.valueOf(Double.valueOf(request.getTotal())));
			transaksi.setSpendDate(date);
			transaksi.setSpendDetail(request.getDeskripsi());
			transaksi.setSpendName(request.getName());
			transaksi.setCategory(request.getCategory());

			log.info(objectWriter.writeValueAsString(request));
			transaksiRepository.save(transaksi);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new TransaksiResponse(false);
			
		} catch (ParseException e) {
			e.printStackTrace();
			return new TransaksiResponse(false);
		}
		return getThisMonth();
	}

	@Override
	public String total() {
		return transaksiRepository.getTotal();
	}
	
	@Override
	public TransaksiResponse getAllTransaction() {
		
		List<Transaksi> transaksis = transaksiRepository.getAllTransaksi();
		String total = transaksiRepository.getTotal();
		return new TransaksiResponse(true,transaksis,total );
	}
	
	@Override
	public String totalSpecificMont(TotalRequest totalRequest) {
		String total = transaksiRepository.getTotalSpecificDate(totalRequest.getTanggal(),totalRequest.getTanggalAkhir());
		return total;
	}
	@Override
	public TransaksiResponse getThisMonth() {
		Calendar calendar = Calendar.getInstance();
        
        int monthNumber = calendar.get(Calendar.MONTH) + 1; // +1 karena Januari = 0
        String month = String.valueOf(monthNumber);
        int yearNumber = calendar.get(Calendar.YEAR); // +1 karena Januari = 0
        String year= String.valueOf(yearNumber);
		String total = transaksiRepository.getTotalSpecificMonth(month,year);
		List<Transaksi> transaksis = transaksiRepository.getTransaksiSpecificMonth(month,year);
		return new TransaksiResponse(true,transaksis,total);
	}
	@Override
	public TransaksiResponse getSpecificYear() {
		Calendar calendar = Calendar.getInstance();
		
		int yearNumber = calendar.get(Calendar.YEAR); // +1 karena Januari = 0
		String year= String.valueOf(yearNumber);
		String total = transaksiRepository.getTotalSpecificYear(year);
		List<Transaksi> transaksis   = transaksiRepository.getTransaksiSpecificYear(year);
		return new TransaksiResponse(true,transaksis,total);
	}

	@Override
	public TargetKeuangan totalFinancialPlan() {
		String rataRataSetahun = totalAverage();
		String pengeluaranSetahun = yearTotal();
		double pengeluaranInt = Double.valueOf(rataRataSetahun);
		double danaPensiunInt = pengeluaranInt*12*25;
		String danaPensiun=String.format("%.0f",danaPensiunInt);
		String danaPensiunRdpt;
		List<String> danaPensiunDeposito = new ArrayList<>();
//		double apalah;
		while(danaPensiunInt>(2*Math.pow(10, 9))) {
			danaPensiunInt = danaPensiunInt-(2*Math.pow(10, 9));
			danaPensiunDeposito.add(String.format("%.0f",2*Math.pow(10, 9)));
		}
		danaPensiunRdpt=String.format("%.0f", danaPensiunInt);
//		if(danaPensiunInt>(2*Math.pow(10, 9))) {
//			danaPensiunRdpt=String.format("%.0f", danaPensiunInt-(2*Math.pow(10, 9)));
//			apalah = (2*Math.pow(10, 9));
//			danaPensiunDeposito=String.format("%.0f",apalah);
//			
//		}else {
//			danaPensiunRdpt=String.format("%.0f", danaPensiunInt/2);
//			danaPensiunDeposito=String.format("%.0f",danaPensiunInt/2);
//		}
		double danaDaruratInt=pengeluaranInt*12;
		String danaDarurat=String.format("%.0f",danaDaruratInt);
		String danaDaruratRdpt=String.format("%.0f", danaDaruratInt - pengeluaranInt );
		String danaDaruratRdpu=rataRataSetahun;
//		apalah = (2*Math.pow(10, 7));
//		String danaDaruratDeposito=String.format("%.0f",apalah);
//		if(danaDaruratInt>(2*Math.pow(10, 7))) {
//			
//		} else {
//			
//		}
		
		DanaDarurat danaDarurats = new DanaDarurat("",danaDarurat,danaDaruratRdpt,danaDaruratRdpu);
		DanaPensiun danaPensiuns = new DanaPensiun("",danaPensiun,danaPensiunRdpt,danaPensiunDeposito); 
		TargetKeuangan targetKeuangan = new TargetKeuangan(true,danaPensiuns,danaDarurats,pengeluaranSetahun,rataRataSetahun);
		return targetKeuangan;
	}
	
	public String yearTotal() {
		Date dateToday = new Date();
		Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        Date dateLastYear = calendar.getTime();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		String formattedDateToday = formatter.format(dateToday);
		String formattedDateLastYear = formatter.format(dateLastYear);

		TotalRequest request = new TotalRequest();
		request.setTanggalAkhir(formattedDateToday);
		request.setTanggal(formattedDateLastYear);
		return  totalSpecificMont(request);
	}

	@Override
	public String totalAverage() {
		String lastYearString = yearTotal();
		double latestYear = Double.valueOf(lastYearString);
		double average = latestYear/12;
		BigDecimal bd = new BigDecimal(average);
		bd = bd.setScale(2, RoundingMode.CEILING);
		String averageString=String.format("%.0f", bd);;
		return averageString;
	}

	@Override
	public TransaksiResponse getSpecifictRequestTransaction(TotalRequest totalRequest) {
		List<Transaksi> transaksis = transaksiRepository.getSpecificDateTransaksi(totalRequest.getTanggal(),totalRequest.getTanggalAkhir());
		String total = transaksiRepository.getTotalSpecificDate(totalRequest.getTanggal(),totalRequest.getTanggalAkhir());
		return new TransaksiResponse(true,transaksis,total );
	}



}
