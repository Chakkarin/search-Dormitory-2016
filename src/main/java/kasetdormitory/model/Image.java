package kasetdormitory.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String imge;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dorm_id")
	private dorm dorm;

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

	public String getImge() {
		return imge;
	}

	public void setImge(String imge) {
		this.imge = imge;
	}

	public Image() {
		super();
	}

	public Image(long id) {
		super();
		this.id = id;
	}

	public Image(String imge) {
		super();
		this.imge = imge;
	}

	public Image(String imge, kasetdormitory.model.dorm dorm) {
		super();
		this.imge = imge;
		this.dorm = dorm;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", imge=" + imge + ", dorm=" + dorm + "]";
	}

}
