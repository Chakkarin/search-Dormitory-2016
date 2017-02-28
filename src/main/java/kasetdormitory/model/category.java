package kasetdormitory.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="categorys")
public class category {
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category",fetch = FetchType.LAZY)
    private List<dorm> categorys;
    
	public category() {
		super();
	}

	public category(long id) {
		super();
		this.id = id;
	}

	public category(String name) {
		super();
		this.name = name;
	}

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

	public List<dorm> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<dorm> categorys) {
		this.categorys = categorys;
	}

	@Override
	public String toString() {
		return "category [id=" + id + ", name=" + name + ", categorys=" + categorys + "]";
	}
	
	

	
}
