'use strict';

angular
  .module('Dissertation')
  .service('UsersService', ['$http', '$log', '$resource', 'urlConstants', function ($http, $log, $resource,urlConstants) {
    return {
        getAll: function () {
            var userResource = $resource(urlConstants.USERS, {}, {
                query: {method: 'GET', params: {}, isArray: true}
            });
            return userResource.query();
        },

        editUser: function(user, id) {

            var userJSON = JSON.stringify(user);

            $http.put(urlConstants.USERS + '/' + id, userJSON)
                .success(function (data) {
                    console.log('success', data);
                })
                .error(function (data, status) {
                    console.error("error", status);
                });
        }
    }
}]);
