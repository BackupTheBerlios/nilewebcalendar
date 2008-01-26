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
	private int oid;	
	
	@Column(name="NAZEV__")
	private String title;
	
	@Column(name="BARVA__")
	private String color;
	
	@Column(name="ZOBRAZ_")
	private int visible;
	
	@Column(name="AKTIV__")
	private int enable;
	
	@Column(name="OID_KAL")
	private int oidCalendar;
	
	@Column(name="OID_SKU")
	private Integer oidEventGroup;

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getVisible() {
		return visible;
	}

	public void setVisible(int visible) {
		this.visible = visible;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
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
