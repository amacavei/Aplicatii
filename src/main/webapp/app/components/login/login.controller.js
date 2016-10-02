'use strict';

angular
  .module('Dissertation')
  .controller('LoginController',['$rootScope','$scope','AuthSharedService', function($rootScope, $scope, AuthSharedService){

    $scope.rememberMe = true;
    $scope.login = function(){
      $rootScope.authenticationError = false;
      AuthSharedService.login($scope.username, $scope.password, $scope.rememberMe);
    }
  }]);
