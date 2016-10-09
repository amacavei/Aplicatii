describe('AuthSharedService test',function(){
  var rootScope, http, resource, authService, Session, AuthSharedService;
  var uiRouter={};
  var ngResource={};
  var httpAuthInterceptor={};

  beforeEach(function(){
    module('Dissertation');
    module(function($provide){
      $provide.service('ui.router', uiRouter);
      $provide.service('ngResource', ngResource);
      $provide.service('http-auth-interceptor', httpAuthInterceptor);
    })
  });
  beforeEach(inject(function(_AuthSharedService_, _$rootScope_, _$http_, _$resource_, _authService_, _Session_){
    AuthSharedService = _AuthSharedService_;
    rootScope = _$rootScope_;
    http = _$http_;
    resource = _$resource_;
    authService = _authService_;
    Session = _Session_;
  }));

  it('should find the AuthSharedService',function(){
    expect(AuthSharedService).toBeDefined();
  });
})
