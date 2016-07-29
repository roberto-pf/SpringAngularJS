package es.com.disastercode.springangularjs.web.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.com.disastercode.springangularjs.business.entity.CityEntity;
import es.com.disastercode.springangularjs.business.service.CityService;
import es.com.disastercode.springangularjs.web.controller.resource.CityResource;

@RestController
@RequestMapping("/rest/cities")
@ExposesResourceFor(CityEntity.class)
public class SampleControllerRest extends CRUDControllerRest<CityEntity> {
	
	@Autowired
	private CityService cityService;
	@Autowired
	private EntityLinks entityLinks;
	@Autowired
	private MessageSource messageSource;

	
	
	@RequestMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public HttpEntity<CityResource> getItem(@PathVariable Long id) {
//		HttpEntity<Resource<CityEntity>> getItem(@PathVariable Long id) {
		CityEntity city = cityService.getItemById(id);
		CityResource bean = new CityResource();
		if(city!=null)
			bean.set(city);
		
		bean.add(this.entityLinks.linkToSingleResource(CityEntity.class, id));
		return new ResponseEntity<CityResource>(bean, HttpStatus.OK);
//		return new ResponseEntity<Resource<CityEntity>>(resource, HttpStatus.OK);
	}
	

	
	@RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public HttpEntity<CityResource> addItem(@RequestBody CityResource item) {
		// item.setId(null);
		CityEntity city = cityService.addItem(item.populate());
		CityResource bean = new CityResource();
		bean.set(city);
		
		String msg = messageSource.getMessage("message.save.correct",null,LocaleContextHolder.getLocale());
		bean.setSuccessMessage(msg);
		return new ResponseEntity<CityResource>(bean, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public HttpEntity<CityResource> updateItem(@RequestBody CityResource updatedItem, @PathVariable Long id) {
		updatedItem.setIdPk(id.toString());
		CityEntity city = cityService.updateItem(updatedItem.populate());
		CityResource bean = new CityResource();
		bean.set(city);
		String msg = messageSource.getMessage("message.save.correct",null,LocaleContextHolder.getLocale());
		bean.setSuccessMessage(msg);
		return new ResponseEntity<CityResource>(bean, HttpStatus.OK);
	}
	
	
	

//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
//	public HttpEntity<CityResource> deleteItem(@PathVariable Long id) {
//		cityService.deleteItem(id);
//		return new ResponseEntity<CityResource>(new CityResource(), HttpStatus.OK);
//	}

}