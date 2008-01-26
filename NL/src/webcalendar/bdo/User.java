package webcalendar.bdo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "uzivatel")
public class User 
{
	@Id
	@Column(name="OID____")
	private int oid;	
	
	
	@Column(name="JMENO__")
	private String name;
	
	@Column(name="PRIJMENI")
	private String surname;
	
	@Column(name="UZIV_JM")
	private String userName;
	
	@Column(name="HESLO__")
	private String password;	
	
	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}		

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Uzivatel: oid="+oid+", name="+name+", surname="+surname+", userName="+userName+", password="+password;	
	}

}
