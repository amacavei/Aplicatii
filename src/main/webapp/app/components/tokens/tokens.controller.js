'use strict';

angular
  .module("Dissertation")
  .controller("TokensController",['$scope','UsersService','TokensService','$q',function($scope, UserService, TokensService, $q) {
    var browsers = ["Firefox","Chrome","Trident"];

    $q.all([
      UserService.getAll().$promise,
      TokensService.getAll().$promise
    ]).then(function(data){
      var users = data[0];
      var tokens = data[1];

      tokens.forEach(function(token){
        users.forEach(function(user){
          if(token.userLogin === user.login){
            token.firstName = user.firstName;
            token.familyName = user.familyName;
            browsers.forEach(function(browser){
              if(token.userAgent.indexOf(browser) > -1){
                token.browser = browser;
              }
            });
          }
        });
      });
      $scope.tokens = tokens;
    });
  }])
