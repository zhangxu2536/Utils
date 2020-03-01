package com.zhangxu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 日期工具类
 * 
 * 日期相关的操作都来找它
 * @author wanghd
 *
 */
public class DateUtil {
	
	/**
	 * 日期验证
	 * @param str
	 * @return
	 */
	public static boolean isDate(String str){
		String reg = "^[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
		return str.matches(reg);
	}
	
	
	/**
	 * 将Date转换成Calendar类型
	 * @param date
	 * @return
	 */
	public static Calendar dateToCalendar(Date date){
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		return instance;
	}
	
	/**
	 * 将String转换成Date
	 * @param str
	 * @return
	 */
	public static Date stringToDate(String str){
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 根据String类型日期算年龄
	 * @param date
	 * @return
	 */
	public static int getAge(String date){
		
		Date birthday = stringToDate(date);
		
		//将String转换成date类型
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		
		Calendar c2 = Calendar.getInstance();
		c2.setTime(birthday);
		
		int i = c.get(Calendar.YEAR);
		int i2 = c2.get(Calendar.YEAR);
		
		return i-i2;
	}
	
	/**
	 * 根据Date类型日期算年龄
	 * @param date
	 * @return
	 */
	public static int getAge(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		
		Calendar c2 = Calendar.getInstance();
		c2.setTime(date);
		
		int i = c.get(Calendar.YEAR);
		int i2 = c2.get(Calendar.YEAR);
		
		return i-i2;
	}
	
	
	
	/**
	 * 求未来日期离今天还剩的天数
	 * @param future
	 * @return
	 */
	public static int getFutureDays(String future){
		//当前时间
		Date date = new Date();
		long time = date.getTime();
		
		//未来时间
		Date date2 = stringToDate(future);
		long time2 = date2.getTime();
		
		long times = time2-time;
		System.out.println(times/1000/60/60/24);
		//将毫秒值转换成天数
		int day = (int)(times/1000/60/60/24);
		
		return day;
		
	}
	
	/**
	 * 判断给定的日期是否为今天
	 * @param str
	 * @return
	 */
	public static boolean isToDay(String str){
		//当前时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(date);
		Date da = stringToDate(format);
		long time = da.getTime();
		
		//未来时间
		Date date2 = stringToDate(str);
		long time2 = date2.getTime();
		
		long times = time2-time;
		System.out.println(times/1000/60/60/24);
		//将毫秒值转换成天数
		int day = (int)(times/1000/60/60/24);

		if(day ==0){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 日期比较
	 * @return
	 */
	public static boolean compareTo(Date date,Date date2){
		
		long time = date.getTime();
		
		long time2 = date2.getTime();
		
		return time-time2 > 0?true:false;
	}
	
	/**
	 * 判断当前给定的日期是否在本周之内
	 * @return
	 */
	public static boolean isDayInWeek(String date) {
		
		Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		int year = instance.get(Calendar.YEAR);
		int month = instance.get(Calendar.MONTH);
		int dayOfWeek = instance.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		
		Date stringToDate = stringToDate(date);
		Calendar dateToCalendar = dateToCalendar(stringToDate);
		int year1 = dateToCalendar.get(Calendar.YEAR);
		int month1 = dateToCalendar.get(Calendar.MONTH);
		int dayOfWeek1 = dateToCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		
		if(year==year1&&month==month1&&dayOfWeek==dayOfWeek1) {
			return true;
		}
		return false;
	}
	
	/***
	 * 给定时间对象，初始化到该年初的1月1日0时0分0秒0毫秒
	 */
	public static void  setInitDate(String str) {
		Date stringToDate = stringToDate(str);
		Calendar dateToCalendar = dateToCalendar(stringToDate);
		dateToCalendar.set(Calendar.MONTH, 1);
		dateToCalendar.set(Calendar.DAY_OF_YEAR, 1);
		dateToCalendar.set(Calendar.HOUR, 0);
		dateToCalendar.set(Calendar.MINUTE, 0);
		dateToCalendar.set(Calendar.SECOND, 0);
		dateToCalendar.set(Calendar.MILLISECOND, 0);
		
		System.out.println(dateToCalendar.getTime());
		
	}
	
	
	/**方法2：根据传入的参数获取该日期的月初日期，例如给定的日期为“2019-09-19 19:29:39”，返回“2019-09-01 00:00:00”*/
	public static Date getDateByMonthInit (Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		int year = ca.get(Calendar.YEAR);
		int mouth = ca.get(Calendar.MONTH);
		ca.clear();
		ca.set(Calendar.YEAR, year);
		ca.set(Calendar.MONTH, mouth);
		ca.set(Calendar.HOUR, 0);
		return ca.getTime();
	}
	
	/**方法3 :根据传入的参数获取该日器的月末日期，例如给定的日期为“2019-09-19 19:29:39”，返回“2019-09-30 23:59:59”，注意月大月小以及闰年。*/
	public static Date getDateByMonthLast(Date date){
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		int year = ca.get(Calendar.YEAR);
		int mouth = ca.get(Calendar.MONTH);
		ca.clear();
		ca.set(Calendar.HOUR, 0);
		ca.set(Calendar.YEAR, year);
		ca.set(Calendar.MONTH, mouth+1);
		Long time = ca.getTime().getTime();
		return new Date(time - 1);
	}
	
	/** 
	 * 随机一个时间  param:int类型的年份，随机日期在该年份之后
	 * */
	public static Date getRandomDate(int year){
		Calendar now = Calendar.getInstance();
		int nowYear = now.get(Calendar.YEAR);
		int nowMouth = now.get(Calendar.MONTH)+1;
		int nowDay = now.get(Calendar.DATE);
		
		Random rd = new Random();
		int newYear = rd.nextInt(nowYear - year+1)+year;
		int newMonth = 0;
		if(newYear == year){
			newMonth = rd.nextInt(nowMouth);
		}else{
			newMonth = rd.nextInt(13);
		}
		//newMonth = newMonth==0?newMonth+1:newMonth;
		int newDay = 0;
		if(newYear == year && newMonth==nowMouth){
			newDay = rd.nextInt(nowDay+1);
		}else{
			if(newMonth!=4){
				newDay = rd.nextInt(31);
			}else{
				newDay = rd.nextInt(29);
			}
		}
		newDay = newDay==0?newDay+1:newDay;
		Date date = new Date(rd.nextInt(1000*60*60*24));
		now.setTime(date);
		now.set(newYear, newMonth, newDay);
		return now.getTime();
	}
}
