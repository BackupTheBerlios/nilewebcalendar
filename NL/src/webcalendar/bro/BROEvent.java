package webcalendar.bro;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import webcalendar.bdo.Calendar;
import webcalendar.bdo.Event;
import webcalendar.bdo.EventGroup;


public class BROEvent extends BROBase {

	public BROEvent(Session session) {
		super(session);		
	}

	//metoda pro ulozeni nove udalosti
	public void saveEvent(Event event){
		
		session.save(event);
		
	}	
	
	//metoda pro smazani stavajici udalosti
	public void deleteEvent(int eventId){
		
		Event event = new Event();
		event.setOid(eventId);
		session.delete(event);	
		
	}
	
	//metoda pro upravu udalosti
	public void updateEvent (Event event){
		
		session.update(event);
	}
	
	public Event loadEvent(int id) {
		
		Event event = (Event)session.load(Event.class, Integer.valueOf(id));
		return event;
	}
	
	public List<Event> loadEventsForCalendarAndDate(int calendarId, Date date) {
		
		List<Event> events=new ArrayList<Event>();
		
		Calendar calendar=new BROCalendar(session).loadCalendar(calendarId);
		
		List<EventGroup> eventGroups=calendar.getEventGroups();
		for (EventGroup eventGroup : eventGroups) {
			
			if (eventGroup.getVisible() && eventGroup.getEnable()){
				
				List<Event> groupEvents=loadEventsForDate(eventGroup.getOid(),date);	
				for (Event event:groupEvents) {
					events.add(event);
				}
			}
		}
		
		

		return events;
	}
	
	public List<Event> loadEventsForDate(int eventGroupId,Date date) {
		
		Date dateFrom=new Date(date.getTime());
		dateFrom.setHours(0);
		dateFrom.setMinutes(0);
		dateFrom.setSeconds(0);
		Date dateTo=new Date(date.getTime());
		dateTo.setHours(24);
		dateTo.setMinutes(0);
		dateTo.setSeconds(0);		
		
		Query query= session.createQuery("from Event where oidEventGroup=:oidEventGroup and dateTimeFrom>= :from and dateTimeFrom< :to");
		query.setParameter("oidEventGroup", eventGroupId);
		query.setParameter("from", dateFrom);
		query.setParameter("to", dateTo);

		return (List<Event>)query.list();
	}
	
		
}

