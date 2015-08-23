package com.viettel.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;



/**
 * 
 * @author hieuph
 *
 */
public class DateUtils {


	public static DateUtils instance = null;

	private DateUtils() {
	}

	public static DateUtils getInstance() {
		if (instance == null) {
			instance = new DateUtils();
		}
		return instance;
	}

	public Long getCurrentTime() {
		Long time = 0L;
		try {
			time = HibernateUtil.getSysdate().getTime();
		} catch (Exception e) {
		}
		return time;
	}

	@SuppressWarnings("deprecation")
	public String millisToDate(Long millis) {
		String result = "";
		Date date = new Date(millis);
		int day = date.getDay();
		int year = date.getYear();
		int month = date.getMonth();
		int minute = date.getMinutes();
		int hour = date.getHours();
		int second = date.getSeconds();

		result = day + "/" + (month + 1) + "/" + (year + 1990) + " " + hour
				+ ":" + minute + ":" + second;
		return result;
	}

	public Date getCurrentDate() {
		Date date = null;
		try {
			date = HibernateUtil.getSysdate();
		} catch (Exception e) {
		}
		return date;
	}

	/**
	 * @param invitedDate
	 * @return
	 */
	public Long getInvitedMinute(Date invitedDate) {
		Long minute = 0L;
		if (invitedDate == null) {
			return 0L;
		}

		minute = (getCurrentTime() - invitedDate.getTime()) / 1000 / 60;
		return minute;
	}

	public String getInvitedMinuteString(Date invitedDate) {
		if (invitedDate == null) {
			return "0 minute";
		}
		Date current = getCurrentDate();

		long diff = current.getTime() - invitedDate.getTime();// as given
		long days = TimeUnit.MILLISECONDS.toDays(diff);
		long hours = TimeUnit.MILLISECONDS.toHours(diff);
		hours = (hours % 24);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
		minutes = minutes % 60;

		if (days == 0 && minutes == 0 && hours == 0)
			return " 0 minute";

		String messDay = days > 1 ? days + " days " : (days == 1 ? "1 day "
				: "");
		String messHour = hours > 1 ? hours + " hours "
				: (minutes == 1 ? "1 hour " : "");
		String messMinute = minutes > 1 ? minutes + " minutes "
				: (minutes == 1 ? "1 minute " : "");
		String result = messDay + messHour + messMinute;

		return result;
	}

	public String getInvitedMinuteString2(Date invitedDate) {
		if (invitedDate == null) {
			return "0 minute";
		}
		Date current = getCurrentDate();

		long diff = current.getTime() - invitedDate.getTime();// as given
		long minutes = diff / (60 * 1000) % 60;
		long hours = diff / ((60 * 1000) % 60) % 24;
		long days = diff / (((60 * 1000) % 60) % 24) % 365;

		if (days == 0 && minutes == 0 && hours == 0)
			return "0 minute";

		String messDay = days > 1 ? days + " days" : (days == 1 ? "1 day" : "");
		String messHour = hours > 1 ? hours + " hours"
				: (minutes == 1 ? "1 hour" : "");
		String messMinute = minutes > 1 ? minutes + " minutes"
				: (minutes == 1 ? "1 minute" : "");
		String result = messDay + messHour + messMinute;

		return result;
	}

	public String formatDay(Date date) {
		SimpleDateFormat format2 = new SimpleDateFormat("MMMM dd, yyyy");
		return format2.format(date);
	}

}
