'use strict';

angular
  .module('Dissertation')
  .service('UsersService', ['$log', '$resource', 'urlConstants', function ($log, $resource,urlConstants) {
    return {
        getAll: function () {
            var userResource = $resource(urlConstants.USERS, {}, {
                query: {method: 'GET', params: {}, isArray: true}
            });
            return userResource.query();
        }
    }
}]);
