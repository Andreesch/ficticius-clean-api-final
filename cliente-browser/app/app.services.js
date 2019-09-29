var appServices = angular.module('AppServices', ['ngResource', 'ngRoute']);
var domainURL = "http://192.168.25.156:8081";


appServices.config(['$httpProvider', function(httpProvider) {
	httpProvider.interceptors.push('edHttpInterceptor');
}]);

appServices.run(['$http', function(http) {
}]);

appServices.factory('edHttpInterceptor', ['$q', '$location', function (q, location) {
	return {
        request: function (config) {
            return config || $q.when(config);
        },
        requestError: function(request){
            return $q.reject(request);
        },
        response: function (response) {
        	if (response && response.data && response.data.problems && response.data.problems[0] && response.data.problems[0].code == 'infrastructure.401Error') {
	    			loginStore().setExpired();
					location.path('/start');
					//return response;
        	}

            return response || $q.when(response);
        },
        responseError: function (response) {
            if (response.status === 401) {
	    		loginStore().setExpired();
				location.path('/start');
				//return response;
	    	}

	        return q.reject(response);
        }
    };

}]);

appServices.factory('CadastrarVeículo', ['$resource', function(resource) {
	return resource(domainURL + '/vehicle/criar-veiculo', null, {
		post: { method:'POST'}
	});
}]);

appServices.factory('ListarVeículo', ['$resource', function(resource) {
	return resource(domainURL + '/vehicle/listar-veiculos', null, {
		get: { method:'POST', isArray:true}
	});
}]);
