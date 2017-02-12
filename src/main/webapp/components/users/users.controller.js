'use strict';

angular
  .module('Dissertation')
  .controller('UsersController',['$rootScope','$scope','$log','UsersService', function($rootScope, $scope, $log, UsersService){
    $scope.users = UsersService.getAll();
    $scope.currentRoles = $rootScope.account.userRoles;

    console.log($rootScope);

    $scope.isAdmin = function() {
      for(var i = 0; i < $scope.currentRoles.length; i++) {
        if($scope.currentRoles[i] === 'admin') return true;
      }

      return false;
    }
  }]);
