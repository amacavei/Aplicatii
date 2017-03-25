'use strict';

angular
  .module('Dissertation')
  .service('UsersService', ['$http', '$log', '$resource', 'urlConstants','$q', function ($http, $log, $resource,urlConstants, $q) {
    return {
        getAll: function () {
            var deferred = $q.defer();
           $http.post(urlConstants.USERS).success(function(data){
               deferred.resolve(data);
           })
               .error(function(err){
                   deferred.reject(err);
               });
            return deferred.promise;
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
