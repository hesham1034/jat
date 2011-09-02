package com.scommon.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.scommon.emnus.CommonStaticValues;

/**
 * note: diffrent new Date().getTime() and System.currentTimeMillis().
 * both get date of Long type, but the former not caculate millisecond
 * and the latter do it. so they get long is not equal.
 * @author Administrator
 *
 */
public class DateTimeUtils {
	/**
	 * return current datetime by string
	 * @return
	 */
	public static String getStringDate(String dateFormat){
		Date date = new Date();
		SimpleDateFormat sdf = null;
		try {
			sdf = new SimpleDateFormat(dateFormat);
		} catch (Exception e) {
			sdf = new SimpleDateFormat(CommonStaticValues.SYS_DATE_FORMAT);
		}
		return sdf.format(date);
	}
	/**
	 * return the date by string
	 * @param date
	 * @return string
	 */
	public static String getStringDate(Date date, String dateFormat){
		SimpleDateFormat sdf = null;
		try {
			sdf = new SimpleDateFormat(dateFormat);
		} catch (Exception e) {
			sdf = new SimpleDateFormat(CommonStaticValues.SYS_DATE_FORMAT);
		}
		return sdf.format(date);
	}

	/**
	 * return the current datetime by date type
	 * @return Date
	 */
	public static Date getDateTime(String dateFormat){
		Date date = new Date();
		Date newDate = null;
		SimpleDateFormat sdf = null;
		try {
			sdf = new SimpleDateFormat(dateFormat);
		} catch (Exception e) {
			sdf = new SimpleDateFormat(CommonStaticValues.SYS_DATE_FORMAT);
		}
		try {
			 newDate = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate;
	}
	
	/**
	 * convert date type from string to long
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static Long convertDateStringToLong(String date, String dateFormat){
		SimpleDateFormat sdf = null;
		Date newDate = null;
		try {
			sdf = new SimpleDateFormat(dateFormat);
		} catch (Exception e) {
			sdf = new SimpleDateFormat(CommonStaticValues.SYS_DATE_FORMAT);
		}
		try {
			newDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();   
		}
		return newDate.getTime();
	}
	
	/**
	 * convert date type from long to string
	 * @param date
	 * @param format
	 * @return
	 */
	public static String convertDateLongToString(Long date, String dateFormat){
		SimpleDateFormat sdf = null;
		try {
			sdf = new SimpleDateFormat(dateFormat);
		} catch (Exception e) {
			sdf = new SimpleDateFormat(CommonStaticValues.SYS_DATE_FORMAT);
		}
		Date newDate = new Date(date);
		return sdf.format(newDate);
	}
}
