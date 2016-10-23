'use strict';

angular
  .module("Dissertation")
  .controller("HomeController",['$scope','HomeService','$location', function($scope, HomeService, $location){
    $scope.technos = HomeService.getTechno();
  }]);
