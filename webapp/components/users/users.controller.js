'use strict';

angular
  .module('Dissertation')
  .controller('UsersController',['$scope','$log','UsersService', '$timeout', function($scope, $log, UsersService, $timeout){
      var vm = this;
     UsersService.getAll().then(function(data){
        vm.users = data.Users;
    });
    $scope.isInEditMode = false;

    vm.editUser = function(user) {
      var newUser = {
          login      : user.login,
          password   : user.password,
          phone      : vm.phoneNumber,
          e_mail      : vm.email,
          first_name  : vm.firstName,
          family_name : vm.familyName,
          language   : user.language,
          birthDate  : user.birthDate,
          enabled    : user.enabled,
          pictureId  : user.pictureId,
          isAdmin    : user.isAdmin
      };

      UsersService.editUser(newUser, user.id);

        $timeout(function(){
          vm.emptyForm();
            UsersService.getAll().then(function(data){
                vm.users = data.Users;
            });
        },1000);
    };

    vm.emptyForm = function(){
      vm.phoneNumber = '';
      vm.email = '';
      vm.firstName = '';
      vm.familyName = '';
    }
  }]);
