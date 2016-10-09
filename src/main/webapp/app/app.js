
'use strict';

angular
  .module("Dissertation",[
    'ui.router',
    'ngResource',
    'http-auth-interceptor'
  ])
  .config([
    '$urlRouterProvider',
    '$stateProvider',
    'USER_ROLES',
    function($urlRouterProvider, $stateProvider,USER_ROLES){

    $urlRouterProvider.otherwise('/otherwise');

            $stateProvider
                .state('otherwise',{
                  url:'/otherwise',
                  access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.all]
                  }
                })
                .state('home', {
                  url:'/home',
                  templateUrl: 'components/home/home.html',
                  controller:'HomeController',
                  access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.all]
                  }
                })
                .state('default',{
                  url:'/',
                  redirectTo: 'home'
                })
                .state('users',{
                  url:'/users',
                  templateUrl:'components/users/users.html',
                  controller:'UsersController',
                  controllerAs:'vm',
                  access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.admin]
                  }
                })
                .state('apiDoc',{
                  url:'/apiDoc',
                  templateUrl:'components/apiDoc/apiDoc.html',
                  controller:'ApiDocController',
                  controllerAs:'vm',
                  access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.all]
                  }
                })
                .state('tokens',{
                  url:'/tokens',
                  templateUrl:'components/tokens/tokens.html',
                  controller:'TokensController',
                  controllerAs:'vm',
                  access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.all]
                  }
                })
                .state('loading',{
                  url:'/loading',
                  templateUrl:'components/loading/loading.html',
                  access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.all]
                  }
                })
                .state('logout',{
                  url:'/logout',
                  template:' ',
                  controller:'LogoutController',
                  controllerAs:'vm',
                  access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.all]
                  }
                })
                .state('login',{
                  url:'/login',
                  templateUrl: 'components/login/login.html',
                  controller: 'LoginController',
                  controllerAs: 'vm',
                  access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.all]
                  }
                })
                .state('errorCode',{
                  url:'/error/:code',
                  templateUrl: 'components/error/error.html',
                  controller: 'ErrorController',
                  controllerAs: 'vm'
                })
  }])
  .run([
    '$rootScope',
    '$location',
    '$http',
    'AuthSharedService',
    'Session',
    'USER_ROLES',
    '$q',
    '$timeout',
    function($rootScope,$location,$http,AuthSharedService,Session,USER_ROLES,$q,$timeout){
      $rootScope.$on('routeChangeStart', function(event,next){
        if(next.originalPath === '/login' && $rootScope.authenticated){
          event.preventDefault();
        }else if(next.access && next.access.loginRequired && !$rootScope.authenticated){
          event.preventDefault();
          $rootScope.$broadcast("event:auth-loginRequired", {});
        }else if(next.access && !AuthSharedService.isAuthorized(next.access.authorizedRoles)){
          event.preventDefault();
          $rootScope.$broadcast("event:auth-forbidden", {});
        }
      });
      $rootScope.$on('$routeChangeSuccess', function(scope, next, current){
        $rootScope.$evalAsync(function(){
          $.material.init();
        })
      });
      // Call when the the client is confirmed
    $rootScope.$on('event:auth-loginConfirmed', function (event, data) {
        console.log('login confirmed start ' + data);
        $rootScope.loadingAccount = false;
        var nextLocation = ($rootScope.requestedUrl ? $rootScope.requestedUrl : "/home");
        var delay = ($location.path() === "/loading" ? 1500 : 0);

        $timeout(function () {
            Session.create(data);
            $rootScope.account = Session;
            $rootScope.authenticated = true;
            $location.path(nextLocation).replace();
        }, delay);

    });

    // Call when the 401 response is returned by the server
    $rootScope.$on('event:auth-loginRequired', function (event, data) {
        if ($rootScope.loadingAccount && data.status !== 401) {
            $rootScope.requestedUrl = $location.path()
            $location.path('/loading');
        } else {
            Session.invalidate();
            $rootScope.authenticated = false;
            $rootScope.loadingAccount = false;
            $location.path('/login');
        }
    });

    // Call when the 403 response is returned by the server
    $rootScope.$on('event:auth-forbidden', function (rejection) {
        $rootScope.$evalAsync(function () {
            $location.path('/error/403').replace();
        });
    });

    // Call when the user logs out
    $rootScope.$on('event:auth-loginCancelled', function () {
        $location.path('/login').replace();
    });

    // Get already authenticated user account
    AuthSharedService.getAccount();

  }]);
