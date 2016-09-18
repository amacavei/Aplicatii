angular.module('FinalProject')
    .controller('LoginCtrl', ['$rootScope','$http','$location', 'AuthService', function ($rootScope, $http, $location, AuthService) {

        var user = this;

        user.submit = function () {
            if (user.username == 'admin' && user.password == 'admin') {
                $location.path('/home');
            } else {
                alert("Invalid username/password! Please try again!");
            }
        };
    }]);