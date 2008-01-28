package webcalendar.bdo;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "kalendar")

public class Calendar {
	
	@Id
	@GeneratedValue	
	@Column(name="OID____")
	private int oid;	
	
	@Column(name="TYP_ZOB")
	private int visibilityType;
	
	@Column(name="OID_UZI")
	private int oidUser;
	
	@OneToMany(targetEntity=EventGroup.class, mappedBy="oidCalendar")
	private List<EventGroup> eventGroups;

    @OneToOne(targetEntity=webcalendar.bdo.User.class)
    @JoinColumn(name="OID_UZI", insertable=false, updatable=false)
	private User user;
	
	/*
	 * 	@ManyToOne(targetEntity=webcalendar.bdo.User.class)
	@JoinColumn(name="OID_UZI", nullable=false, updatable=false, insertable=false)

	 */
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user=user;
	}
	
	
	public List<EventGroup> getEventGroups() {
		return eventGroups;
	}

	public void setEventGroups(List<EventGroup> eventGroups) {
		this.eventGroups = eventGroups;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getVisibilityType() {
		return visibilityType;
	}

	public void setVisibilityType(int visibilityType) {
		this.visibilityType = visibilityType;
	}

	public int getOidUser() {
		return oidUser;
	}

	public void setOidUser(int oidUser) {
		this.oidUser = oidUser;
	}	

}
