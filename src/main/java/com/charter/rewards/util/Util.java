package com.charter.rewards.util;



import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Slf4j
public class Util {


	public static String getDateAsString(Date date) {
		return new SimpleDateFormat("dd MMMM yyyy").format(date);
	}

	public static String generateTransactionID(String uniqueCode) {
		Random random = new Random();
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss");
		return uniqueCode + simpleDateFormat.format(date) + getRandomNumber(100000000L, 999999999L, random);
	}

	public static String getRandomNumber(long aStart, long aEnd, Random aRandom) {
		long range = aEnd - aStart + 1L;
		long fraction = (long)(range * aRandom.nextDouble());
		Long randomNumber = Long.valueOf(fraction + aStart);
		return randomNumber.toString();
	}

}
