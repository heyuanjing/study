package com.admin.common;

/**
 * @description 数组操作工具类
 * 
 * @author frank
 *
 */
public class ArrayUtils {

	/**
	 * 是否包含
	 */
	public static boolean contains(Object[] arrays, Object obj) {
		if (arrays != null && arrays.length > 0) {
			for (Object o : arrays) {
				if (o.equals(obj)) {
					return true;
				}
			}
		}
		return false;
	}
}
