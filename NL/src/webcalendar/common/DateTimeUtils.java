package webcalendar.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

	public static Date toDate(String datestr, String timestr) {
		
		try {
			DateFormat df = new SimpleDateFormat ("dd.MM.yyyy HH:mm");
			return df.parse(datestr+" "+timestr);
			
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static String toStringDate(Date date) {
	
		DateFormat df = new SimpleDateFormat ("dd.MM.yyyy");		
		return df.format(date);
	}
	
	public static String toStringTime(Date date) {
		
		DateFormat df = new SimpleDateFormat ("HH:mm");		
		return df.format(date);
	}
	
	public static Date getStartOfWeekDate(Date date) {
		int dayOfWeek=date.getDay();
		Date tempDate=new Date();
		tempDate.setTime(date.getTime());
		tempDate.setDate(date.getDate()-dayOfWeek);
		return tempDate;
	}
	
	
}
