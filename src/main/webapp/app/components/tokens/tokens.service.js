'use strict';

angular
  .module('Dissertation')
  .service('TokensService', ['$log','$resource','urlConstants', function ($log, $resource,urlConstants) {
    return {
        getAll: function () {
            var tokensResource = $resource(urlConstants.TOKENS, {}, {
                query: {method: 'GET', params: {}, isArray: true}
            });
            return tokensResource.query();
        }
    }
}]);
