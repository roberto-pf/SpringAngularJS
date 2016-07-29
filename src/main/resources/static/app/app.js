/**
 * APPs
 */
var app = angular.module('ui.bootstrap.gestion', [ 'ui.bootstrap', 'ngMessages', 'ngRoute', 'blockUI', 'ui.bootstrap.showErrors' ]);
var appHome = angular.module('ui.bootstrap.home', [ 'ngAnimate', 'ui.bootstrap', 'blockUI' ]);


/**
 * CONFIG
 */
app.config(['$routeProvider', function($routeProvider){
			  // routeProvider config, allows minification
		}]);
		
app.config(function(blockUIConfig) {
	  blockUIConfig.message = 'Cargando...';
	  blockUIConfig.delay = 100;
});

app.config(['showErrorsConfigProvider', function(showErrorsConfigProvider) {
	  //showErrorsConfigProvider.showSuccess(true);
}]);


appHome.config(function(blockUIConfig) {
	  blockUIConfig.message = 'Cargando...';
	  blockUIConfig.delay = 100;
});




/**
 * CONTROLLERS GENERICS
 */
app.controller('NotCollapsedCtrl', function ($scope) {
	  $scope.isCollapsed = false;
	  $scope.isCollapsedHorizontal = false;
});

app.controller('CollapsedCtrl', function ($scope) {
	  $scope.isCollapsed = true;
	  $scope.isCollapsedHorizontal = false;
});


