'use strict';

angular
  .module('Dissertation')
  .controller('UsersController',['$scope','$log','UsersService', function($scope, $log, UsersService){
    $scope.users = UsersService.getAll();
  }]);
