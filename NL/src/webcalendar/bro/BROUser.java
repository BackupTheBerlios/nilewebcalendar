package webcalendar.bro;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import webcalendar.bdo.User;


public class BROUser extends BROBase {

	public BROUser(Session session) {
		super(session);		
	}

	public User loadUser(int id) {
		
		User user = (User)session.load(User.class, Integer.valueOf(id));
		return user;
	}
	
	public void updateUser(User user) {
		
		session.update(user);
	}

	public void createUser(User user) {
		
		session.save(user);
	}
	
	public void deleteUser(User user) {
		
		session.delete(user);
	}
	
	public List<User> loadAllUsers() {
		
		Query q=session.createQuery("from User");
		List<User> users=(List<User>)q.list();
		
		return users;
	}	
	
}
