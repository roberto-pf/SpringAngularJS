(function(angular) {
	// CONSTANTES GLOBALES
	var URL_REST = "http://localhost:8080/";

	var DetailController = function($scope, $http, cityFactory, blockUI) {
		blockUI.start();
		
		angular.element(document).ready(function () {
			document.getElementById('divBody').className ="";
			blockUI.stop();
	    });
		
		
		// inicializamos el model city del formulario con losdatos de la
		// factoria
		$scope.city = cityFactory;
		$scope.successMessage = "";
		$scope.dangerMessage = "";

		var type = "cities";
		
		$scope.save = function() {
			//$scope.$broadcast('show-errors-check-validity');

			
			// have type in scope = $scope.type
			if ($scope.detailForm.$valid) {
				blockUI.start();
				
				var url_ = URL_REST + 'rest/' + type + '/';
				var post = "post";
				if ($scope.city.id != 0) {
					url_ = url_ + $scope.city.id + '/';
					post = "put";
				}
				
				var req_save = {
						method : post,
						url : url_,
						headers : {
							'Content-Type' : 'application/json; charset=utf-8',
						},
						data : $scope.city
					};
				
				$http(req_save)
					.success(function(data, status, headers, config) {

							$scope.city.id = data.idPk;
							$scope.successMessage = data.successMessage;
							$scope.dangerMessage = "";
							
							blockUI.stop();

					}).error(function(data, status, headers, config) {
						$scope.successMessage = "";
						$scope.dangerMessage = data.dangerMessage;
						
						blockUI.stop();
					});
			} else {
				//alert("Error al intentar guardar el formulario.");
			}
		};

		$scope.cancel = function() {
			window.location = "/city/list";
		}
	};

	// Inyectando los controladores
	DetailController.$inject = [ '$scope', '$http', 'cityFactory', 'blockUI' ];
	app.controller("detailController", DetailController);

}(angular));