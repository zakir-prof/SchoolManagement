angular.module('student',['class','app_config'])
	.controller('studentController',['$scope','studentService','classService', 
	                                 function($scope,studentService,classService) {
		
		$scope.students = studentService.getStudents();
		
		$scope.addStudent = function(student) {
			studentService.addStudent(student);
		}
		
		$scope.removeStudent = function(id) {
			studentService.removeStudent(id);
		}
		
		$scope.getStudent = function(id) {
			studentService.getStudent(id);
		}
		
		$scope.editStudent = function(id,student) {
			studentService.editStudent(id,student);
		}
		
		
	}])
	.service('studentService',['$http','base_url_api', function($http,base_url_api) {
	  this.getStudents = function() {
		 $http.get(base_url_api+"/students")
		 .then(function(response) {
			alert(response);
			return response;
		})
	  };
	
	  this.addStudent = function(student) {
		$http.post(base_url_api+"/students/add",student)
			.then(function(response) {
				return response;
			})
	   };
	   
	  this.getStudent = function(id) {
		$http.get(base_url_api+"/students/get/"+id)
		 .then(function(response) {
			return response;
		  })
	};
		 
	 this.removeStudent = function(id) {
		$http.put(base_url_api+"/students/remove/"+id)
			.then(function(response){
				return response;
			})
	};
		 
     this.editStudent = function(id,student) {
		var editStudnet  = $http.put(base_url_api+"/students/edit/"+id, student)
			.then(function(response) {
				return response;
			})
	  };
	 
	}])