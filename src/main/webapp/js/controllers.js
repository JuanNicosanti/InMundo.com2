'use strict';

app.controller('VuelosController', function (vuelosService) {

  var self = this;

  self.errors = [];
  
  
  this.getVuelos = function () {
	    vuelosService.findAll(function (data) {
	      self.vuelos = _.map(data.data, Vuelo.asVuelo);
	  });
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
});


app.controller('tripulacionVueloController',['vueloData', function (vuelosService) {
	
	var self = this
	
	self.vuelo = vueloData.data
	
	
}]);
  