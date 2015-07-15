package com.admin.common;

import java.util.Date;
import java.util.Random;

/**
 * 订单号生成器工具
 * 
 * @author xiaocilin
 * 
 * @since 2014-11-25
 *
 */
public class GenerateOrder {

	public static String getTransferOrderId(Date createDate, int login) {
		return "T" + DateUtils.formatDate(createDate, "yyyyMMddHHmmss") + "" + login + "" + getRandNum();
	}
	
	public static String geWithdrawOrderId(Date createDate, int login) {
		return "W" + DateUtils.formatDate(createDate, "yyyyMMddHHmmss") + "" + login + "" + getRandNum();
	}
	
	public static String getDepositOrderId(Date createDate, int login) {
		return "D" + DateUtils.formatDate(createDate, "yyyyMMddHHmmss") + "" + login + "" + getRandNum();
	}
	
	public static String getOrderToken(Date now, String login) {
		return now.getTime()/1000 + "" + login;
	}
	
	private static int getRandNum(){
		return new Random().nextInt(9999);
	}
	
	public static void main(String[] args) {
		String orderId = getTransferOrderId(new Date(), 750010);
		System.out.println(orderId);
		
		System.out.println(getOrderToken(new Date(), "750010"));
	}
}
