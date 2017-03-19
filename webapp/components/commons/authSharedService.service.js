'use strict';

angular
  .module("Dissertation")
  .service('AuthSharedService', ['$rootScope', '$http', '$resource', 'authService', 'Session', 'urlConstants', function($rootScope, $http, $resource, authService, Session, urlConstants) {
    return {
      login: function(userName, password, rememberMe) {
        var config = {
          ignoreAuthModule: 'ignoreAuthModule',
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
          }
        };
        $http.post(urlConstants.AUTHENTICATE, $.param({
            username: userName,
            password: password,
            rememberme: rememberMe
          }), config)
          .success(function(data, status, headers, config) {
            authService.loginConfirmed(data);
          })
          .error(function(data, status, headers, config) {
            $rootScope.authenticationError = true;
            Session.invalidate();
          });
      },
      getAccount: function() {
        $rootScope.loadingAccount = true;
        // $http.get(urlConstants.ACCOUNT)
        //     .then(function (response) {
        //         authService.loginConfirmed(response.data);
        //     });
      },
      isAuthorized: function(authorizedRoles) {
        if (!angular.isArray(authorizedRoles)) {
          if (authorizedRoles == '*') {
            return true;
          }
          authorizedRoles = [authorizedRoles];
        }
        var isAuthorized = false;
        angular.forEach(authorizedRoles, function(authorizedRole) {
          var authorized = (!!Session.login &&
            Session.userRoles.indexOf(authorizedRole) !== -1);
          if (authorized || authorizedRole == '*') {
            isAuthorized = true;
          }
        });
        return isAuthorized;
      },
      logout: function() {
        $rootScope.authenticationError = false;
        $rootScope.authenticated = false;
        $rootScope.account = null;
        $http.get(urlConstants.LOGOUT);
        Session.invalidate();
        authService.loginCancelled();
      }
    };
  }]);
