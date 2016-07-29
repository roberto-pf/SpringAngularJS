(function(angular) {
	appHome.controller('AccordionHomeCtrl', function($scope, blockUI) {
		blockUI.start();
		angular.element(document).ready(function () {
			blockUI.stop();
	    });
	});

}(angular));