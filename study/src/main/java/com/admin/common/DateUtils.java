package com.admin.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	
	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern); 
		return format.format(date);
	}
	
	public static void main(String[] args) {
		System.out.println(formatDate(new Date(), "yyyyMMddHHmmss"));
	}

}
