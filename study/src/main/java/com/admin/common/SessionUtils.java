package com.admin.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户登录后设置session的工具
 * 
 * @author frank
 * 
 * @since 2014-11-8
 *
 */
public class SessionUtils {

	private static final String USER_SESSION_KEY = "ut";
	
	private static final String ORDER_TOKEN_KEY = "order_token";
	
	/**
	 * 将登录的账号id放入到session中
	 * @param session
	 * @param loginId  登录后的mt4账号id
	 */
	public static void putLogin(HttpSession session, String loginId) {
		session.setAttribute(USER_SESSION_KEY, loginId);
	}
	
	/**
	 * 从session中获取登录的账号id
	 * @param session
	 * @return
	 */
	public static String getLoginId(HttpSession session) {
		return (String) session.getAttribute(USER_SESSION_KEY);
	}

	/**
	 * 从session中获取登录的账号id
	 * @param session
	 * @return
	 */
	public static String getLoginId(HttpServletRequest request) {
		return (String) request.getSession().getAttribute(USER_SESSION_KEY);
	}
	
	/**
	 * 判断用户是否登录
	 * @param session
	 * @return
	 */
	public static boolean isLogin(HttpSession session) {
		return getLoginId(session) != null;
	}
	
	public static void logout(HttpSession session) {
		session.invalidate();
	}
	
	/**
	 * 会话token
	 * @param session
	 * @param token
	 */
	public static void putToken(HttpSession session, String token) {
		session.setAttribute(ORDER_TOKEN_KEY, token);
	}
	
	public static String getToken(HttpSession session) {
		return (String) session.getAttribute(ORDER_TOKEN_KEY);
	}
}
