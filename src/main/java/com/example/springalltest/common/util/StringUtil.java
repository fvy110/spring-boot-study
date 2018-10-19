package com.example.springalltest.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 * String 工具类 
 * 
 * @author w
 * 
 */
public class StringUtil {

	

	/**
	 * 默认空的字符串
	 */
	public static final String DEFAULT_EMPTY_STRING = "";
	
	public static final int HIGHEST_SPECIAL = '>';
	public static char[][] specialCharactersRepresentation = new char[HIGHEST_SPECIAL + 1][];
	static {
		specialCharactersRepresentation['&'] = "&amp;".toCharArray();
		specialCharactersRepresentation['<'] = "&lt;".toCharArray();
		specialCharactersRepresentation['>'] = "&gt;".toCharArray();
		specialCharactersRepresentation['"'] = "&#034;".toCharArray();
		specialCharactersRepresentation['\''] = "&#039;".toCharArray();
	}

	/**
	 * 判断字符串不为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (str == null || str.trim().length() == 0) {
			return false;
		}
		return true;

	}

	/**
	 * 
	 * 判断字符串为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.trim().length() == 0) {
			return true;
		}
		return false;

	}

	/**
	 * 截取字符串（split,regular）
	 * 
	 * @param value
	 * @param delimeters
	 * @return
	 */
	public static List<String> toList(String value, String delimeters) {
		List<String> list = new LinkedList<>();
		if (isEmpty(value)) {
			return list;
		}
		StringTokenizer st = new StringTokenizer(value, delimeters, false);
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		return list;
	}

	/**
	 * 将对象集合转化成字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String convertToQuestionMark(List<?> s) {
		if (s == null || s.size() == 0) {
			return DEFAULT_EMPTY_STRING;
		}
		StringBuffer buf = new StringBuffer();
		for (int index = 0; index < s.size(); index++) {
			buf.append("?,");
		}
		int end = buf.lastIndexOf(",");
		return buf.substring(0, end);
	}

	/**
	 * 
	 * 将对象数组转化成字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String convertToQuestionMark(Object[] s) {
		if (s == null || s.length == 0) {
			return DEFAULT_EMPTY_STRING;
		}
		StringBuffer buf = new StringBuffer();
		for (int index = 0; index < s.length; index++) {
			buf.append("?,");
		}
		int end = buf.lastIndexOf(",");
		return buf.substring(0, end);
	}

	/**
	 * 将字符串数组转化成字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String convertToStr(String[] s) {
		if (s == null || s.length == 0) {
			return DEFAULT_EMPTY_STRING;
		}
		StringBuffer buf = new StringBuffer();
		for (int index = 0; index < s.length; index++) {
			buf.append("'").append(s[index]).append("'").append(",");
		}
		int end = buf.lastIndexOf(",");
		return buf.substring(0, end);
	}

	/**
	 * 
	 * 将数字数组转化成字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String convertToStr(Long[] s) {
		if (s == null || s.length == 0) {
			return DEFAULT_EMPTY_STRING;
		}
		StringBuffer buf = new StringBuffer();
		for (int index = 0; index < s.length; index++) {
			buf.append(s[index]).append(",");
		}
		int end = buf.lastIndexOf(",");
		return buf.substring(0, end);
	}

	/**
	 * 
	 * 字符串数组里面包含某个字符串
	 * 
	 * @param arr
	 * @param item
	 * @return
	 */
	public static boolean exist(String[] arr, String item) {
		if (arr == null) {
			return false;
		}
		for (int index = 0; index < arr.length; index++) {
			String str = arr[index];
			if (str != null) {
				if (str.equals(item)) {
					return true;
				}
			} else {
				if (str == item) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * 描述?
	 * 
	 * @param buffer
	 * @return
	 */
	public static String escapeXml(String buffer) {
		int start = 0;
		int length = buffer.length();
		char[] arrayBuffer = buffer.toCharArray();
		StringBuffer escapedBuffer = null;

		for (int i = 0; i < length; i++) {
			char c = arrayBuffer[i];
			if (c <= HIGHEST_SPECIAL) {
				char[] escaped = specialCharactersRepresentation[c];
				if (escaped != null) {
					// create StringBuffer to hold escaped xml string
					if (start == 0) {
						escapedBuffer = new StringBuffer(length + 5);
					}
					// add unescaped portion
					if (start < i) {
						escapedBuffer.append(arrayBuffer, start, i - start);
					}
					start = i + 1;
					// add escaped xml
					escapedBuffer.append(escaped);
				}
			}
		}
		// no xml escaping was necessary
		if (start == 0) {
			return buffer;
		}
		// add rest of unescaped portion
		if (start < length) {
			escapedBuffer.append(arrayBuffer, start, length - start);
		}
		return escapedBuffer.toString();
	}

	/**
	 * 返回字符串的前20位
	 * 
	 * @param str
	 * @return
	 */
	public static String trimTo20Char(String str) {
		if (isEmpty(str)) {
			return DEFAULT_EMPTY_STRING;
		}
		if (str.length() > 20) {
			return str.substring(0, 20) + "...";
		}
		return str;

	}

	/**
	 * 
	 * 描述?
	 * 
	 * @param str
	 * @return
	 */
	public static String escapeVBS(String str) {
		if (str == null) {
			return DEFAULT_EMPTY_STRING;
		}
		StringBuffer sb = new StringBuffer();
		char ch;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch == '\"') {
				sb.append("\"&chr(34)&\"");
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 * 描述 ?
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceMatchAsSQL(String str) {
		if (isEmpty(str)) {
			return null;
		}
		boolean isOnlyWildcard = true;
		char[] chs = str.toCharArray();
		for (char ch : chs) {
			if (ch != '?' && ch != '*') {
				isOnlyWildcard = false;
				break;
			}
		}
		if (isOnlyWildcard) {
			return null;
		}
		return escapeSQL(str).replaceAll("\\*", "%").replaceAll("\\?", "_");
	}

	/**
	 * 
	 * 描述 ?
	 * 
	 * @param str
	 * @return
	 */
	public static String escapeSQL(String str) {
		boolean isWildcard = false;
		char[] chs = str.toCharArray();
		for (char ch : chs) {
			if (ch == '%' || ch == '_') {
				isWildcard = true;
				break;
			}
		}
		if (!isWildcard) {
			return str;
		}
		return str.replaceAll("%", "/%").replaceAll("_", "/_");
	}

	/**
	 * 给参数添加 下标
	 * 
	 * @param parameterSuffix
	 * @param parameterName
	 * @return
	 */
	public static String getParameter(Long parameterSuffix, String parameterName) {
		if (parameterSuffix == null || isEmpty(parameterName)) {
			return DEFAULT_EMPTY_STRING;
		}
		return parameterName + "_" + String.valueOf(parameterSuffix);
	}

	/**
	 * 
	 * ?
	 * 
	 * @param uri
	 * @return
	 */
	public static String decodeURI(String uri) {
		try {
			return URLDecoder.decode(uri, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 判断字符串是否是数字
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNumber(String value) {
		if (StringUtil.isEmpty(value)) {
			return false;
		}
		if (value.matches("[1-9]{1}[0-9]*")) {
			return true;
		}
		return false;
	}

	/**
	 * 判断一个对象是否为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		} else if (obj instanceof String
				&& (obj.equals(DEFAULT_EMPTY_STRING) || obj.equals("0"))) {
			return true;
		} else if (obj instanceof Number && ((Number) obj).doubleValue() == 0) {
			return true;
		} else if (obj instanceof Boolean && !((Boolean) obj)) {
			return true;
		} else if (obj instanceof Collection && ((Collection<?>) obj).isEmpty()) {
			return true;
		} else if (obj instanceof Map && ((Map<?, ?>) obj).isEmpty()) {
			return true;
		} else if (obj instanceof Object[] && ((Object[]) obj).length == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 删除StringBuilder中的最后一个逗号
	 * 
	 * @param sb
	 * @return
	 */
	public static StringBuilder exceptSplit(StringBuilder sb) {
		int len = sb.length();
		if (len > 0) {
			int str = (sb.lastIndexOf(",") + 1);
			if (len == str) {
				sb.deleteCharAt(len - 1);
			}
		}
		return sb;
	}

	/**
	 * 验证是否是 图片后缀
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean isImage(String fileName) {
		if (isEmpty(fileName)) {
			return false;
		}
		List<String> allowType = Arrays.asList("bmp", "png", "gif", "jpg",
				"jpeg", "pjpeg");
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1,
				fileName.length());
		return allowType.contains(suffix);
	}

	/**
	 * 产生一定长度的随机数
	 * 
	 * @param length
	 * @return
	 */
	public static String randomNumber(Integer length) {
		if (length == null || length <= 0) {
			return DEFAULT_EMPTY_STRING;
		}
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}

	/**
	 * 留下字符串的首/末 位
	 * 
	 * @param str
	 * @return
	 */
	public static String trimString(String str) {
		if (isEmpty(str)) {
			return DEFAULT_EMPTY_STRING;
		}
		if (str.length() <= 2) {
			return str;
		}
		String result = str.replace(str.substring(1, str.length() - 1), "***");
		return result;
	}
	
	

}
