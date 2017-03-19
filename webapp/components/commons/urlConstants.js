'use strict';

angular
  .module('Dissertation')
  .constant('urlConstants', {
    AUTHENTICATE: 'http://localhost:8080/authenticate',
    ACCOUNT: 'http://localhost:8080/security/account',
    TOKENS: 'http://localhost:8080/security/tokens',
    LOGOUT: 'http://localhost:8080/logout',
    USERS: 'http://localhost:3000/api/users'
  });
