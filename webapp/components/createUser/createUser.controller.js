/**
 * Created by Andrei on 1/28/2017.
 */
angular.module('Dissertation')
    .controller('createUserController', ['$scope', 'createUserService', function($scope,createUserService) {
            var vm = this;

            vm.createUser = function() {
                var user = {
                    login      : vm.login,
                    password   : vm.password,
                    phone      : vm.phoneNumber,
                    email      : vm.email,
                    firstName  : vm.firstName,
                    familyName : vm.familyName,
                    language   : 'en',
                    birthDate  : null,
                    enabled    : true,
                    pictureId  : null
                };

                createUserService.createUser(user);
            };
    }]);
