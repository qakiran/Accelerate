package com.fiserv.framework.utility ;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime  {

	/**
	 * @author dhiraj.bendale
	 * @param timeFormat
	 * @return
	 */
	public static String getCurrentTime(String timeFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
		Calendar cal = Calendar.getInstance();
		return sdf.format(cal.getTime());
	}
	
	/**
	 * @author swapnil.mane
	 * @param dateFormat
	 * @return
	 */
	public String getCurrentDate(String dateFormat) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		Date date = new Date();
		return formatter.format(date).trim();
	}
	
	/**
	 * @author swapnil.mane
	 * @param dateFormat,number,type
	 * @return
	 */
	public static String getRequiredDate(String dateFormat, int number, String type) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		if(type.equalsIgnoreCase("Date")){
			c.add(Calendar.DATE, number);
			}else if(type.equalsIgnoreCase("Month")){
			c.add(Calendar.MONTH, number);
		}else{
			c.add(Calendar.YEAR, number);
		}
		return formatter.format(c.getTime());
	}
	
}
