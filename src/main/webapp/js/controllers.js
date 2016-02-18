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
	
	function transformarAVuelo(jsonVuelo){
		  return Vuelo.asVuelo(jsonVuelo);
	  }
	  
	  self.getVuelos();
}]);

app.controller('tripulacionVueloController', function (vuelosService, vueloData, vueloSeleccionadoService, $scope, $state) {
	
	var self = this;
	
	this.vuelo = vueloData.data;
	
	$scope.tripulantes = self.vuelo.tripulantes;
	
	self.numeroDeVuelo = self.vuelo.numero
	
	this.volverAVuelos = function(){
		$state.go('vuelos');
	}
	
	this.eliminarTripulante = function(index){
		$scope.tripulante=index.nombre;
		vueloSeleccionadoService.eliminarTripu({nombre:$scope.tripulantes[index].nombre, 
			apellido: $scope.tripulantes[index].apellido, tipoPuesto:$scope.tripulantes[index].tipoPuesto, vuelo:self.vuelo.id});
		$scope.tripulantes.splice(index,1);
	}

	this.agregar = function(){
		vueloSeleccionadoService.agregarTripulante({nombre:$scope.nuevoTripulante.nombre,apellido:$scope.nuevoTripulante.apellido,
		tipoPuesto:$scope.nuevoTripulante.tipoPuesto,vuelo:self.vuelo.id})
		$scope.tripulantes.push($scope.nuevoTripulante);
	}
    
});