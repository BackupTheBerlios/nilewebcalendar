package webcalendar.bdo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
