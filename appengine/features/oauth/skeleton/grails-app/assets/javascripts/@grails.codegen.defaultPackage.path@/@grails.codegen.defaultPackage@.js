//= wrapped
//= require /@grails.codegen.defaultPackage.path@/core/@grails.codegen.defaultPackage@.core
//= require /@grails.codegen.defaultPackage.path@/index/@grails.codegen.defaultPackage@.index

// exclude from asset pipeline = require /angular/angular


angular.module("@grails.codegen.defaultPackage@", [
    "ngCookies",
    "@grails.codegen.defaultPackage@.core",
    "@grails.codegen.defaultPackage@.index"
]);
