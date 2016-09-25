'use strict';

angular
  .module("Dissertation")
  .service('Home', ['$log','$resource', function ($log, $resource) {
    return{
      getTechno: function(){
        var userResource = $resource('resources/json/techno.json', {}, {
          query: {method:'GET', params:{}, isArray: true}
        });
        return userResource.query();
      }
    }
  }])
