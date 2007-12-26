package webcalendar.bdo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "USER")
public class User 
{
	@Id
	@Column(name="id")
	private int id;	
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User: id="+id+", name="+name+", age="+age;	
	}

}
