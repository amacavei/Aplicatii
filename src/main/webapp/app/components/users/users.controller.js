'use strict';

angular
  .module('Dissertation')
  .controller('UsersController',['$scope','$log','UserService', function($scope, $log, UsersService){
    $scope.users = UsersService.getAll();
  }]);
