package es.com.disastercode.springangularjs.business.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.com.disastercode.springangularjs.business.entity.CityEntity;
import es.com.disastercode.springangularjs.business.service.criteria.CitySearchCriteria;

public interface CityService extends CrudService<CityEntity>  {

	public Page<CityEntity> findCities(CitySearchCriteria criteria, Pageable pageable);
	public Long countCities(CitySearchCriteria criteria);
	public CityEntity getCity(CitySearchCriteria criteria);
	
}