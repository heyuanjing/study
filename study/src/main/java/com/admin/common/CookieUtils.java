package com.admin.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

	/**
	 * 写cookie
	 * 
	 * @param response
	 * @param key
	 * @param value
	 * @param expiry
	 * @param pattern
	 */
	public static void put(HttpServletResponse response, String key,
			String value, int expiry, String pattern) {
		Cookie cookie = new Cookie(key, value);
		// 生命周期 :60*60*24*365
		cookie.setMaxAge(expiry);
		// 如果不设置setDomain(),将不能够写入cookie: www.***.com
		cookie.setDomain(pattern);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	/**
	 * 读cookie
	 * 
	 * @param request
	 * @param key
	 * @return
	 */
	public static String get(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equalsIgnoreCase(key)) {
				return cookie.getValue();
			}
		}
		return null;
	}

	/**
	 * 清空cookie
	 */
	public static void clear(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		try {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = new Cookie(cookies[i].getName(), null);
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		} catch (Exception ex) {
			System.out.println("清空Cookies发生异常！");
		}

	}

}
