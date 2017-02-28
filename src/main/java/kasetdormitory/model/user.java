package kasetdormitory.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="user")
public class user {
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String pass;
	
	@Column(name = "status")
	private String status;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
	private List<comment> user;
	
	public List<comment> getUser() {
		return user;
	}

	public void setUser(List<comment> user) {
		this.user = user;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public user() {
		super();
	}

	public user(long id) {
		super();
		this.id = id;
	}

	public user(String name, String email, String pass, String status) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.status = status;
	}

	
	
	public user(String name, String email, String pass, String status, List<comment> user) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.status = status;
		this.user = user;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + ", status=" + status
				+ ", user=" + user + "]";
	}
		
}
