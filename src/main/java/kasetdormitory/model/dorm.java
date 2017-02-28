package kasetdormitory.model;


import java.util.Arrays;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "dorms")
public class dorm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "latitude")
	private double lati;

	@Column(name = "longitude")
	private double longi;

	@Column(name = "tel")
	private String tel;

	@Column(name = "price")
	private int price;

	@Column(name = "price_aqua")
	private int price_aqua;

	@Column(name = "price_fire")
	private int price_fire;
	
 	@Column(name = "dist")
	private String dist;

	@Column(name = "consume")
	private String[] consume;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private category category;	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "dorm",fetch = FetchType.LAZY)
	private List<Image> dormImg;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "dorm",fetch = FetchType.LAZY)
	private List<comment> dorms;

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

	public double getLati() {
		return lati;
	}

	public void setLati(double lati) {
		this.lati = lati;
	}

	public double getLongi() {
		return longi;
	}

	public void setLongi(double longi) {
		this.longi = longi;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice_aqua() {
		return price_aqua;
	}

	public void setPrice_aqua(int price_aqua) {
		this.price_aqua = price_aqua;
	}

	public int getPrice_fire() {
		return price_fire;
	}

	public void setPrice_fire(int price_fire) {
		this.price_fire = price_fire;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String[] getConsume() {
		return consume;
	}

	public void setConsume(String[] consume) {
		this.consume = consume;
	}

	public category getCategory() {
		return category;
	}

	public void setCategory(category category) {
		this.category = category;
	}

	public List<Image> getDormImg() {
		return dormImg;
	}

	public void setDormImg(List<Image> dormImg) {
		this.dormImg = dormImg;
	}

	public List<comment> getDorms() {
		return dorms;
	}

	public void setDorms(List<comment> dorms) {
		this.dorms = dorms;
	}

	public dorm() {
		super();
	}

	public dorm(long id) {
		super();
		this.id = id;
	}

	

	public dorm(String name, double lati, double longi, String tel, int price, int price_aqua, int price_fire,
			String dist, String[] consume, kasetdormitory.model.category category) {
		super();
		this.name = name;
		this.lati = lati;
		this.longi = longi;
		this.tel = tel;
		this.price = price;
		this.price_aqua = price_aqua;
		this.price_fire = price_fire;
		this.dist = dist;
		this.consume = consume;
		this.category = category;
	}

	@Override
	public String toString() {
		return "dorm [id=" + id + ", name=" + name + ", lati=" + lati + ", longi=" + longi + ", tel=" + tel + ", price="
				+ price + ", price_aqua=" + price_aqua + ", price_fire=" + price_fire + ", dist=" + dist + ", consume="
				+ Arrays.toString(consume) + ", category=" + category + ", dormImg=" + dormImg + ", dorms=" + dorms
				+ "]";
	}

	
	
}
