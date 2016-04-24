//= wrapped

angular
    .module("@grails.codegen.defaultPackage@.index")
    .controller("IndexController", IndexController);

function IndexController($log, $location, $cookies, $window, applicationDataFactory, contextPath) {
    var vm = this;

    vm.logged = false;
    vm.contextPath = contextPath;

    applicationDataFactory.get().then(function(response) {
        vm.applicationData = response.data;
    });

    vm.login = function(){
        applicationDataFactory.username().then(function(response) {
            vm.user = response.data;
            vm.logged = true;
        });
    }

    vm.logout = function(){
        $cookies.remove('token');
        $window.location.href = $location.path();
    }

    if( $location.search().error ){
        vm.logged = false;
        var str = "Error : " + $location.search().error + ',';
        str += $location.search().message;
        vm.alert = {
            type : 'danger',
            message : str
        }
        return
    }

    if( $location.search().token ){
        $cookies.put('token', $location.search().token);
        $window.location.href = $location.path();
        return;
    }

    if( $cookies.get('token') ){
        vm.login();
    }

}
