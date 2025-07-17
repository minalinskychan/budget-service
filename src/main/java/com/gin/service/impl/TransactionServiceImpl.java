package com.gin.service.impl;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.gin.controller.CallbackSkdsController;
import com.gin.model.Siskeudes;
import com.gin.model.SkdsBilling;
import com.gin.model.SkdsBuktiBayar;
import com.gin.repository.SiskeudesRepository;
import com.gin.repository.SkdsBillingRepository;
import com.gin.repository.SkdsBuktiBayarRepository;
import com.gin.repository.TransaksiRepository;
import com.gin.request.DaftarPotonganDaerah;
import com.gin.request.DaftarPotonganMpn;
import com.gin.request.PostingSkdsCallbackRequest;
import com.gin.request.TransactionRequest;
import com.gin.response.CallbackResponse;
import com.gin.service.SiskeudesService;
import com.gin.service.TransactionBudgetService;
import com.gin.util.Constants;
import com.gin.util.GeneratorUtil;

@Service("transactionBudgetService")
public class TransactionServiceImpl implements TransactionBudgetService {


	public static ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
	
	@Autowired
	private SiskeudesRepository siskeudesRepository;
	@Autowired
	private SkdsBuktiBayarRepository skdsBuktiBayarRepository;
	@Autowired
	private SkdsBillingRepository skdsBillingRepository;
	
	@Autowired
	private TransaksiRepository transaksiRepository;
	
	private final String TIMEOUT = "TIMEOUT";

	private static final Logger log = (Logger) LoggerFactory.getLogger(CallbackSkdsController.class);
	@Override
	public CallbackResponse callback(PostingSkdsCallbackRequest request) {
		Siskeudes detail = siskeudesRepository.findByid(request.getTransactionId());
		try {
			request.getTransactionId();
			detail.setStatus(Constants.RELEASE);
			siskeudesRepository.save(detail);
			List<SkdsBuktiBayar> receipts = skdsBuktiBayarRepository.findBySkds(request.getTransactionId());
			log.info(Constants.objectWriter.writeValueAsString( request));
			if(request.getResponse_code().equals(Constants.RC_SUCCESS)) {
				Set<DaftarPotonganDaerah> billingDaerah = request.getData().iterator().next().getDaftar_potongan_daerah();
				Set<DaftarPotonganMpn> billingMpn = request.getData().iterator().next().getDaftar_potongan_mpn();
				if (billingDaerah!=null && billingDaerah.size()>0){
					for	(DaftarPotonganDaerah bill : billingDaerah){
						for (SkdsBuktiBayar receipt : receipts){
							Set<SkdsBilling> billings = skdsBillingRepository.findByReceipt(receipt.getId());
							for (SkdsBilling billing : billings){
								if (bill.getKd_billing_potongan().equals(billing.getBillingId())){
									billing.setTraceNumber(bill.getTrace_number());
									billing.setAreaCode(bill.getArea_code());
									billing.setAreaName(bill.getArea_name());
									billing.setTaxCode(bill.getTax_code());
									billing.setTaxSubjectName(bill.getTax_subject_name());
									billing.setPeriod(bill.getPeriod());
									billing.setInstallment(bill.getInstallment());
									billing.setTaxObjectName(bill.getTax_object_name());
									billing.setTaxObjectAddress(bill.getTax_object_address());
									billing.setDueDate(bill.getDue_date());
									billing.setCollectiveAmount(bill.getCollectiveAmount());
									billing.setPenaltyAmount(bill.getPenaltyAmount());
									billing.setAdminCharge(bill.getAdminCharge());
									billing.setTotalAmount(bill.getTotalAmount());
									billing.setSuccess(bill.getData_payment().isSuccess());
								}
								skdsBillingRepository.save(billing);
							}
						}
					}
					if (billingMpn!=null && billingMpn.size()>0){
						for	(DaftarPotonganMpn bill : billingMpn){
							for (SkdsBuktiBayar receipt : receipts){
								Set<SkdsBilling> billings = receipt.getBillings();
								for (SkdsBilling billing : billings){
									if (bill.getKd_billing_potongan().equals(billing.getBillingId())){
										billing.setNtb(bill.getNtb());
										billing.setNtpn(bill.getNtpn());
										billing.setTglBukuNtpn(bill.getTgl_buku_ntpn());
										billing.setSuccess(bill.getData_payment().isSuccess());
										if (timeoutMpn(bill.getData_payment().getMessage())&&GeneratorUtil.pajakMpn(billing.getCode())) {
											billing.setMpnExecuteRc("08");
										} else {
											billing.setMpnExecuteRc("00");
										}
										
									}
									skdsBillingRepository.save(billing);
								}
								receipt.setBillings(billings);
							}
						}
					}
				}
			}

		} catch (Exception e) {
			detail.setStatus(Constants.FAILED);
			siskeudesRepository.save(detail);
			e.printStackTrace();
			return new CallbackResponse(false);
		}
		return new CallbackResponse(true);
	}

	public boolean timeoutMpn(String timeout){
		return timeout.toUpperCase().contains(TIMEOUT);
		
	}

	@Override
	public CallbackResponse tambah(TransactionRequest request) {
		try {
			log.info(objectWriter.writeValueAsString(request));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new CallbackResponse(true);
	}

}
