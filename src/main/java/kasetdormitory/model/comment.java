package kasetdormitory.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String message;
	private int star;
	private Date commentDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private user user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dorm_id")
	private dorm dorm;
	
	public comment() {
		super();
	}

	public comment(long id) {
		super();
		this.id = id;
	}

	public comment(String message, int star) {
		super();
		this.message = message;
		this.star = star;
	}

	public comment(String message, int star, Date commentDate) {
		super();
		this.message = message;
		this.star = star;
		this.commentDate = commentDate;
	}
	
	public comment(String message, int star, Date commentDate, kasetdormitory.model.user user,
			kasetdormitory.model.dorm dorm) {
		super();
		this.message = message;
		this.star = star;
		this.commentDate = commentDate;
		this.user = user;
		this.dorm = dorm;
	}

	
	
	public comment(String message, int star, kasetdormitory.model.user user, kasetdormitory.model.dorm dorm) {
		super();
		this.message = message;
		this.star = star;
		this.user = user;
		this.dorm = dorm;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public dorm getDorm() {
		return dorm;
	}

	public void setDorm(dorm dorm) {
		this.dorm = dorm;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}
	
	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "comment [id=" + id + ", message=" + message + ", star=" + star + ", commentDate=" + commentDate
				+ ", user=" + user + ", dorm=" + dorm + "]";
	}	
	
}
