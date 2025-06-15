package com.gin.util;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class GeneratorUtil {
    private static final AtomicLong counter = new AtomicLong(System.currentTimeMillis());
	private final static String KODEPAJAKMPN = "7.1.1";
	static String[] angkaTerbilang = { "", "Satu", "Dua", "Tiga", "Empat", "Lima", "Enam", "Tujuh", "Delapan",
			"Sembilan", "Sepuluh", "Sebelas" };

    public static String generateUUID() {
    	UUID uuid = UUID.randomUUID();
    	return uuid.toString();
    }
    
    public static boolean pajakMpn(String code){
		return code.startsWith(KODEPAJAKMPN);
		
	}
    public static String nullSafeNumber(Object object) {
		if (object == null || object.toString().isEmpty())
			return "0";

		return object.toString();
	}
    
    public static String angkaToTerbilang(Long angka) {
		if (angka < 12)
			return angkaTerbilang[angka.intValue()];
		if (angka >= 12 && angka <= 19)
			return angkaTerbilang[angka.intValue() % 10] + " Belas";
		if (angka >= 20 && angka <= 99)
			return angkaToTerbilang(angka / 10) + " Puluh " + angkaTerbilang[angka.intValue() % 10];
		if (angka >= 100 && angka <= 199)
			return "Seratus " + angkaToTerbilang(angka % 100);
		if (angka >= 200 && angka <= 999)
			return angkaToTerbilang(angka / 100) + " Ratus " + angkaToTerbilang(angka % 100);
		if (angka >= 1000 && angka <= 1999)
			return "Seribu " + angkaToTerbilang(angka % 1000);
		if (angka >= 2000 && angka <= 999999)
			return angkaToTerbilang(angka / 1000) + " Ribu " + angkaToTerbilang(angka % 1000);
		if (angka >= 1000000 && angka <= 999999999)
			return angkaToTerbilang(angka / 1000000) + " Juta " + angkaToTerbilang(angka % 1000000);
		if (angka >= 1000000000 && angka <= 999999999999L)
			return angkaToTerbilang(angka / 1000000000) + " Milyar " + angkaToTerbilang(angka % 1000000000);
		if (angka >= 1000000000000L && angka <= 999999999999999L)
			return angkaToTerbilang(angka / 1000000000000L) + " Triliun " + angkaToTerbilang(angka % 1000000000000L);
		if (angka >= 1000000000000000L && angka <= 999999999999999999L)
			return angkaToTerbilang(angka / 1000000000000000L) + " Quadrilyun "
					+ angkaToTerbilang(angka % 1000000000000000L);
		return "";
	}
    
    public static synchronized String generateRefNum(String prefix) {
        return prefix + counter.getAndIncrement();
    }

    public static String generateRandomNumber(int length) {
        Random random = new Random();
        StringBuilder generateNumber = new StringBuilder();

        for (int i = 0; i < length; i++) {
            generateNumber.append(random.nextInt(10));
        }

        return generateNumber.toString();
    }

    public static String filledLengthZeros(int lengthOfField, String textInsert) {
        String stringReturn;
        StringBuilder buffer = new StringBuilder();

        int lengthText;
        int loopZeros;

        lengthText = textInsert.trim().length();
        loopZeros = lengthOfField - lengthText;
        if ((lengthText < lengthOfField) || (lengthText == lengthOfField)) {
            buffer = new StringBuilder(textInsert);
            for (int a = 0; a < loopZeros; a++) {
                buffer.insert(0, "0");
            }
            stringReturn = buffer.toString().trim();
        } else {
            stringReturn = textInsert;
        }
        return stringReturn;
    }

//    public static String generateApprovalId() {
//        return Constants.d1.format(new Date()) + generateRandomNumber(3);
//    }
//
//    public static String generateTransactionId() {
//        return Constants.d1.format(new Date()) + generateRandomNumber(3);
//    }

    public static String generateTransactionDetailId(String transactionId, int idxData) {
        return transactionId + filledLengthZeros(4, String.valueOf(idxData));
    }

    public static String getUserId(String cif, String accountNumber) {
        return cif + accountNumber;
    }
    
    public static String getTimeStamp() {
    	return Constants.sdf4.format(new Date());
    }
}
