'use strict';

angular
  .module("Dissertation")
  .controller("ApiDocController",['$scope',function($scope) {
    $scope.isLoading = false;
    $scope.url = $scope.swaggerUrl = 'v2/api-docs';

    $scope.myErrorHandler = function(data, status) {
      console.log('fales to load swagger: ' + status + ' ' + data);
    };
    $scope.infos = false;
  }]);
