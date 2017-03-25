angular.module("Dissertation")
    .factory('createUserService', ['$http', 'urlConstants', function ($http, urlConstants) {
        function createUser(user) {

            var userJSON = JSON.stringify(user);
            var config = {};
            $http.put(urlConstants.USERS, userJSON, config)
                .success(function (data) {
                    console.log('success', data);
                })
                .error(function (data, status) {
                    console.error("error", status);
                });
        }

        return {
            createUser: createUser
        }
    }]);
