package es.com.disastercode.springangularjs.business.service.impl;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class CrudServiceImpl <T> {

	public abstract JpaRepository<T, Long> getRepository();


	public T getItemById(Long id){
		return this.getRepository().getOne(id);
	}
	
	public List<T> findItems() {
		return this.getRepository().findAll();
	}

	public T addItem(T item) {
		return this.getRepository().saveAndFlush(item);
	}

	public T updateItem( T updatedItem) {
		return this.getRepository().saveAndFlush(updatedItem);
	}

	public void deleteItem( Long id) {
		this.getRepository().delete(id);
	}
}

