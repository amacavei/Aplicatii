'use strict';

angular
  .module('Dissertation')
  .service('TokensService', ['$log','$resource', function ($log, $resource) {
    return {
        getAll: function () {
            var tokensResource = $resource('security/tokens', {}, {
                query: {method: 'GET', params: {}, isArray: true}
            });
            return tokensResource.query();
        }
    }
}]);
