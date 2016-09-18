angular.module('FinalProject')
    .config(function ($stateProvider,$urlRouterProvider) {
        $stateProvider
            .state('login', {
                url: '/',
                templateUrl: 'components/login/login.html',
                controller: 'LoginCtrl',
                controllerAs: 'me',
                authenticate: false
            })
            .state('home', {
                url:'/home',
                templateUrl: 'components/home/home.html',
                controller: 'home.controller.js',
                authenticate: true
            });
        $urlRouterProvider
            .otherwise('/');
    })
    .run(function ($rootScope, $state, AuthService) {
        $rootScope.$on("$stateChangeStart", function(event, toState, toParams, fromState, fromParams){
            if (toState.authenticate && !AuthService.isAuthenticated()){
                // User isn’t authenticated
                $state.transitionTo("login");
                event.preventDefault();
            }
        });
    });
