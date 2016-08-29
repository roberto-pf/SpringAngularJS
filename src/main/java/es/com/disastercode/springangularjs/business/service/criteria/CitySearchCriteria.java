package es.com.disastercode.springangularjs.business.service.criteria;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import es.com.disastercode.springangularjs.business.entity.CityEntity;
import es.com.disastercode.springangularjs.business.entity.CityEntity_;
import es.com.disastercode.springangularjs.utils.JPAPatterns;

public class CitySearchCriteria implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String country;
	private String orderBy;
	private String orderMode;
	

	public CitySearchCriteria() {
	}

	public CitySearchCriteria(String name) {
//		Assert.notNull(name, "Name must not be null");
		this.name = name;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrderMode() {
		return orderMode;
	}

	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
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
	
	
	public static Specification<CityEntity> search(final CitySearchCriteria cri) {
		return new Specification<CityEntity>() {

			public Predicate toPredicate(Root<CityEntity> root, CriteriaQuery<?> criteriaQuery,
					CriteriaBuilder criteriaBuilder) {
				
				List<Predicate> predicates = new ArrayList<Predicate>();
				
				if( StringUtils.isNotBlank(cri.getName()) ){
					predicates.add( criteriaBuilder.like(root.get(CityEntity_.name),
							JPAPatterns.getContainsLikePattern(cri.getName())) );
				}
				// builder.between(pRoot.get(Person_.time), startDate,
				// endDate)
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
	}
	
	public void set(HttpServletRequest req) {
		this.name = (String) req.getParameter("name");
		this.orderBy = (String) req.getParameter("orderBy");
		this.orderMode = (String) req.getParameter("orderMode");
	}
}