package beans;

import java.util.List;

public class Food {

	private Integer fID;
	private String fName;
	private Double fPrice;
	private Integer fCityID;
	private String fDescription;
	private List<City> cityList;

	public Food(Integer fID, String fName, Double fPrice, Integer fCityID, String fDescription) {
		super();
		this.fID = fID;
		this.fName = fName;
		this.fPrice = fPrice;
		this.fCityID = fCityID;
		this.fDescription = fDescription;
	}

	public Food(String fName, Double fPrice, Integer fCityID, String fDescription) {
		super();
		this.fName = fName;
		this.fPrice = fPrice;
		this.fCityID = fCityID;
		this.fDescription = fDescription;
	}

	public Integer getfID() {
		return fID;
	}

	public void setfID(Integer fID) {
		this.fID = fID;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public Double getfPrice() {
		return fPrice;
	}

	public void setfPrice(Double fPrice) {
		this.fPrice = fPrice;
	}

	public Integer getfCityID() {
		return fCityID;
	}

	public void setfCityID(Integer fCityID) {
		this.fCityID = fCityID;
	}

	public String getfDescription() {
		return fDescription;
	}

	public void setfDescription(String fDescription) {
		this.fDescription = fDescription;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	@Override
	public String toString() {
		return "Food [fID=" + fID + ", fName=" + fName + ", fPrice=" + fPrice + ", fCityID=" + fCityID
				+ ", fDescription=" + fDescription + ", cityList=" + cityList + "]";
	}

}
