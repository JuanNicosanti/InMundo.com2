'use strict';

app.controller('VuelosController', ['vuelosService', '$scope', '$state', function (vuelosService, $scope, $state) {

  var self = this;

  self.errors = [];
  
  this.getVuelos = function () {
	    vuelosService.findAll(function (data) {
	      self.vuelos = _.map(data.data, Vuelo.asVuelo);
	  });
  }
  
  this.getVueloSeleccionado = function(){
	vuelosService.find($scope.numeroVueloSeleccionado, function(data){
		self.vueloSeleccionado = Vuelo.asVuelo(data)
	})  
  }  
  
  function notificarError(mensaje) {
	    self.errors.push(mensaje);
	    self.getVuelos();
	    $timeout(function () {
	      while (self.errors.length > 0)
	        self.errors.pop();
	    }, 3000);
	  };
	
//	  $scope.verVuelo = function(numero) {
//    	  $state.go('tripulacionVuelo')
//    	  $scope.numeroVueloSeleccionado = numero;
//    	  self.getVueloSeleccionado();
//        };  
	function transformarAVuelo(jsonVuelo){
		  return Vuelo.asVuelo(jsonVuelo);
	  }
	  
	  self.getVuelos();
}]);


app.controller('tripulacionVueloController', function (vuelosService, vueloData, vueloSeleccionadoService, $scope) {
	
	var self = this;
	
	this.vuelo = vueloData.data;
	
	$scope.tripulantes = self.vuelo.tripulantes;
	
});
  