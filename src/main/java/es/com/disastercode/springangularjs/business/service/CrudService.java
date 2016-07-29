package es.com.disastercode.springangularjs.business.service;


import java.util.List;

public interface CrudService<T>  {
	
	public T getItemById(Long id);
	public List<T> findItems();
	public T addItem (T item);
	public T updateItem( T updatedItem);
	public void deleteItem( Long id);
}