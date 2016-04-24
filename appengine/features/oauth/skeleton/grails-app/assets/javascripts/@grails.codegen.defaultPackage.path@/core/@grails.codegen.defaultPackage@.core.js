//= wrapped
//= require_self
//= require_tree services

// removed from asset-pipeline /angular/angular
// removed from asset-pipeline /angular/angular-resource

angular.module("@grails.codegen.defaultPackage@.core", ['ngResource','ngCookies'])
    .constant("contextPath", window.contextPath)
    .config(config);

function config($httpProvider) {
    $httpProvider.defaults.headers.common["X-Requested-With"] = "XMLHttpRequest";
    $httpProvider.interceptors.push(securityRequestInterceptor);
    $httpProvider.interceptors.push(httpRequestInterceptor);
}

function httpRequestInterceptor(contextPath) {
    return {
        request: function (config) {
            if (!config.url.indexOf("/") == 0 && contextPath) {
                config.url = contextPath + "/" + config.url;
            }
            return config;
        }
    };
}


function securityRequestInterceptor($q, $cookies, $window){
    return {
        request: function(request) {
            request.headers = request.headers || {};
            if( $cookies.get('token') ){
                request.headers.authorization = 'Bearer ' + $cookies.get('token');
            }
            return request;
        },
        responseError: function(rejection) {
            if (rejection.status === 401) {
                $window.location = '/oauth/authenticate/google'
            }
            if (rejection.status === 403) {
               alert("No tienes permisos suficientes para acceder a este recurso")
            }

            /* If not a 401, do nothing with this error.
             * This is necessary to make a `responseError`
             * interceptor a no-op. */
            return $q.reject(rejection);
        }
    }
}
