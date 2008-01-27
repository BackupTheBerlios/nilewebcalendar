package webcalendar.bdo;

import java.text.DateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "udalost")

public class Event {
	
	@Id
	@GeneratedValue	
	@Column(name="OID____")
	private int oid;	
	
	@Column(name="NAZEV__")
	private String title;

	@Column(name="POPIS__")
	private String description;
	
	@Column(name="DAT_OD_")
	private DateFormat dateTimefrom;
	
	@Column(name="DAT_DO_")
	private DateFormat dateTimeTo;
	
	@Column(name="OID_SKU")
	private int oidGroup;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DateFormat getDateTimefrom() {
		return dateTimefrom;
	}

	public void setDateTimefrom(DateFormat dateTimefrom) {
		this.dateTimefrom = dateTimefrom;
	}

	public DateFormat getDateTimeTo() {
		return dateTimeTo;
	}

	public void setDateTimeTo(DateFormat dateTimeTo) {
		this.dateTimeTo = dateTimeTo;
	}

	public int getOidGroup() {
		return oidGroup;
	}

	public void setOidGroup(int oidGroup) {
		this.oidGroup = oidGroup;
	}	

}
