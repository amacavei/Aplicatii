
'use strict';

angular
  .module("Dissertation",[
    'ui.router',
    'ngMaterial',
    'ngResource',
    'http-auth-interceptor',
    'ngAnimate',
    'angular-spinkit'
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
                .state('createUser',{
                  url:'/create',
                  templateUrl:'components/createUser/createUser.html',
                  controller:'createUserController',
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
                    loginRequired: false,
                    authorizedRoles: [USER_ROLES.all]
                  }
                })
                .state('logout',{
                  url:'/logout',
                  template:' ',
                  controller:'LogoutController',
                  controllerAs:'vm',
                  access: {
                    loginRequired: false,
                    authorizedRoles: [USER_ROLES.all]
                  }
                })
                .state('login',{
                  url:'/login',
                  templateUrl: 'components/login/login.html',
                  controller: 'LoginController',
                  controllerAs: 'vm',
                  access: {
                    loginRequired: false,
                    authorizedRoles: [USER_ROLES.all]
                  }
                })
                .state('errorCode',{
                  url:'/error/:code',
                  templateUrl: 'components/error/error.html',
                  controller: 'ErrorController',
                  controllerAs: 'vm',
                  access: {
                    loginRequired: false,
                    authorizedRoles: [USER_ROLES.all]
                  }
                })
  }])
  .run([
    '$rootScope',
    '$state',
    '$http',
    'AuthSharedService',
    'Session',
    'USER_ROLES',
    '$q',
    '$timeout',
    function($rootScope, $state, $http, AuthSharedService, Session, USER_ROLES, $q, $timeout){

    $rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams){
        if(toState.url === '/login' && $rootScope.authenticated){
          event.preventDefault();
        }else if(toState.access && toState.access.loginRequired && !$rootScope.authenticated){
          event.preventDefault();
          $rootScope.$broadcast("event:auth-loginRequired", {});
        }else if(toState.access && !AuthSharedService.isAuthorized(toState.access.authorizedRoles)){
          event.preventDefault();
          $rootScope.$broadcast("event:auth-forbidden", {});
        }
      });

      $rootScope.$on('$stateChangeSuccess', function(scope, next, current){

        $rootScope.$evalAsync(function(){
          $.material.init();
        })
      });
      // Call when the the client is confirmed
    $rootScope.$on('event:auth-loginConfirmed', function (event, data) {
        console.log('login confirmed start ' + data);
        $rootScope.loadingAccount = false;
        var nextLocation = ($rootScope.requestedUrl ? $rootScope.requestedUrl : "home");
        var delay = ($state.current.name === "loading" ? 1500 : 0);

        $timeout(function () {
            Session.create(data);
            $rootScope.account = Session;
            $rootScope.authenticated = true;
            $state.go(nextLocation);
        }, delay);

    });

    // Call when the 401 response is returned by the server
    $rootScope.$on('event:auth-loginRequired', function (event, data) {
        if ($rootScope.loadingAccount && data.status !== 401) {
            $rootScope.requestedUrl = $state.current.name;
            $state.go('loading');
        } else {
            Session.invalidate();
            $rootScope.authenticated = false;
            $rootScope.loadingAccount = false;
            $state.go('login');
        }
    });

    // Call when the 403 response is returned by the server
    $rootScope.$on('event:auth-forbidden', function (rejection) {
        $rootScope.$evalAsync(function () {
            $state.go('errorCode',{code: 403});
        });
    });

    // Call when the user logs out
    $rootScope.$on('event:auth-loginCancelled', function () {
        $state.go('login');
    });

    // Get already authenticated user account
    AuthSharedService.getAccount();

  }]);
