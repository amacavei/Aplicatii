'use strict';

angular
  .module("Dissertation")
  .service('Session', function () {
    this.create = function (data) {
        this.id = data.id;
        this.login = data.login;
        this.firstName = data.first_name;
        this.lastName = data.family_name;
        this.email = data.e_mail;
        this.isAdmin = data.isAdmin;
    };
    this.invalidate = function () {
        this.id = null;
        this.login = null;
        this.firstName = null;
        this.lastName = null;
        this.email = null;
        this.isAdmin = null;
    };
    return this;
});
