package webcalendar.bro;

import org.hibernate.Session;

import webcalendar.bdo.EventGroup;

public class BROEventGroup extends BROBase {

	public BROEventGroup(Session session) {
		super(session);		
	}
	
	public EventGroup loadEventGroup(int id) {
		
		EventGroup eventGroup = (EventGroup)session.load(EventGroup.class, Integer.valueOf(id));
		return eventGroup;
	}
	
	public void updateEventGroup(EventGroup eventGroup) {
		
		session.update(eventGroup);
	}

}
