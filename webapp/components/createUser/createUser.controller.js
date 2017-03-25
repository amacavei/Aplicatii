angular.module('Dissertation')
    .controller('createUserController', ['$scope', 'createUserService', function($scope,createUserService) {
            var vm = this;

            vm.createUser = function() {
                var user = {
                    login      : vm.login,
                    password   : vm.password,
                    phone      : vm.phoneNumber,
                    e_mail      : vm.email,
                    first_name  : vm.firstName,
                    family_name : vm.familyName,
                    language   : 'en',
                    birthDate  : null,
                    enabled    : true,
                    pictureId  : null,
                    isAdmin    : true
                };

                createUserService.createUser(user);
            };
    }]);
