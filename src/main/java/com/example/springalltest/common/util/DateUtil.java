package com.example.springalltest.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * 
 * @author w 
 * 日期格式统一为"yyyy-MM-dd HH:mm:ss"
 * @version 1.0
 */

public class DateUtil {
	/**
	 * 三个 时间 格式
	 */
	public static final String FORMATER_YEAR_MONTH_DAY = "yyyy-MM-dd";
	public static final String DEFAULT_TIEMSTAMP_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String STRING_TIEMSTAMP_PATTERN = "yyyyMMddHHmmss";
	/**
	 * 三个日期域
	 */
	public static final int YEAR = 1;
	public static final int MONTH = 2;
	public static final int DAY = 3;

	/**
	 * 获取当前日期时间
	 * @return
	 */
	public static String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_TIEMSTAMP_PATTERN);
		return sdf.format(date);
	}
	/**
	 * 获取当前日期时间
	 * @return
	 */
	public static String getStringDate(){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(STRING_TIEMSTAMP_PATTERN);
		return sdf.format(d);
	}
	/**
	 * 获取当前日期
	 * @return
	 */
	public static String getCurrentDateDay(){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATER_YEAR_MONTH_DAY);
		return sdf.format(d);
	}
	/**
	 * 返回当前 年份
	 * 
	 * @return
	 */
	public static int getCurYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	/**
	 * 返回当前 月份
	 * 
	 * @return
	 */
	public static int getCurMonth() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * 返回当前 天数
	 * 
	 * @return
	 */
	public static int getCurDay() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DATE);
	}

	/**
	 * 修改日期的 年，月，日
	 * @param paramDate(日期,如果为null,则默认为当前日期)
	 * @param dateField(需要改变的域)
	 * @param count(需要改变的数量)
	 * @return
	 * @throws ParseException
	 */
	public static String changeDate(String paramDate, int dateField, int count)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_TIEMSTAMP_PATTERN);
		Calendar cal = Calendar.getInstance();
		Date date = null;
		if (StringUtil.isEmpty(paramDate)) {
			date = new Date();
		} else {
			date = sdf.parse(paramDate);
		}
		cal.setTime(date);
		if (count != 0) {
			if (dateField == YEAR) {
				cal.add(Calendar.YEAR, count);
			} else if (dateField == MONTH) {
				cal.add(Calendar.MONTH, count);
			} else if (dateField == DAY) {
				cal.add(Calendar.DATE, count);
			}
		}
		return sdf.format(cal.getTime());
	}
	/**
	 * 获取日期的 年，月，日
	 * @param paramDate(日期,如果为null,则默认为当前日期)
	 * @param dateField(需要获得的域)
	 * @return
	 * @throws ParseException
	 */
	public static String getDateField(String paramDate,int dateField) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_TIEMSTAMP_PATTERN);
		Calendar cal = Calendar.getInstance();
		Date date = null;
		if (StringUtil.isEmpty(paramDate)) {
			date = new Date();
		} else {
			date = sdf.parse(paramDate);
		}
		cal.setTime(date);
		String result = StringUtil.DEFAULT_EMPTY_STRING;
		if (dateField == YEAR) {
			result += cal.get(Calendar.YEAR);
		} else if (dateField == MONTH) {
			result += (cal.get(Calendar.MONTH) + 1);
		} else if (dateField == DAY) {
			result += cal.get(Calendar.DATE);
		}
		return result;

	}
}
