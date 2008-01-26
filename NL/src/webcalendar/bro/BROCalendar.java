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

}
