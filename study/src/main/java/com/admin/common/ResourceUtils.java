package com.admin.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class ResourceUtils {
	
	/**
	 * 读取属性映射表
	 * @param propFile
	 * @return
	 */
	public static Properties getProperties(String propFile) {
		try {
			InputStream fis = new FileInputStream(new File(
					getResourcePath(propFile)));

			Properties properties = new Properties();
			properties.load(fis);

			fis.close();
			return properties;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
	
	/**
	 * 读取数据源xml地址
	 * @param fileName
	 * @return
	 */
	public static String getResourcePath(String fileName) {
		try {
			return URLDecoder.decode(Thread.currentThread()
					.getContextClassLoader().getResource(fileName).getPath(),
					"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	/**
	 * 读自定义的function.xml配置文件
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static String getResourceContent(String fileName) throws Exception {
		BufferedReader bis = new BufferedReader(new FileReader(getResourcePath(fileName)));
		String line = "";
		StringBuilder sb = new StringBuilder();
		while(StringUtils.isNotBlank((line =bis.readLine()))) {
			sb.append(line);
		}
		bis.close();
		return sb.toString();
	}
}
