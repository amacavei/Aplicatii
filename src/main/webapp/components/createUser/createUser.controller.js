/**
 * Created by Andrei on 1/28/2017.
 */
angular.module('Dissertation')
    .controller('createUserController', ['$scope', function($scope) {
        $scope.login = '';
        $scope.password = '';
        $scope.phoneNumber = '';
        $scope.email = '';
        $scope.firstName = '';
        $scope.familyName = '';
    }]);
