'use strict';

angular
  .module('Dissertation').
  .service('UsersService', ['$log', '$resource', function ($log, $resource) {
    return {
        getAll: function () {
            var userResource = $resource('users', {}, {
                query: {method: 'GET', params: {}, isArray: true}
            });
            return userResource.query();
        }
    }
}]);
