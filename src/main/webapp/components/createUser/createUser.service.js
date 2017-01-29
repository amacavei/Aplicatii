/**
 * Created by Andrei on 1/28/2017.
 */
angular.module("Dissertation")
    .factory('createUserService', ['$http','urlConstants', function($http,urlConstants){
        var createUser = function(user) {
                var config = {
                };
                $http.post(urlConstants.USERS, $.param({
                    user:user
                }), config)
                    .success(function (data) {
                        console.log('success', data);
                    })
                    .error(function (data, status) {
                        console.error("error", status);
                    });
            };

        return {
            createUser: createUser
        }
    }]);