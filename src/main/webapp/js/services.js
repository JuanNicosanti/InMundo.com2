app.service('vuelosService', [ '$http', function ($http) {

  this.findAll = function (callback) {
    $http.get('/vuelos').then(callback);
  }
  
  this.buscar = function(numeroVuelo, callback) {
	  return $http.get('/vuelos/' + numeroVuelo).then(callback);
  }
		
}]);

app.service('vueloSeleccionadoService', [ '$http', function ($http){
	
	this.find = function(idVuelo) {
		  return $http.get('/vuelos/'+ idVuelo);
	};
}]);