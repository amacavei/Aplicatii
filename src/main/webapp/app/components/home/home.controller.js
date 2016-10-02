'use strict';

angular
  .module("Dissertation")
  .controller("HomeController",['$scope','HomeService', function($scope, HomeService){
    $scope.technos = HomeService.getTechno();
  }]);
