package com.gin.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.gin.response.AddTransaksiResponse;
import com.gin.response.BaseResponse;
import com.gin.response.DanaDarurat;
import com.gin.response.DanaPensiun;
import com.gin.response.TargetKeuangan;
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
	public AddTransaksiResponse tambah(TransactionRequest request) {
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
			return new AddTransaksiResponse(false);
			
		} catch (ParseException e) {
			e.printStackTrace();
			return new AddTransaksiResponse(false);
		}
		List<Transaksi> transaksis = transaksiRepository.findAll();
		return new AddTransaksiResponse(true,transaksis);
	}

	@Override
	public Double total() {
		return transaksiRepository.getTotal();
	}
	
	@Override
	public String totalSpecificMont(TotalRequest totalRequest) {
		String total = transaksiRepository.getTotalSpecificDate(totalRequest.getTanggal(),totalRequest.getTanggalAkhir());
		return total;
	}
	@Override
	public String totalSpecificMonth(String month,String year) {
		String total = transaksiRepository.getTotalSpecificMonth(month,year);
		return total;
	}
	@Override
	public String totalSpecificYear(String year) {
		String total = transaksiRepository.getTotalSpecificYear(year);
		return total;
	}

	@Override
	public TargetKeuangan totalFinancialPlan() {
		String pengeluaran = totalAverage();
		double pengeluaranInt = Double.valueOf(pengeluaran);
		double danaPensiunInt = pengeluaranInt*12*25;
		String danaPensiun=String.format("%.0f",danaPensiunInt);
		String danaPensiunRdpt;
		String danaPensiunDeposito;	
		double apalah;
		if(danaPensiunInt>(2*Math.pow(10, 9))) {
			danaPensiunRdpt=String.format("%.0f", danaPensiunInt-(2*Math.pow(10, 9)));
			apalah = (2*Math.pow(10, 9));
			danaPensiunDeposito=String.format("%.0f",apalah);
			
		}else {
			danaPensiunRdpt=String.format("%.0f", danaPensiunInt/2);
			danaPensiunDeposito=String.format("%.0f",danaPensiunInt/2);
		}
		double danaDaruratInt=pengeluaranInt*12;
		String danaDarurat=String.format("%.0f",danaDaruratInt);
		String danaDaruratRdpt=String.format("%.0f", danaDaruratInt - pengeluaranInt - (2*Math.pow(10, 7)));
		String danaDaruratRdpu=pengeluaran;
		apalah = (2*Math.pow(10, 7));
		String danaDaruratDeposito=String.format("%.0f",apalah);
		if(danaDaruratInt>(2*Math.pow(10, 7))) {
			
		} else {
			
		}
		
		DanaDarurat danaDarurats = new DanaDarurat("",danaDarurat,danaDaruratRdpt,danaDaruratRdpu,danaDaruratDeposito);
		DanaPensiun danaPensiuns = new DanaPensiun("",danaPensiun,danaPensiunRdpt,danaPensiunDeposito); 
		TargetKeuangan targetKeuangan = new TargetKeuangan(true,danaPensiuns,danaDarurats);
		return targetKeuangan;
	}

	@Override
	public String totalAverage() {
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
		String lastYearString = totalSpecificMont(request);
//		BigDecimal lastYear = new BigDecimal(lastYearString);
		double latestYear = Double.valueOf(lastYearString);
		double average = latestYear/12;
		BigDecimal bd = new BigDecimal(average);
		bd = bd.setScale(2, RoundingMode.CEILING);
//		String averageString=String.valueOf(average);
		String averageString=String.format("%.0f", bd);;
		
		return averageString;
	}

	@Override
	public void getAllSpend() {
		// TODO Auto-generated method stub
		
	}


}
