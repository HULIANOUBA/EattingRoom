package beans;

public class Dessert {

	private Integer id;
	private String name;
	private Double price;
	private String description;
	private String picurl;
	
	
	public Dessert() {
		super();
	}
	public Dessert(Integer id, String name, Double price, String description, String picurl) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.picurl = picurl;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	
}
