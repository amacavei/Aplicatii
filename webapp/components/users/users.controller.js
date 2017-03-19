'use strict';

angular
  .module('Dissertation')
  .controller('UsersController',['$scope','$log','UsersService', '$timeout', function($scope, $log, UsersService, $timeout){
      var vm = this;
    vm.users = UsersService.getAll();
    $scope.isInEditMode = false;

    vm.editUser = function(user) {
      var newUser = {
          login      : user.login,
          password   : user.password,
          phone      : vm.phoneNumber,
          email      : vm.email,
          firstName  : vm.firstName,
          familyName : vm.familyName,
          language   : user.language,
          birthDate  : user.birthDate,
          enabled    : user.enabled,
          pictureId  : user.pictureId
      };

      UsersService.editUser(newUser, user.id);

        $timeout(function(){
          vm.emptyForm();
          vm.users = UsersService.getAll();
        },1000);
    }

    vm.emptyForm = function(){
      vm.phoneNumber = '';
      vm.email = '';
      vm.firstName = '';
      vm.familyName = '';
    }
  }]);
