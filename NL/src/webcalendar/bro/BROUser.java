package webcalendar.bro;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.twmacinta.util.MD5;

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
	
	public User getUserByUserName(String userName) {
		
		Query q=session.createQuery("from User where userName =:userName");
		q.setParameter("userName", userName);
		List<User> users=(List<User>)q.list();
			
		if(users!=null && users.size()>0){
			return users.get(0);	
		}
		return null;
	}
	
	private String getHashInHex(String str) {
		
		MD5 md5 = new MD5();
		 
	    try {
			md5.Update(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {			
		}
	    String hash = md5.asHex();

	    return hash;
	}
	
	public void registerUser(String login, String password, String name, String surname) {
		User user=new User();
		user.setName(name);
		user.setSurname(surname);
		user.setUserName(login);
		user.setPassword(getHashInHex(password));
		session.save(user);
	}
	
	public boolean checkAuthentication(String login, String password) {
		
		Query q=session.createQuery("from User where userName =:userName AND password =:password");
		q.setParameter("userName", login);
		q.setParameter("password", getHashInHex(password));
		List<User> users=(List<User>)q.list();

		return users!=null && users.size()>0;
	}
	
	
}
