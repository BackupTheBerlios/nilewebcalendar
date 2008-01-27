package webcalendar.bdo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prava_sdileni")

public class SharedRights {
	
	@Id
	@GeneratedValue	
	@Column(name="OID____")
	private int oid;
	
	@Column(name="OID_UZI")
	private int oidUser;
	
	@Column(name="OID_SKU")
	private int oidEventGroup;

	@ManyToOne(targetEntity=webcalendar.bdo.User.class)
	@JoinColumn(name="OID_UZI", nullable=false, updatable=false, insertable=false)
	private User user;
	
	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getOidUser() {
		return oidUser;
	}

	public void setOidUser(int oidUser) {
		this.oidUser = oidUser;
	}

	public int getOidEventGroup() {
		return oidEventGroup;
	}

	public void setOidEventGroup(int oidEventGroup) {
		this.oidEventGroup = oidEventGroup;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
