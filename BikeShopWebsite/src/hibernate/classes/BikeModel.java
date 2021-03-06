package hibernate.classes;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;



@NamedQueries({
	@NamedQuery(name = BikeModel.QUERY_BY_NAME, query = "from BikeModel where name = :name"),
	@NamedQuery(name = BikeModel.QUERY_ALL, query = "from BikeModel")
})
@Entity
//TODO: change database name before production
@Table(name = "bike_model", catalog = "hibernate_test_database")
public class BikeModel implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String QUERY_BY_NAME = "BikeModel.By.Name";
	public static final String QUERY_ALL = "BikeModel.All";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	
	@Column
	private String name;

	@Column
	private String price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@Column
	private String image;
	
	@OneToMany(mappedBy = "bikeModel")
	@Cascade(CascadeType.ALL)
	private Set<Bike> bikes = new HashSet<>();
	
	// default constructor for hibernate
	public BikeModel() {
		super();
	}

	public BikeModel(String name, String price, Brand brand, String image) {
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public void addBike(Bike bike) {
		bikes.add(bike);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
