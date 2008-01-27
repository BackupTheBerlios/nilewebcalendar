package webcalendar.bro;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import webcalendar.bdo.EventGroup;
import webcalendar.bdo.SharedRights;
import webcalendar.bdo.User;

public class BROEventGroup extends BROBase {

	public BROEventGroup(Session session) {
		super(session);		
	}
	
	//metoda pro ziskani event groupy
	public EventGroup loadEventGroup(int id) {
		
		EventGroup eventGroup = (EventGroup)session.load(EventGroup.class, Integer.valueOf(id));
		return eventGroup;
	}
	
	//metoda nastaveni prav pro sdileni event groupy vlastnika ostatnim uzivatelum
	public boolean addRightsForUser(int eventGroupId, String userName){
		
		//TODO pridat kontrolu na duplicitu uzivatele nebo prirazeni sama sobe
		
		BROUser broUser=new BROUser(session);		
		User user=broUser.getUserByUserName(userName);
		if (user!=null) {
			//uzivatel nalezen
			
			SharedRights sharedRights = new SharedRights();
			sharedRights.setOidEventGroup(eventGroupId);
			sharedRights.setOidUser(user.getOid());
			session.save(sharedRights);
			
			return true;
		}
		//uzivatel nenalezen
		return false;
	}
	
	
	//metoda pro upravu event groupy
	public void updateEventGroup(EventGroup eventGroup) {
		
		session.update(eventGroup);
	}
	
	
	//metoda pro zruseni prav ostatnim uzvitelum na vlastnikovu event groupu
	public void deleteSharedRights(int sharedRightsId){
		
		SharedRights sharedRights = new SharedRights();
		sharedRights.setOid(sharedRightsId);
		session.delete(sharedRights);
	}
	
	public List<SharedRights> loadAllUsersWithRights(){
		
		//select UZIV_JM from uzivatel, prava_sdileni where uzivatel.OID____ = prava_sdileni.OID_UZI;
		
		Query q=session.createQuery("from SharedRights");
		List<SharedRights> usersWithRights=(List<SharedRights>)q.list();
		
		return usersWithRights;				
	}
	
}
