package kasetdormitory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consume")
public class consu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public consu() {
		super();
	}

	public consu(long id) {
		super();
		this.id = id;
	}

	public consu(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "consu [id=" + id + ", name=" + name + "]";
	}
	
	 

}
