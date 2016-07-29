(function(angular) {
	
	var CityFactory = function() {
	    var interfaz = {
	    		id: detailForm.id.value,
	    		name: detailForm.name.value,
	    		state: detailForm.state.value,
	    		country: detailForm.country.value,
	    		map: detailForm.map.value
	    }
	    return interfaz;
	};
	
	
	
	//inyectando las factorias
	CityFactory.$inject = [];	//aqui definir los valores que se pasan a la funcion
	app.factory("cityFactory", CityFactory);
	
	
	
}(angular));