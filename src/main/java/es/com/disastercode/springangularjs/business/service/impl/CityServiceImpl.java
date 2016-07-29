package es.com.disastercode.springangularjs.business.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import es.com.disastercode.springangularjs.business.entity.CityEntity;
import es.com.disastercode.springangularjs.business.repository.CityRepository;
import es.com.disastercode.springangularjs.business.service.CityService;
import es.com.disastercode.springangularjs.business.service.criteria.CitySearchCriteria;

@Component("cityService")
@Transactional
public class CityServiceImpl extends CrudServiceImpl<CityEntity> implements CityService {

	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public JpaRepository<CityEntity, Long> getRepository() {
		return cityRepository;
	}

	@Override
	public Page<CityEntity> findCities(CitySearchCriteria criteria, Pageable pageable) {
//		Assert.notNull(criteria, "Criteria must not be null");
		String name = criteria.getName();
		String country = criteria.getCountry();

		if (!StringUtils.hasLength(name)) {
			return this.cityRepository.findAll(pageable);
		}

		return this.cityRepository
				.findByNameContainingAndCountryContainingAllIgnoringCase(name.trim(),
						country.trim(), pageable);
	}
	
	@Override
	public Long countCities(CitySearchCriteria criteria) {
//		Assert.notNull(criteria, "Criteria must not be null");
		return this.cityRepository.count();
	}

	@Override
	public CityEntity getCity(CitySearchCriteria criteria) {
//		Assert.notNull(criteria.getName(), "Name must not be null");
//		Assert.notNull(criteria.getCountry(), "Country must not be null");
		return this.cityRepository.findByNameAndCountryAllIgnoringCase(criteria.getName(), criteria.getCountry());
	}

}

