
var App = angular.module('App', ['AppServices', 'AppDirectives', 'AppControllers']);

App.config(['$routeProvider', function(routeProvider) {
    routeProvider.when('/start', { controller: 'VehicleController', templateUrl: 'app/templates/begin.html', title: 'Home'});
    routeProvider.otherwise({redirectTo: '/start'});
}]);

App.run(['$rootScope', '$route', '$location', '$window', '$compile', function(rootScope, route, location, window, compile) {

}]);