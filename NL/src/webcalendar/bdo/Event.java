package webcalendar.bdo;

import java.text.DateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "udalost")

public class Event implements Comparable<Event>{
	
	@Id
	@GeneratedValue	
	@Column(name="OID____")
	private Integer oid;	
	
	@Column(name="NAZEV__")
	private String title;

	@Column(name="POPIS__")
	private String description;
	
	@Column(name="DAT_OD_")
	private Date dateTimeFrom;
	
	@Column(name="DAT_DO_")
	private Date dateTimeTo;
	
	@Column(name="OID_SKU")
	private Integer oidEventGroup;

	@ManyToOne(targetEntity=EventGroup.class)
	@JoinColumn(name="OID_SKU", nullable=false, updatable=false, insertable=false)
	private EventGroup eventGroup;
	
	public Integer getOid() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateTimeFrom() {
		return dateTimeFrom;
	}

	public void setDateTimeFrom(Date dateTimeFrom) {
		this.dateTimeFrom = dateTimeFrom;
	}

	public Date getDateTimeTo() {
		return dateTimeTo;
	}

	public void setDateTimeTo(Date dateTimeTo) {
		this.dateTimeTo = dateTimeTo;
	}

	public Integer getOidEventGroup() {
		return oidEventGroup;
	}

	public void setOidEventGroup(Integer oidEventGroup) {
		this.oidEventGroup = oidEventGroup;
	}

	public int compareTo(Event o) {
		
		return this.dateTimeFrom.compareTo(dateTimeFrom);

	}

	public EventGroup getEventGroup() {
		return eventGroup;
	}

	public void setEventGroup(EventGroup eventGroup) {
		this.eventGroup = eventGroup;
	}

	
	
}
