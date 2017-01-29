'use strict';

angular
  .module("Dissertation")
  .service('HomeService', ['$log','$resource', function ($log, $resource) {
    return{
      getTechno: function(){
        var userResource = $resource('components/commons/json/technos.json', {}, {
          query: {method:'GET', params:{}, isArray: true}
        });
        return userResource.query();
      }
    }
  }]);
