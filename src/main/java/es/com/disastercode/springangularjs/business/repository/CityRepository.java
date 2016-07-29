package es.com.disastercode.springangularjs.business.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.com.disastercode.springangularjs.business.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Long> {

	Page<CityEntity> findAll(Pageable pageable);

	Page<CityEntity> findByNameContainingAndCountryContainingAllIgnoringCase(String name,
			String country, Pageable pageable);

	CityEntity findByNameAndCountryAllIgnoringCase(String name, String country);

}