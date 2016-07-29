package es.com.disastercode.springangularjs.web.controller.resource;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.com.disastercode.springangularjs.business.entity.CityEntity;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CityResource extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idPk;
	private String name;
	private String state;
	private String country;
	private String map;
	private String successMessage;
	private String dangerMessage;

	public CityResource() {
	}

	public CityResource(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return this.name;
	}

	public String getState() {
		return this.state;
	}

	public String getCountry() {
		return this.country;
	}

	public String getMap() {
		return this.map;
	}


	public String getIdPk() {
		return idPk;
	}

	public void setIdPk(String idPk) {
		this.idPk = idPk;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getDangerMessage() {
		return dangerMessage;
	}

	public void setDangerMessage(String dangerMessage) {
		this.dangerMessage = dangerMessage;
	}

	@Override
	public String toString() {
		return getName() + "," + getState() + "," + getCountry();
	}
	
	
	
	public CityEntity populate(){
		CityEntity city = new CityEntity();
		
		city.setCountry( this.country );
		city.setName( this.name );
		city.setState( this.state );
		city.setMap( this.map );
		
		if(StringUtils.isNotBlank(this.idPk))
			city.setId( Long.parseLong(this.idPk) );
		
		return city;
	}
	
	
	
	public void set(CityEntity city){
		this.country = city.getCountry();
		this.name = city.getName();
		this.state = city.getState();
		this.map = city.getMap();
		this.idPk = (city.getId()==null?null:city.getId().toString());
	}
	
}
