package beans;

public class City {

	private Integer cID;
	private Integer cityID;
	private String cityName;
	private Food food;

	public City(Integer cID, Integer cityID, String cityName) {
		super();
		this.cID = cID;
		this.cityID = cityID;
		this.cityName = cityName;
	}

	public Integer getcID() {
		return cID;
	}

	public void setcID(Integer cID) {
		this.cID = cID;
	}

	public Integer getCityID() {
		return cityID;
	}

	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "City [cID=" + cID + ", cityID=" + cityID + ", cityName=" + cityName + ", food=" + food + "]";
	}

}
