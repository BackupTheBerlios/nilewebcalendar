package webcalendar.bro;

import org.hibernate.Session;

public abstract class BROBase {

	protected final Session session;
	
	public BROBase(Session session) {
		this.session=session;
	}
	
}
