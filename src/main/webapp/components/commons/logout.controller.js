(function() {
  'use strict';
  angular
    .module("Dissertation")
    .controller("LogoutController", ['AuthSharedService', function(AuthSharedService) {
      AuthSharedService.logout();
    }]);
})();
