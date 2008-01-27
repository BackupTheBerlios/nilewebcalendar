package webcalendar.bro;

import org.hibernate.Session;

import webcalendar.bdo.Calendar;

public class BROCalendar extends BROBase {

	public BROCalendar(Session session) {
		super(session);		
	}
	
	public void createCalendar(Calendar calendar){
		session.save(calendar);
	}
	
	public Calendar loadCalendar(int id) {
		
		Calendar calendar = (Calendar)session.load(Calendar.class, Integer.valueOf(id));
		return calendar;
	}

}
