package webcalendar.bdo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skupina_udalosti")

public class EventGroup {

	@Id
	@GeneratedValue	
	@Column(name="OID____")
	private Integer oid;	
	
	@Column(name="NAZEV__")
	private String title;
	
	@Column(name="BARVA__")
	private String color;
	
	@Column(name="ZOBRAZ_")
	private boolean visible;
	
	@Column(name="AKTIV__")
	private boolean enable;
	
	@Column(name="OID_KAL")
	private Integer oidCalendar;
	
	@Column(name="OID_SKU")
	private Integer oidEventGroup;

	public int getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean getVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean getEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public int getOidCalendar() {
		return oidCalendar;
	}

	public void setOidCalendar(int oidCalendar) {
		this.oidCalendar = oidCalendar;
	}

	public Integer getOidEventGroup() {
		return oidEventGroup;
	}

	public void setOidEventGroup(Integer oidEventGroup) {
		this.oidEventGroup = oidEventGroup;
	}	
	
}
