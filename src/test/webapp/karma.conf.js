module.exports = function(config){
  config.set({
    basePath:'',
    frameworks: ['jasmine'],
    files: [
      //test files
      './karma.conf.js',
      './node_modules/angular/angular.js',
      './node_modules/angular-resource/angular-resource.js',
      './node_modules/angular-ui-router/release/angular-ui-router.js',
      './node_modules/angular-mocks/angular-mocks.js',
      '../../main/webapp/bower_components/angular-http-auth/src/http-auth-interceptor.js',
      //project files

      "../../main/webapp/app/app.js",
      "../../main/webapp/app/constants.js",
      "../../main/webapp/app/components/apiDoc/apiDoc.controller.js",
      "../../main/webapp/app/components/login/login.controller.js",
      "../../main/webapp/app/components/error/error.controller.js",
      "../../main/webapp/app/components/home/home.controller.js",
      "../../main/webapp/app/components/loading/loading.controller.js",
      "../../main/webapp/app/components/login/login.controller.js",
      "../../main/webapp/app/components/tokens/tokens.controller.js",
      "../../main/webapp/app/components/users/users.controller.js",
      "../../main/webapp/app/components/commons/authSharedService.service.js",
      "../../main/webapp/app/components/commons/session.service.js",
      "../../main/webapp/app/components/home/home.service.js",
      "../../main/webapp/app/components/tokens/tokens.service.js",
      "../../main/webapp/app/components/users/users.service.js",
      //tests
      '../../main/webapp/app/**/*.spec.js'
    ],
    reporters: ['spec'],
    port: 9876,
    colors: true,
    logLevel: config.LOG_DEBUG,
    autowatch: true,
    browsers: ['Chrome'],
    singleRun: false,
    concurrency: Infinity
  })
};
