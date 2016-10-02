'use strict';

angular
  .module("Dissertation")
  .controller("ErrorController",['$scope','$routeParams',function($scope, $routeParams){

    $scope.code = $routeParams.code;

    switch($scope.code){
      case "403":
        $scope.message = "Oops! You have come to unauthorised page.";
        break;
      case "404":
        $scope.message = "Page not found.";
        break;
      default:
        $scope.code = 500;
        $scope.message = "Oops! Unexpected error";
    };
  }]);
