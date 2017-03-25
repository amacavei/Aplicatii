'use strict';

angular
    .module("Dissertation")
    .service('AuthSharedService', ['$rootScope', '$http', '$resource', 'authService', 'Session', 'urlConstants', function ($rootScope, $http, $resource, authService, Session, urlConstants) {
        return {
            login: function (userName, password, rememberMe) {
                var config = {
                    ignoreAuthModule: 'ignoreAuthModule',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    }
                };

                var data = {
                    username: userName,
                    password: password
                };
                $http({
                    method: 'POST',
                    url: urlConstants.USERS,
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    data: data
                })
                    .success(function (data, status, headers, config) {
                        authService.loginConfirmed(data.Users[0]);
                    })
                    .error(function (data, status, headers, config) {
                        $rootScope.authenticationError = true;
                        Session.invalidate();
                    });
            },
            isAuthorized: function (isAdmin) {
               return (!isAdmin || Session.isAdmin == isAdmin);
            },
            logout: function () {
                $rootScope.authenticationError = false;
                $rootScope.authenticated = false;
                $rootScope.account = null;
                $http.get(urlConstants.LOGOUT);
                Session.invalidate();
                authService.loginCancelled();
            }
        };
    }]);
