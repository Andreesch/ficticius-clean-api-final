var appControllers = angular.module('AppControllers', ['AppServices']);


appControllers.controller('VehicleController', ['$scope', '$rootScope', '$timeout', '$location', 'CadastrarVeículo', 'ListarVeículo', function (scope, rootScope, timeout, location, cadastrarVeiculo, listarVeículo){

    scope.vehicles = [];

    scope.createVehicle = function() {

        var params = {
            brand: scope.brand,
            id: scope.id,
            kmInsideCity: scope.kmInsideCity,
            kmOutsideCity: scope.kmOutsideCity,
            lastUpdate: scope.lastUpdate,
            manufactureYear: scope.manufactureYear,
            model: scope.model,
            name: scope.name
        }

        cadastrarVeiculo.post(null, params, function(response) {
                alert("Cadastro efetuado com sucesso!");       
        }, function(response) {
            var message = "Não foi possível cadastrar!\n";
            if(response && response.data) {
                if(response.data.errors && response.data.errors.length > 0) {
                    for(var i=0; i < response.data.errors.length; i++) {
                        message += "\n" + response.data.errors[i].field;
                    }
                } else if(response.data.message && response.data.message.length > 0){
                    message +=  "\n" + response.data.message;
                }
            }
            alert(message);
        });
    }

    scope.listVehicles = function() {

        var params = {
            fuelPrice: scope.fuelPrice,
            kmInsideCity: scope.kmInsideCityParam ? scope.kmInsideCityParam : 0,
            kmOutsideCity: scope.kmOutsideCityParam ? scope.kmOutsideCityParam : 0
        }

        listarVeículo.get(null, params, function(response) {
            scope.vehicles = response;

            if(!scope.vehicles || scope.vehicles.length == 0) {
                alert("Nenhum veículo cadastrado!")
            }
        }, function(response) {
            var message = "Não foi possível listar veículos!\n";
            if(response && response.data) {
                if(response.data.errors && response.data.errors.length > 0) {
                    for(var i=0; i < response.data.errors.length; i++) {
                        message += "\n" + response.data.errors[i].field;
                    }
                } else if(response.data.message && response.data.message.length > 0){
                    message +=  "\n" + response.data.message;
                }
            }
            alert(message);
        });
    }

}]);