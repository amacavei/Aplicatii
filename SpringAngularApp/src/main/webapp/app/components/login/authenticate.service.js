angular.module('FinalProject')
    .factory('AuthService', function($http) {
        var isAuthenticated = function () {
            return false;
        };
        return {
            isAuthenticated: isAuthenticated
        };

        $http({
            method: 'POST',
            url: 'login',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        })
            .success(function (data, status, headers, config) {
                console.log(data);
                if (data.correct === 'correct') {
                    window.location.href = 'success';
                } else {
                    $scope.errorMsg = 'Login not correct';
                }
            })
            .error(function (data, status, headers, config) {
                console.log("data:" + data + "status:" + status + "headers:" + headers + "config:" + config);
                $scope.errorMsg = 'Unable to submit form';
            });
    }
);