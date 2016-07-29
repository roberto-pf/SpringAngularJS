package es.com.disastercode.springangularjs.business.service.criteria;


import java.io.Serializable;

public class CitySearchCriteria implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String country;

	public CitySearchCriteria() {
	}

	public CitySearchCriteria(String name) {
//		Assert.notNull(name, "Name must not be null");
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}