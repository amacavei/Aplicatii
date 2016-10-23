'use strict';

angular
  .module('Dissertation')
  .constant('urlConstants', {
    AUTHENTICATE: 'http://localhost:8080/Dissertation-1.0-SNAPSHOT/authenticate',
    ACCOUNT: 'http://localhost:8080/Dissertation-1.0-SNAPSHOT/security/account'
  })
