angular.module('class',['app_config'])
.service('classService',['$http','base_url_api', function($http,base_url_api) {
	var getClasses = function() {
		 $http.get(base_url_api+"/classes")
		 .then(function(response) {
			return response;
		})
	  };
	
	var addClass = function(newClass) {
		$http.post(base_url_api+"/classes/add",newClass)
			.then(function(response) {
				return response;
			})
	   };
	   
	var getClass = function(id) {
		$http.get(base_url_api+"/classes/get/"+id)
		 .then(function(response) {
			return response;
		 })
	};
		 
	var removeClass = function(id) {
		$http.put(base_url_api+"/classes/remove/"+id)
			.then(function(response){
				return response;
			})
	};
		 
    var editClass = function(id,editableClass) {
		var editStudnet  = $http.put(base_url_api+"/classes/edit/"+id, editableClass)
			.then(function(response) {
				return response;
			 })
		};
	 
	}])
	.controller('classController',['classService','$scope', function(classService,$scope) {
		
		$scope.classes = classService.getClasses();
		
		$scope.addClass = function(newClass) {
			classService.addClass(newClass);
		}
		
		$scope.removeClass = function(id) {
			classService.removeClass(id);
		}
		
		$scope.getClass = function(id) {
			classService.getClass(id);
		}
		
		$scope.editClass = function(id,editableClass) {
			classService.editClass(id,editableClass);
		}
		
		
	}])
	