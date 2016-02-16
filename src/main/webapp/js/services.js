app.service('vuelosService', function ($http) {

  this.findAll = function (callback) {
    $http.get('/vuelos').then(callback);
  }
  
  
  app.service('vueloSeleccionadoService', [ '$http', function($http) {
		
		this.find = function(idVuelo) {
			return $http.get('/vuelos/'+ idVuelo);
		};
		
  }]);
  
});